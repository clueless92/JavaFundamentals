package OOPSampleExam07Dec2015.Models.Employees;

import OOPSampleExam07Dec2015.Models.Interfaces.Manageable;

public class Salesman extends Employee {
    private static final double SALESMAN_SALARY_FACTOR = 0.015d;

    public Salesman(String firstName, String lastName, Manageable organisationalUnit) {
        super(firstName, lastName, organisationalUnit);
        this.setSalaryFactor(SALESMAN_SALARY_FACTOR);
    }
}
