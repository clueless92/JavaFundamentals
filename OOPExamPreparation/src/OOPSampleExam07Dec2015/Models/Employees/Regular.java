package OOPSampleExam07Dec2015.Models.Employees;

import OOPSampleExam07Dec2015.Models.Interfaces.Manageable;

public class Regular extends Employee {
    public Regular(String firstName, String lastName, Manageable organisationalUnit) {
        super(firstName, lastName, organisationalUnit);
    }
}
