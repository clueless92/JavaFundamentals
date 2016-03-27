package OOPSampleExam07Dec2015.Commands;

import OOPSampleExam07Dec2015.Interfaces.Database;
import OOPSampleExam07Dec2015.Models.Interfaces.Employable;
import OOPSampleExam07Dec2015.Models.Interfaces.Manageable;
import OOPSampleExam07Dec2015.Models.OrganizationalUnits.Company;

import java.util.Objects;

public class ShowEmployeesCommand extends CommandAbstract {

    private String companyName;
    private StringBuilder output;

    public ShowEmployeesCommand(String companyName, Database db) {
        super(db);
        this.companyName = companyName;
        this.output = new StringBuilder();
    }

    @Override
    public String execute() throws Exception {
        Company company = null;
        for (Manageable c : this.db.getCompanies()) {
            if (Objects.equals(c.getName(), this.companyName)) {
                company = (Company) c;
                break;
            }
        }
        if (company == null) {
            throw new Exception(String.format("Company %s does not exist", this.companyName));
        }
        PrintHierarchy(company, 0);
        return this.output.toString();
    }

    private void PrintHierarchy(Manageable unit, int depth) {
        String spaces = getIndent(depth);
        this.output.append(String.format("%s(%s)%n", spaces, unit.getName()));
        for (Employable employee : unit.getEmployees()) {
            this.output.append(String.format("%s%s %s (%.2f)%n",
                    spaces, employee.getFisrtName(), employee.getLastName(), employee.getTotalPaid()));
        }
        for (Manageable subUnit : unit.getSubUnits()) {
            this.PrintHierarchy(subUnit, depth + 1);
        }
    }
}
