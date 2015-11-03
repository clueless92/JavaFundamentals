package Pr02Shop1Lv;

import Pr02Shop1Lv.Exceptions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PurchaseManager {
    public static void processPurchase(Product product, Customer customer) throws Exception {
        if (product.getQuantity() < 1) {
            String msg = String.format("Sorry, %s, the product \"%s\" is out of stock.",
                    customer.getName(), product.getName());
            throw new ProductOutOfStockException(msg);
        }
        if (product instanceof Expirable && ((FoodProduct)product).getDaysToExpiration() < 1) {
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String date = formatter.format(((FoodProduct)product).getExpirationDate());
            String msg = String.format("Sorry, %s, the product \"%s\" has expired on %s.",
                    customer.getName(), product.getName(), date);
            throw new ProductHasExpiredException(msg);
        }
        if (customer.getBalance() < product.getPrice()) {
            double cost = product.getPrice();
            double balance = customer.getBalance();
            String productName = product.getName();
            String msg = String.format("Find a job, %s! \"%s\" costs %.2flv and you only have %.2flv.",
                    customer.getName(), productName, cost, balance);
            throw new NotEnoughMoneyException(msg);
        }
        if (product.getAgeRestriction() == AgeRestriction.Teenager && customer.getAge() < 13) {
            String msg = String.format("Sorry, %s, you must be atleast 13 years old to buy \"%s\".",
                    customer.getName(), product.getName());
            throw new PermissionToPurchaseException(msg);
        } else if (product.getAgeRestriction() == AgeRestriction.Adult && customer.getAge() < 18) {
            String msg = String.format("Sorry, %s, you must be atleast 18 years old to buy \"%s\".",
                    customer.getName(), product.getName());
            throw new PermissionToPurchaseException(msg);
        }
        product.setQuantity(product.getQuantity() - 1);
        customer.setBalance(customer.getBalance() - product.getPrice());
    }
}
