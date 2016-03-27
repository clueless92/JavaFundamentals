package OOPSampleExam07Dec2015.Models.Interfaces;

public interface Employable {

    String getFisrtName();

    String getLastName();

    double getSalaryFactor();

    Manageable getOrganisationalUnit();

    void setOrganisationalUnit(Manageable organisationalUnit);

    double getTotalPaid();

    void setTotalPaid(double totalPaid);

    double RecieveSalary(double percents, double ceoSalary);
}
