package Pr02Shop1Lv;

import com.sun.javaws.exceptions.InvalidArgumentException;

public abstract class Product implements Buyable {

    private String name;
    private double price;
    private int quantity;
    private AgeRestriction ageRestriction;

    public Product(String name, double price, int quantity, AgeRestriction ageRestriction) {
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setAgeRestriction(ageRestriction);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty() || name.equals(null)) {
            throw new IllegalArgumentException("Product name cannot be empty or null.");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0.0d) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0.0d) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.quantity = quantity;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    @Override
    public String toString() {
        String type = getClass().toString().substring(18);
        String text = "%s: %s, price: %.2flv, quantity: %d, age restriction: %s";
        String productInfo = String.format(text, type, getName(), getPrice(),
                getQuantity(), getAgeRestriction());
        return productInfo;
    }
}
