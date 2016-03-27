package OOPSampleExam07Dec2015.Commands;

import OOPSampleExam07Dec2015.Core.EmployeeFactory;
import OOPSampleExam07Dec2015.Interfaces.Database;
import OOPSampleExam07Dec2015.Models.Interfaces.Employable;
import OOPSampleExam07Dec2015.Models.Interfaces.Manageable;
import OOPSampleExam07Dec2015.Models.OrganizationalUnits.Company;

import java.util.Objects;

public class CreateCompanyCommand extends CommandAbstract {

    private String companyName;
    private String ceoFirstName;
    private String ceoLastName;
    private double ceoSalary;

    public CreateCompanyCommand(Database db, String companyName, String ceoFirstName,
                                String ceoLastName, double ceoSalary) {
        super(db);
        this.companyName = companyName;
        this.ceoFirstName = ceoFirstName;
        this.ceoLastName = ceoLastName;
        this.ceoSalary = ceoSalary;
    }

    @Override
    public String execute() throws Exception {
        for (Manageable c : this.db.getCompanies()) {
            if (Objects.equals(c.getName(), this.companyName)) {
                throw new Exception(String.format("Company %s already exists", this.companyName));
            }
        }

        Manageable company = new Company(this.companyName);
        Employable ceo = EmployeeFactory.Create(this.ceoFirstName, this.ceoLastName, "CEO", company, this.ceoSalary);
        this.db.addCompany(company);
        company.AddEmployee(ceo);
        company.setBoss(ceo);
        return "";
    }
}
