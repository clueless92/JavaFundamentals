package Hw02SetsAndMaps;

import java.util.*;

public class Pr12LegendaryFarming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, Integer> legendaryMap = new TreeMap<>();
        legendaryMap.put("fragments", 0);
        legendaryMap.put("shards", 0);
        legendaryMap.put("motes", 0);
        TreeMap<String, Integer> junkMap = new TreeMap<>();
        String obtainedItem = "";
        boolean toBreak = false;
        while (obtainedItem.equals("")) {
            String[] mats = sc.nextLine().toLowerCase().split(" ");
            for (int i = 0; i < mats.length - 1; i += 2) {
                int amount = Integer.parseInt(mats[i]);
                String material = mats[i + 1];
                if (legendaryMap.containsKey(material)) {
                    int toAdd = legendaryMap.get(material) + amount;
                    legendaryMap.put(material, toAdd);
                } else { // junk
                    if (!junkMap.containsKey(material)) {
                        junkMap.put(material, amount);
                    } else {
                        int toAdd = junkMap.get(material) + amount;
                        junkMap.put(material, toAdd);
                    }
                }
                if (legendaryMap.get("shards") >= 250) {
                    obtainedItem = "Shadowmourne obtained!";
                    int remaining = legendaryMap.get("shards") - 250;
                    legendaryMap.put("shards", remaining);
                    break;
                } else if (legendaryMap.get("motes") >= 250) {
                    obtainedItem = "Dragonwrath obtained!";
                    int remaining = legendaryMap.get("motes") - 250;
                    legendaryMap.put("motes", remaining);
                    break;
                } else if (legendaryMap.get("fragments") >= 250) {
                    obtainedItem = "Valanyr obtained!";
                    int remaining = legendaryMap.get("fragments") - 250;
                    legendaryMap.put("fragments", remaining);
                    break;
                }
            }
        }
        System.out.println(obtainedItem);
        legendaryMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((v1, v2) -> v2.compareTo(v1))).forEach(entry -> {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        });
        for (String key : junkMap.keySet()) {
            System.out.printf("%s: %d%n", key, junkMap.get(key));
        }
    }
}
