package JavaExam1June2014;

import java.util.*;

public class Pr04LogsWithThreeMaps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numsOfInputLines = scanner.nextInt();
        scanner.nextLine();

        TreeMap<String, Integer> logDuration = new TreeMap<>();
        HashMap<String, TreeSet<String>> logIp = new HashMap<>();

        for (int i = 0; i < numsOfInputLines; i++) {
            String[] tokens = scanner.nextLine().trim().split(" ");
            String ipAddress = tokens[0];
            String name = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            Integer res = logDuration.get(name);
            if (res == null) {
                res = 0;
            }

            logDuration.put(name, res + duration);

            TreeSet<String> resIp = logIp.get(name);
            if (resIp == null) {
                resIp = new TreeSet<>();
            }
            resIp.add(ipAddress);
            logIp.put(name, resIp);
        }

        for (Map.Entry<String, Integer> entry : logDuration.entrySet()) {
            System.out.printf("%s: %d " + logIp.get(entry.getKey()) + "\n", entry.getKey(), entry.getValue());
        }
    }
}