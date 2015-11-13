package JavaBasicsExam8thFebruary2015;

import java.util.*;

public class Pr04UserLogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> usersMap = new TreeMap<>();
        while (!input.equals("end")) {
            String[] inputParts = input.split(" ");
            String userName = inputParts[2].substring(5);
            String address = inputParts[0].substring(3);
            if (!usersMap.containsKey(userName)) {
                usersMap.put(userName, new LinkedHashMap<>());
            }
            if (!usersMap.get(userName).containsKey(address)) {
                usersMap.get(userName).put(address, 1);
            } else {
                int value = usersMap.get(userName).get(address) + 1;
                usersMap.get(userName).put(address, value);
            }
            input = sc.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> pair : usersMap.entrySet()) {
            System.out.println(String.format("%s:",pair.getKey()));
            HashMap<String, Integer> innerMap = pair.getValue();
            StringBuilder outputBuilder = new StringBuilder();
            for (Map.Entry<String, Integer> innerPair : innerMap.entrySet()) {
                outputBuilder.append(String.format("%s => %d, ", innerPair.getKey(), innerPair.getValue()));
            }
            String output = outputBuilder.substring(0, outputBuilder.length() - 2);
            System.out.println(String.format("%s.", output));
        }
    }
}
