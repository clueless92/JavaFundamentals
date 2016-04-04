package JavaExam15Oct2015Live;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr04LogParser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, Integer> totalMap = new TreeMap<>();
        HashMap<String, ArrayList<String>> criticalMap = new HashMap<>();
        HashMap<String, ArrayList<String>> warningMap = new HashMap<>();

        Pattern pattern = Pattern
                .compile("\\[\"(.+?)\"\\].*\\[\"(.+?)\"\\].*\\[\"(.+?)\"\\]");
        while (true) {
            String input = sc.nextLine();
            if (input.equals("END")) {
                break;
            }

            Matcher matcher = pattern.matcher(input);
            if(!matcher.find()) {
                continue;
            }

            String projName = matcher.group(1);
            String type = matcher.group(2);
            String message = matcher.group(3);

            if(!totalMap.containsKey(projName)) {
                totalMap.put(projName, 0);
                criticalMap.put(projName, new ArrayList<>());
                warningMap.put(projName, new ArrayList<>());
            }

            int incrementor = totalMap.get(projName) + 1;
            totalMap.put(projName, incrementor);

            if(type.equals("Warning")) {
                warningMap.get(projName).add(message);
            } else { // Critical
                criticalMap.get(projName).add(message);
            }
        }

        totalMap.entrySet().stream()
                .sorted((pair1, pair2) ->
                        Integer.compare(pair2.getValue(), pair1.getValue()))
                .forEach(entry -> {
                    String name = entry.getKey();
                    System.out.printf("%s:%n", name);
                    System.out.printf("Total Errors: %d%n", entry.getValue());

                    System.out.printf("Critical: %d%n", criticalMap.get(name).size());
                    System.out.printf("Warnings: %d%n", warningMap.get(name).size());

                    System.out.println("Critical Messages:");
                    ArrayList<String> criticals = criticalMap.get(name);
                    criticals.sort(Comparator.<String>naturalOrder());
                    criticals.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
                    for (String msg : criticals) {
                        System.out.printf("--->%s%n", msg);
                    }
                    if (criticals.size() == 0) {
                        System.out.println("--->None");
                    }

                    System.out.println("Warning Messages:");
                    ArrayList<String> warnings = warningMap.get(name);
                    warnings.sort(Comparator.<String>naturalOrder());
                    warnings.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
                    for (String msg : warnings) {
                        System.out.printf("--->%s%n", msg);
                    }
                    if (warnings.size() == 0) {
                        System.out.println("--->None");
                    }

                    System.out.println();
                });

    }
}
