package OOPSampleExam07Dec2015.Models.Employees;

import OOPSampleExam07Dec2015.Models.Interfaces.Manageable;

public class CleaningLady extends Employee {
    private static final double CLEANING_LADY_SALARY_FACTOR = -0.02d;

    public CleaningLady(String firstName, String lastName, Manageable organisationalUnit) {
        super(firstName, lastName, organisationalUnit);
        this.setSalaryFactor(CLEANING_LADY_SALARY_FACTOR);
    }
}
