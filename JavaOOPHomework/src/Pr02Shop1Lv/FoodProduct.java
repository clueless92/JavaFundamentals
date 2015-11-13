package Pr02Shop1Lv;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FoodProduct extends Product implements Expirable {

    private Date expirationDate;

    public FoodProduct(String name, double price, int quantity, AgeRestriction ageRestriction, String exprirationDate) {
        super(name, price, quantity, ageRestriction);
        setExpirationDate(exprirationDate);
    }

    public int getDaysToExpiration() {
        long now = new Date().getTime();
        long period = (getExpirationDate().getTime() - now);
        int days = (int) TimeUnit.DAYS.convert(period, TimeUnit.MILLISECONDS);
        return days;
    }

    @Override
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = formatter.parse(expirationDate);
        } catch (ParseException e) {
            System.out.println(e.getMessage() + ". Please, use date format: \"dd-MM-yyyy\".");
        }
        this.expirationDate = date;
    }

    @Override
    public double getPrice() {
        double price = super.getPrice();
        if (getDaysToExpiration() <= 15) {
            price *= 0.7;
        }
        return price;
    }

    @Override
    public String toString() {
        String superInfo = super.toString();
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String date = formatter.format(getExpirationDate());
        String thisInfo = String.format("%s, expiration date: %s", superInfo, date);
        return thisInfo;
    }
}
