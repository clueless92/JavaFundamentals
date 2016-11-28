package Hw02SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pr13SrybskoUnleashed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        LinkedHashMap<String, LinkedHashMap<String, Integer>> chalgaMap = new LinkedHashMap<>();
        do {
            String[] input = line.split("@");
            String singer = input[0];
            if (singer.charAt(singer.length() - 1) != ' ') {
                line = sc.nextLine();
                continue;
            }
            String[] others = input[1].split(" ");
            int price;
            int count;
            try {
                price = Integer.parseInt(others[others.length - 2]);
                count = Integer.parseInt(others[others.length - 1]);
            } catch (Exception e) {
                line = sc.nextLine();
                continue;
            }
            StringBuilder venueBuilder = new StringBuilder();
            for (int i = 0; i < others.length - 2; i++) {
                venueBuilder.append(others[i]);
                venueBuilder.append(" ");
            }
            String venue = venueBuilder.toString().trim();
            int revenue = price * count;
            if (!chalgaMap.containsKey(venue)) {
                chalgaMap.put(venue, new LinkedHashMap<>());
            }
            if (!chalgaMap.get(venue).containsKey(singer)) {
                chalgaMap.get(venue).put(singer, revenue);
            } else {
                int toAdd = chalgaMap.get(venue).get(singer) + revenue;
                chalgaMap.get(venue).put(singer, toAdd);
            }
            line = sc.nextLine();
        } while (!line.equals("End"));

        for (String venueKey : chalgaMap.keySet()) {
            System.out.println(venueKey);
            chalgaMap.get(venueKey).entrySet().stream()
                    .sorted(Map.Entry.comparingByValue((v1, v2) -> v2.compareTo(v1)))
                    .forEach(entry -> {
                        System.out.printf("#  %s-> %d%n", entry.getKey(), entry.getValue());
                    });
        }
    }
}
