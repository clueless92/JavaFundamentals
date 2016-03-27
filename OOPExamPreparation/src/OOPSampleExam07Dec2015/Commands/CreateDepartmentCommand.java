package OOPSampleExam07Dec2015.Commands;

import OOPSampleExam07Dec2015.Interfaces.Database;
import OOPSampleExam07Dec2015.Models.Employees.Manager;
import OOPSampleExam07Dec2015.Models.Interfaces.Employable;
import OOPSampleExam07Dec2015.Models.Interfaces.Manageable;
import OOPSampleExam07Dec2015.Models.OrganizationalUnits.Company;
import OOPSampleExam07Dec2015.Models.OrganizationalUnits.Department;

import java.util.Objects;

public class CreateDepartmentCommand extends CommandAbstract  {

    private String companyName;
    private String departmentName;
    private String managerFirstName;
    private String managerLastName;
    private String mainDepartmentName;

    public CreateDepartmentCommand(Database db, String companyName, String departmentName, String managerFirstName,
                                   String managerLastName, String mainDepartmentName) {
        super(db);
        this.companyName = companyName;
        this.departmentName = departmentName;
        this.managerFirstName = managerFirstName;
        this.managerLastName = managerLastName;
        this.mainDepartmentName = mainDepartmentName;
    }

    public CreateDepartmentCommand(Database db, String companyName, String departmentName, String managerFirstName,
                                   String managerLastName) {
        super(db);
        this.companyName = companyName;
        this.departmentName = departmentName;
        this.managerFirstName = managerFirstName;
        this.managerLastName = managerLastName;
        this.mainDepartmentName = null;
    }

    @Override
    public String execute() throws Exception {
        Company company = null;
        for (Manageable m : this.db.getCompanies()) {
            Company c = (Company) m;
            if (Objects.equals(c.getName(), this.companyName)) {
                company = c;
                break;
            }
        }

        if (company == null) {
            throw new Exception(String.format("Company %s does not exist", this.companyName));
        }

        Employable manager = null;
        Manageable mainDepartment = null;
        if (this.mainDepartmentName == null) {
            for (Employable employee : company.getEmployees()) {
                if (Objects.equals(employee.getFisrtName(), this.managerFirstName)
                        && Objects.equals(employee.getLastName(), this.managerLastName)) {
                    manager = employee;
                    break;
                }
            }

            if (manager == null) {
                throw new Exception(String.format("There is no employee called %s %s in company %s",
                        this.managerFirstName, this.managerLastName, this.companyName));
            }
        } else {
            for (Manageable d : company.getAllDepartments()) {
                if (Objects.equals(d.getName(), this.mainDepartmentName)) {
                    mainDepartment = d;
                    break;
                }
            }
            if (mainDepartment == null) {
                throw new Exception(String.format("There is no department %s in %s",
                        this.mainDepartmentName, this.companyName));
            }

            for (Employable employee : mainDepartment.getEmployees()) {
                if (Objects.equals(employee.getFisrtName(), this.managerFirstName)
                        && Objects.equals(employee.getLastName(), this.managerLastName)) {
                    manager = employee;
                    break;
                }
            }

            if (manager == null) {
                throw new Exception(String.format("There is no employee called %s %s in department %s",
                        this.managerFirstName, this.managerLastName, this.mainDepartmentName));
            }
        }
        if (!(manager instanceof Manager)) {
            String realPosition = manager.getClass().getSimpleName(); // ???
            throw new Exception(String.format("%s %s is not a manager (real position: %s)",
                    this.managerFirstName, this.managerLastName, realPosition));
        }

        for (Manageable d : company.getSubUnits()) {
            if (Objects.equals(d.getName(), this.departmentName)) {
                throw new Exception(String.format("Department %s already exists in %s",
                        this.departmentName, this.companyName));
            }
        }

        Manageable department = new Department(this.departmentName);
        department.setBoss(manager);
        if (mainDepartment != null) {
            mainDepartment.AddSubUnit(department);
        } else {
            company.AddSubUnit(department);
        }
        company.getAllDepartments().add(department);
        return "";
    }
}
