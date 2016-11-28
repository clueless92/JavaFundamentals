package Hw02SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pr10PopulationCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap<>();
        LinkedHashMap<String, Long> countriesTotal = new LinkedHashMap<>();
        String line = sc.nextLine();
        while (!line.equals("report")) {
            String[] lineParts = line.split("\\|");
            String city = lineParts[0];
            String country = lineParts[1];
            long population = Long.parseLong(lineParts[2]);
            if (!countries.containsKey(country)) {
                countries.put(country, new LinkedHashMap<>());
                countriesTotal.put(country, 0L);
            }
            countries.get(country).put(city, population);
            long toAdd = countriesTotal.get(country) + population;
            countriesTotal.put(country, toAdd);
            line = sc.nextLine();
        }

        countriesTotal.entrySet().stream().sorted(Map.Entry.comparingByValue((v1, v2) -> v2.compareTo(v1))).forEach(pair -> {
            System.out.println(String.format("%s (total population: %d)", pair.getKey(), pair.getValue()));
            countries.get(pair.getKey()).entrySet().stream().sorted(Map.Entry.comparingByValue((v1, v2) -> v2.compareTo(v1))).forEach(innerPair -> {
                System.out.println(String.format("=>%s: %d", innerPair.getKey(), innerPair.getValue()));
            });
        });
    }
}
