package OOPSampleExam07Dec2015.Commands;

import OOPSampleExam07Dec2015.Interfaces.Database;
import OOPSampleExam07Dec2015.Models.Employees.CEO;
import OOPSampleExam07Dec2015.Models.Interfaces.Employable;
import OOPSampleExam07Dec2015.Models.Interfaces.Manageable;
import OOPSampleExam07Dec2015.Models.OrganizationalUnits.Company;

import java.util.Objects;

public class PaySalariesCommand extends CommandAbstract {

    private String companyName;
    private CEO ceo;
    private StringBuilder output;

    public PaySalariesCommand(String companyName, Database db) {
        super(db);
        this.companyName = companyName;
        this.output = new StringBuilder();
    }

    private double pay(Manageable unit, double paid, int depth) {
        for (Manageable dep : unit.getSubUnits()) {
            paid += this.pay(dep, 0, depth + 1);
        }
        for (Employable emp : unit.getEmployees()) {
            double percents = (15 - depth) * 0.01d;
            paid += emp.RecieveSalary(percents, this.ceo.getSalary());
        }
        String spaces = getIndent(depth);
        this.output.insert(0, String.format("%s%s (%.2f)%n", spaces, unit.getName(), paid).toCharArray());
        return paid;
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
        ceo = (CEO)company.getBoss();
        this.pay(company, 0, 0);
        return this.output.toString();
    }
}
