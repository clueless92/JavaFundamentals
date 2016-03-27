package OOPSampleExam07Dec2015.Core;

import OOPSampleExam07Dec2015.Interfaces.Database;
import OOPSampleExam07Dec2015.Models.Interfaces.Manageable;

import java.util.ArrayList;
import java.util.List;

public class CapitalistDatabase implements Database {

    private List<Manageable> companies;

    public CapitalistDatabase() {
        this.companies = new ArrayList<Manageable>();
    }

    @Override
    public List<Manageable> getCompanies() {
        return this.companies;
    }

    @Override
    public void addCompany(Manageable company) {
        this.companies.add(company);
    }

}
