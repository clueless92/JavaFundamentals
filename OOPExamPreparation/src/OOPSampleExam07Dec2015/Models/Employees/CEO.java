package OOPSampleExam07Dec2015.Models.Employees;

import OOPSampleExam07Dec2015.Models.Interfaces.Manageable;

public class CEO extends Employee {

    private double salary;

    public CEO(String firstName, String lastName, Manageable organisationalUnit, double salary) {
        super(firstName, lastName, organisationalUnit);
        this.setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double RecieveSalary(double percents, double ceoSalary) {
         this.setTotalPaid(this.getTotalPaid() + this.getSalary());

        return this.getSalary();
    }
}
