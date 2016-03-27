package OOPSampleExam07Dec2015.Models.Employees;

import OOPSampleExam07Dec2015.Models.Interfaces.Manageable;

public class CTO extends Employee {
    private static final double CTO_SALARY_FACTOR = -0.02d;

    public CTO(String firstName, String lastName, Manageable organisationalUnit) {
        super(firstName, lastName, organisationalUnit);
        this.setSalaryFactor(CTO_SALARY_FACTOR);
    }
}
