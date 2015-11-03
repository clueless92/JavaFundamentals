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
        String text = "Appliance: %s, price: %.2flv, quantity: %d, age restriction: %s, guarantee period: %d months";
        String productInfo = String.format(text, getName(), getPrice(),
                getQuantity(), getAgeRestriction(), GUARANTEE_PERIOD_APPLIANCE);
        return productInfo;
    }
}
