package Pr02Shop1Lv;

public abstract class ElectronicsProduct extends Product {

    private int guaranteePeriod;

    public ElectronicsProduct(String name, double price, int quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction);
        setGuaranteePeriod(guaranteePeriod);
    }

    public int getGuaranteePeriod() {
        return guaranteePeriod;
    }

    public void setGuaranteePeriod(int guaranteePeriod) {
        this.guaranteePeriod = guaranteePeriod;
    }
}
