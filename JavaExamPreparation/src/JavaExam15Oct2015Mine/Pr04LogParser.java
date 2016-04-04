package JavaExam15Oct2015Mine;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr04LogParser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, ArrayList<String>> totalMap = new TreeMap<>();
        TreeMap<String, ArrayList<String>> criticalMap = new TreeMap<>();
        TreeMap<String, ArrayList<String>> warningMap = new TreeMap<>();

        Pattern pattern = Pattern.compile("(?m)^#([A-Za-z]+):\\s*@([A-Za-z]+)\\s*(\\d+):(\\d+)$");
        String msg = sc.nextLine();
        while (msg.compareTo("END") != 0) {
            Matcher matcher = pattern.matcher(msg);
            if (!matcher.find()) {
                msg = sc.nextLine();
                continue;
            }
            String projName = matcher.group(1);
            String errorType = matcher.group(2);
            String message = matcher.group(3);
            if (!totalMap.containsKey(projName)) {
                totalMap.put(projName, new ArrayList<>());
            }
            totalMap.get(projName).add(message);
            if (errorType.equals("Critical")) {
                if (!criticalMap.containsKey(projName)) {
                    criticalMap.put(projName, new ArrayList<>());
                }
                criticalMap.get(projName).add(message);
            } else {
                if (!warningMap.containsKey(projName)) {
                    warningMap.put(projName, new ArrayList<>());
                }
                warningMap.get(projName).add(message);
            }
            msg = sc.nextLine();
        }

        totalMap.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size())).forEach(entry -> {
                String project = entry.getKey();
                System.out.printf("%s:%n", project);
                try {
                    System.out.printf("Total Errors: %d%n", entry.getValue().size());
                } catch (Exception e) {
                    System.out.println("Total Errors: 0");
                }
                try {
                    System.out.printf("Critical: %d%n", criticalMap.get(project).size());
                } catch (Exception e) {
                    System.out.println("Critical: 0");
                }
                try {
                    System.out.printf("Warnings: %d%n", warningMap.get(project).size());
                } catch (Exception e) {
                    System.out.println("Warnings: 0");
                }
                System.out.println("Critical Messages:");
                try {
                    criticalMap.get(project).sort(Comparator.<String>naturalOrder());
                    criticalMap.get(project).stream().sorted((o1, o2) -> Integer.compare(o1.length(), o2.length())).forEach(s -> {
                        System.out.printf("--->%s%n", s);
                    }); // end criticalMap forEach
                } catch (Exception e) {
                    System.out.println("--->None");
                }
                System.out.println("Warning Messages:");
                try {
                    warningMap.get(project).sort(Comparator.<String>naturalOrder());
                    warningMap.get(project).stream().sorted((o1, o2) -> Integer.compare(o1.length(), o2.length())).forEach(s -> {
                        System.out.printf("--->%s%n", s);
                    }); // end warningMap forEach
                } catch (Exception e) {
                    System.out.println("--->None");
                }
                System.out.println();
        }); // end outer forEach

        Random r = new Random();
        r.nextInt();

    }
}
