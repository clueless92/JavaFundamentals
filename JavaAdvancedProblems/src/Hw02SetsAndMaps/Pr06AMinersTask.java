package Hw02SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pr06AMinersTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String resource = sc.nextLine();
        long quantity = 0;

        LinkedHashMap<String, Long> resources = new LinkedHashMap<>();
        int counter = 0;
        while (!resource.equals("stop")) {
            quantity = Integer.parseInt(sc.nextLine());

            if (!resources.containsKey(resource)) {
                resources.put(resource, quantity);
            }
            else {
                long currQuantity = resources.get(resource);
                resources.replace(resource, currQuantity + quantity);
            }

            resource = sc.nextLine();
        }

        for (Map.Entry<String, Long> pair : resources.entrySet()) {
            System.out.printf("%s -> %s%n", pair.getKey(), pair.getValue());
        }
    }
}
