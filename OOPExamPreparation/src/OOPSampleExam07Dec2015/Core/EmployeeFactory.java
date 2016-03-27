package OOPSampleExam07Dec2015.Core;

import OOPSampleExam07Dec2015.Models.Employees.*;
import OOPSampleExam07Dec2015.Models.Interfaces.*;

public class EmployeeFactory {

    public static Employable Create(String firstName, String lastName, String position, Manageable inUnit, double salary)
            throws Exception {
        switch (position) {
            case "CEO":
                return new CEO(firstName, lastName, inUnit, salary);
            default:
                throw new Exception("Invalid position supplied");
        }
    }

    public static Employable Create(String firstName, String lastName, String position, Manageable inUnit)
            throws Exception {
        switch (position) {
            case "Manager":
                return new Manager(firstName, lastName, inUnit);
            case "Regular":
                return new Regular(firstName, lastName, inUnit);
            case "Salesman":
                return new Salesman(firstName, lastName, inUnit);
            case "CleaningLady":
                return new CleaningLady(firstName, lastName, inUnit);
            case "ChiefTelephoneOfficer":
                return new CTO(firstName, lastName, inUnit);
            case "Accountant":
                return new Accountant(firstName, lastName, inUnit);
            default:
                throw new Exception("Invalid position supplied");
        }
    }
}
