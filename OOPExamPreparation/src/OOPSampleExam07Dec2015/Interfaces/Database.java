package OOPSampleExam07Dec2015.Interfaces;

import OOPSampleExam07Dec2015.Models.Interfaces.Manageable;

import java.util.List;

public interface Database {

    List<Manageable> getCompanies();

    void addCompany(Manageable company);

}
