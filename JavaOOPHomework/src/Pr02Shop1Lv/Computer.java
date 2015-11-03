package Pr02Shop1Lv;

public class Computer extends ElectronicsProduct {

    private static final int GUARANTEE_PERIOD_COMPUTER = 24;

    public Computer(String name, double price, int quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction);
        setGuaranteePeriod(GUARANTEE_PERIOD_COMPUTER);
    }

    @Override
    public double getPrice() {
        double price = super.getPrice();
        if (getQuantity() > 1000) {
            price *= 0.95;
        }
        return price;
    }

    @Override
    public String toString() {
        String text = "Computer: %s, price: %.2flv, quantity: %d, age restriction: %s, guarantee period: %d months";
        String productInfo = String.format(text, getName(), getPrice(),
                getQuantity(), getAgeRestriction(), GUARANTEE_PERIOD_COMPUTER);
        return productInfo;
    }
}
