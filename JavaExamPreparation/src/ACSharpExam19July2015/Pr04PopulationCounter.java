package ACSharpExam19July2015;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pr04PopulationCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> countrys = new LinkedHashMap<>();
        LinkedHashMap<String, Long> countrysTotal = new LinkedHashMap<>();
        String line = sc.nextLine();
        while (!line.equals("report")) {
            String[] lineParts = line.split("\\|");
            String city = lineParts[0];
            String country = lineParts[1];
            long population = Long.parseLong(lineParts[2]);
            if (!countrys.containsKey(country)) {
                countrys.put(country, new LinkedHashMap<>());
                countrysTotal.put(country, 0L);
            }
            countrys.get(country).put(city, population);
            long toAdd = countrysTotal.get(country) + population;
            countrysTotal.put(country, toAdd);
            line = sc.nextLine();
        }

        countrysTotal.entrySet().stream().sorted(Map.Entry.comparingByValue((v1, v2) -> v2.compareTo(v1))).forEach(pair -> {
            System.out.println(String.format("%s (total population: %d)", pair.getKey(), pair.getValue()));
            countrys.get(pair.getKey()).entrySet().stream().sorted(Map.Entry.comparingByValue((v1, v2) -> v2.compareTo(v1))).forEach(innerPair -> {
                System.out.println(String.format("=>%s: %d", innerPair.getKey(), innerPair.getValue()));
            });
        });
    }
}
