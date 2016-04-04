package JavaExam15Oct2015Mine;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr04LogParserManyMaps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, Integer> totalMap = new TreeMap<>();
        TreeMap<String, ArrayList<String>> criticalMap = new TreeMap<>();
        TreeMap<String, ArrayList<String>> warningMap = new TreeMap<>();

        Pattern pattern = Pattern.compile("\\[\"(.+?)\"\\].+\\[\"(.+?)\"\\].+\\[\"(.+?)\"\\]");

        while (true) {
            String input = sc.nextLine();
            if(input.equals("END")) {
                break;
            }
            Matcher matcher = pattern.matcher(input);
            if(!matcher.find()) {
                continue;
            }
            String projectName = matcher.group(1);
            String errorType = matcher.group(2);
            String message = matcher.group(3);

            if(!totalMap.containsKey(projectName)) {
                totalMap.put(projectName, 0);
                criticalMap.put(projectName, new ArrayList<>());
                warningMap.put(projectName, new ArrayList<>());
            }

            int value = totalMap.get(projectName) + 1;
            totalMap.put(projectName, value);

            if(errorType.equals("Critical")) {
                criticalMap.get(projectName).add(message);
            } else {
                warningMap.get(projectName).add(message);
            }
        }

        totalMap.entrySet().stream()
            .sorted((pair1, pair2) -> pair2.getValue().compareTo(pair1.getValue()))
            .forEach(pair -> {
                System.out.printf("%s:%n", pair.getKey());
                System.out.printf("Total Errors: %d%n", pair.getValue());

                ArrayList<String> criticalList = criticalMap.get(pair.getKey());
                ArrayList<String> warningList = warningMap.get(pair.getKey());

                System.out.printf("Critical: %d%n", criticalList.size());
                System.out.printf("Warnings: %d%n", warningList.size());

                System.out.println("Critical Messages:");
                criticalList.sort(String.CASE_INSENSITIVE_ORDER);
                criticalList.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
                for (String message : criticalList) {
                    System.out.printf("--->%s%n", message);
                }
                if (criticalList.size() == 0) {
                    System.out.println("--->None");
                }

                System.out.println("Warning Messages:");
                warningList.sort(String.CASE_INSENSITIVE_ORDER);
                warningList.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
                for (String message : warningList) {
                    System.out.printf("--->%s%n", message);
                }
                if (warningList.size() == 0) {
                    System.out.println("--->None");
                }
                System.out.println();
            });
    }
}
