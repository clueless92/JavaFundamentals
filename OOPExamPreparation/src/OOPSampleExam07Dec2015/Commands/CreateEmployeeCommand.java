package OOPSampleExam07Dec2015.Commands;

import OOPSampleExam07Dec2015.Core.EmployeeFactory;
import OOPSampleExam07Dec2015.Interfaces.Database;
import OOPSampleExam07Dec2015.Models.Interfaces.Employable;
import OOPSampleExam07Dec2015.Models.Interfaces.Manageable;
import OOPSampleExam07Dec2015.Models.OrganizationalUnits.Company;

import java.util.Objects;

public class CreateEmployeeCommand extends CommandAbstract {

    private String companyName;
    private String departmentName;
    private String firstName;
    private String lastName;
    private String position;

    public CreateEmployeeCommand(Database db, String firstName, String lastName, String position,
                                 String companyName, String departmentName) {
        super(db);
        this.companyName = companyName;
        this.departmentName = departmentName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public CreateEmployeeCommand(Database db, String firstName, String lastName, String position,
                                 String companyName) {
        super(db);
        this.companyName = companyName;
        this.departmentName = null;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
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

        for (Employable e : company.getAllEmployees()) {
            if (Objects.equals(e.getFisrtName(), this.firstName) && Objects.equals(e.getLastName(), this.lastName)) {
                if (e.getOrganisationalUnit() instanceof Company) {
                    throw new Exception(String.format("Employee %s %s already exists in %s (no department)",
                            this.firstName, this.lastName, this.companyName));
                } else {
                    throw new Exception(String.format("Employee %s %s already exists in %s (in department %s)",
                            this.firstName, this.lastName, this.companyName, e.getOrganisationalUnit().getName()));
                }
            }
        }

        Manageable inUnit = company;
        if (this.departmentName != null) {
            for (Manageable d : company.getAllDepartments()) {
                if (d.getName().equals(this.departmentName)) {
                    inUnit = d;
                    break;
                }
            }
        }

        Employable employee = EmployeeFactory.Create(this.firstName, this.lastName, this.position, inUnit);
        company.getAllEmployees().add(employee);
        inUnit.AddEmployee(employee);
        return "";
    }
}
