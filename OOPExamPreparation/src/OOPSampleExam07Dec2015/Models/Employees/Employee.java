package OOPSampleExam07Dec2015.Models.Employees;

import OOPSampleExam07Dec2015.Models.Interfaces.Employable;
import OOPSampleExam07Dec2015.Models.Interfaces.Manageable;

public abstract class Employee implements Employable {

    private static final double DEFAULT_SALARY_FACTOR = 0d;

    private String firstName;
    private String lastName;
    private Manageable organisationalUnit;
    private double totalPaid;
    private double salaryFactor;

    public Employee(String firstName, String lastName, Manageable organisationalUnit) {
        setFirstName(firstName);
        setLastName(lastName);
        setOrganisationalUnit(organisationalUnit);
        setSalaryFactor(DEFAULT_SALARY_FACTOR);
    }

    @Override
    public String getFisrtName() {
        return firstName;
    }

    protected void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    protected void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public double getSalaryFactor() {
        return this.salaryFactor;
    }

    protected void setSalaryFactor(double salaryFactor) {
        this.salaryFactor = salaryFactor;
    }

    @Override
    public Manageable getOrganisationalUnit() {
        return this.organisationalUnit;
    }

    @Override
    public void setOrganisationalUnit(Manageable organisationalUnit) {
        this.organisationalUnit = organisationalUnit;
    }

    @Override
    public double getTotalPaid() {
        return this.totalPaid;
    }

    @Override
    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    @Override
    public double RecieveSalary(double percents, double ceoSalary) {
        double toPay = ceoSalary * percents;
        toPay = toPay + toPay * this.getSalaryFactor();
        this.setTotalPaid(this.getTotalPaid() + toPay);
        return toPay;
    }
}
