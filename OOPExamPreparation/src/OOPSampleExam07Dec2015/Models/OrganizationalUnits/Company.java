package OOPSampleExam07Dec2015.Models.OrganizationalUnits;

import OOPSampleExam07Dec2015.Models.Interfaces.Employable;
import OOPSampleExam07Dec2015.Models.Interfaces.Manageable;

import java.util.ArrayList;
import java.util.List;

public class Company implements Manageable {

    private String name;
    private Employable boss;
    private List<Manageable> subUnits;
    private List<Manageable> allDepartments;
    private List<Employable> employees;
    private List<Employable> allEmployees;

    public Company(String name) {
        this.setName(name);
        this.subUnits = new ArrayList<Manageable>();
        this.employees = new ArrayList<Employable>();
        this.allDepartments = new ArrayList<Manageable>();
        this.allEmployees = new ArrayList<Employable>();
    }

    public List<Manageable> getAllDepartments() {
        return this.allDepartments;
    }

    public List<Employable> getAllEmployees() {
        return this.allEmployees;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Manageable> getSubUnits() {
        return this.subUnits;
    }

    @Override
    public List<Employable> getEmployees() {
        return this.employees;
    }

    @Override
    public Employable getBoss() {
        return this.boss;
    }

    @Override
    public void setBoss(Employable boss) {
        this.boss = boss;
    }

    @Override
    public void AddSubUnit(Manageable unit) {
        this.subUnits.add(unit);
    }

    @Override
    public void AddEmployee(Employable employee) {
        this.employees.add(employee);
    }

    @Override
    public void RemoveEmployee(Employable employee) {
        this.employees.remove(employee);
    }
}
