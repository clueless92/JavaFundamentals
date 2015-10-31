package JavaExam1June2014;

import java.util.*;

public class Pr04LogsAggregator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        LinkedHashMap<String, ArrayList<String>> ipAdressesMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> durationsMap = new LinkedHashMap<>();
        int fullDuration = 0;
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            String name = input[1];
            String ipAdress = input[0];
            int duration = Integer.parseInt(input[2]);
            if (!durationsMap.containsKey(name)) {
                durationsMap.put(name, duration);
                ipAdressesMap.put(name, new ArrayList<String>());
            } else {
                int durationFull = durationsMap.get(name) + duration;
                durationsMap.put(name, durationFull);
            }
            if (!ipAdressesMap.get(name).contains(ipAdress)) {
                ipAdressesMap.get(name).add(ipAdress);
            }
        }
        List<String> names = new ArrayList<>(durationsMap.keySet());
        Collections.sort(names);
        for (String name : names) {
            List<String> ipAdresses = new ArrayList<>(ipAdressesMap.get(name));
            Collections.sort(ipAdresses);
            System.out.printf("%s: %d %s\n", name, durationsMap.get(name), ipAdresses);
        }
    }
}
