package OOPSampleExam07Dec2015.Models.Interfaces;

import java.util.List;

public interface Manageable {

    String getName();

    List<Manageable> getSubUnits();

    List<Employable> getEmployees();

    Employable getBoss(); // getHead?

    void setBoss(Employable boss);

    void AddSubUnit(Manageable unit);

    void AddEmployee(Employable employee);

    void RemoveEmployee(Employable employee);
}
