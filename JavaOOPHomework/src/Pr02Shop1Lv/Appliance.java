package Pr02Shop1Lv;

public class Appliance extends ElectronicsProduct {

    private static final int GUARANTEE_PERIOD_APPLIANCE = 6;

    public Appliance(String name, double price, int quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction);
        setGuaranteePeriod(GUARANTEE_PERIOD_APPLIANCE);
    }

    @Override
    public double getPrice() {
        double price = super.getPrice();
        if (getQuantity() < 50) {
            price *= 1.05;
        }
        return price;
    }

    @Override
    public String toString() {
        String superInfo = super.toString();
        String thisInfo = String.format("%s, guarantee period: %d months", superInfo, GUARANTEE_PERIOD_APPLIANCE);
        return thisInfo;
    }
}
