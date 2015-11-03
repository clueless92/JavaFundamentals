package Pr02Shop1Lv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main_Pr02Shop1Lv {
    public static void main(String[] args) {

        // Test sample input (tests for NotEnoughMoneyException and PermissionToPurchaseException)
        System.out.println("----Sample input: test NotEnoughMoneyException and PermissionToPurchaseException----");
        FoodProduct cigars = new FoodProduct("420 Blaze it fgt", 6.90, 1400, AgeRestriction.Adult, "30-12-2015");
        Customer pecata = new Customer("Pecata", 17, 30.00);
        try {
            PurchaseManager.processPurchase(cigars, pecata);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Customer gopeto = new Customer("Gopeto", 18, 0.44);
        try {
            PurchaseManager.processPurchase(cigars, gopeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Test for out of stock and expired products
        System.out.println("\n----Test ProductHasExpiredException and ProductOutOfStockException----");
        cigars.setExpirationDate("30-10-2015");
        Customer koceto = new Customer("Koceto", 18, 10.44);
        try {
            PurchaseManager.processPurchase(cigars, koceto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        cigars.setQuantity(0);
        try {
            PurchaseManager.processPurchase(cigars, koceto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Test for getPrice of ElectronicsProduct
        System.out.println("\n----Test getPrice of ElectronicsProduct----");
        ElectronicsProduct computer = new Computer("Pravetz", 100.0, 1000, AgeRestriction.Teenager);
        System.out.println(computer);
        computer.setQuantity(1001);
        System.out.println(computer);
        Product appliance = new Appliance("Rahovetz", 100.0, 50, AgeRestriction.Adult);
        System.out.println(appliance);
        appliance.setQuantity(49);
        System.out.println(appliance);

        // Test for getPrice of FoodProduct
        System.out.println("\n----Test for getPrice of FoodProduct----");
        FoodProduct bread = bread = new FoodProduct("Gergana bread", 1.0, 100, AgeRestriction.None, "15-12-2015");
        System.out.println(bread);
        bread.setExpirationDate("15-11-2015");
        System.out.println(bread);

        List<Product> productsList = new ArrayList<>();
        productsList.add(appliance);
        productsList.add(cigars);
        productsList.add(bread);
        productsList.add(computer);
        productsList.add(new FoodProduct("Aquafresh", 5.00, 10, AgeRestriction.None, "15-06-2018"));
        productsList.add(new FoodProduct("Milk", 1.10, 2, AgeRestriction.None, "15-12-2015"));
        productsList.add(new FoodProduct("7Days", 0.79, 111, AgeRestriction.Teenager, "30-01-2017"));
        productsList.add(new Computer("Acer", 699.90, 20, AgeRestriction.None));
        productsList.add(new Computer("Dell", 1699.90, 2, AgeRestriction.Adult));
        productsList.add(new Appliance("Oven", 299.90, 60, AgeRestriction.None));

        Comparator<Product> byDateOfExpiry = (o1, o2) -> {
            try {
                Date expirationDate1 = ((FoodProduct) o1).getExpirationDate();
                Date expirationDate2 = ((FoodProduct) o2).getExpirationDate();
                if (expirationDate1.after(expirationDate2)) {
                    return -1;
                }
                if (expirationDate2.after(expirationDate1)) {
                    return 1;
                }
            } catch (Throwable ignore) {
            }
            return 0;
        };

        Product expirableProduct = productsList.stream()
                .filter(p -> p instanceof Expirable)
                .sorted(byDateOfExpiry)
                .findFirst()
                .get();

        // Test lambda for expirable
        System.out.println("\n----Test lambda for expirable----");
        System.out.println(expirableProduct);

        Comparator<Product> byPrice = (p1, p2) -> Double.compare(p1.getPrice(), (p2.getPrice()));

        List<Product> adultAgerestrictionByPrice = productsList.stream()
                .filter(p -> p.getAgeRestriction() == AgeRestriction.Adult)
                .sorted(byPrice)
                .collect(Collectors.toList());

        // Test lambda for expirable
        System.out.println("\n----Test lambda for age restriction----");
        for (Product product : adultAgerestrictionByPrice) {
            System.out.println(product);
        }

        List<Customer> customersList = new ArrayList<Customer>() {{
            add(gopeto);
            add(pecata);
            add(koceto);
        }};

        System.out.println("\n----Print all customers----");
        for(Customer c : customersList) {
            System.out.println(c);
        }

        System.out.println("\n----Print all products----");
        for(Product p : productsList) {
            System.out.println(p);
        }
    }
}
