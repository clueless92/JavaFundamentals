package StreamApiTests;

import java.util.*;

public class Pr13OfficeStuff {
    private static TreeMap<String, LinkedHashMap<String, Integer>> companyOrders;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        companyOrders = new TreeMap<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] order = input.substring(1, input.length() - 1).split(" - ");
            fillMap(order);
        }
        print();
    }

    private static void print() {
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : companyOrders.entrySet()) {
            System.out.printf("%s: ", entry.getKey());
            StringBuilder output = new StringBuilder();
            entry.getValue().entrySet().stream().forEach(innerEntry -> {
                String out = String.format("%s-%s", innerEntry.getKey(), innerEntry.getValue());
                output.append(String.format("%s, ", out));
            });
            System.out.println(output.substring(0, output.length() - 2));
        }
    }

    private static void fillMap(String[] order) {
        String company = order[0];
        String product = order[2];
        int amount = Integer.parseInt(order[1]);
        if (!companyOrders.containsKey(company)) {
            LinkedHashMap<String, Integer> products = new LinkedHashMap<>();
            products.put(product, 0);
            companyOrders.put(company, products);
        }
        else if (!companyOrders.get(company).containsKey(product)) {
            companyOrders.get(company).put(product, 0);
        }
        int value = companyOrders.get(company).get(product) + amount;
        companyOrders.get(company).put(product, value);
    }
}
