package JavaExam15Oct2015Mine;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Pr04LogParserSingleMap {

    public static void main(String[] args) {

        HashMap<String, TreeMap<String, List<String>>> report = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\{\"Project\": \\[\"(.+?)\"], \"Type\": \\[\"(.+?)\"], \"Message\": \\[\"(.+?)\"]}");
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {

                String projectName = matcher.group(1);
                String typeError = matcher.group(2);
                String msg = matcher.group(3);

                if (!report.containsKey(projectName)) {
                    report.put(projectName, new TreeMap<>());
                }
                if (!report.get(projectName).containsKey(typeError)) {
                    report.get(projectName).put(typeError, new ArrayList<>());
                }
                report.get(projectName).get(typeError).add(msg);
            }

            input = scanner.nextLine();

        }


        LinkedHashMap<String, TreeMap<String, List<String>>> sortedReport = new LinkedHashMap<>();
        report.entrySet().stream()
                .sorted((e1, e2) -> {
                    Integer val1 = e1.getValue().values().stream().collect(Collectors.summingInt(value -> value.size()));
                    Integer val2 = e2.getValue().values().stream().collect(Collectors.summingInt(value -> value.size()));
                    if (val1 != val2){
                        return val2.compareTo(val1);
                    }
                    return e1.getKey().compareTo(e2.getKey());
                })
                .forEach(e -> sortedReport.put(e.getKey(), e.getValue()));

        int count = sortedReport.size();
        for (Map.Entry<String, TreeMap<String, List<String>>> stringTreeMapEntry : sortedReport.entrySet()) {
            count--;
            System.out.printf("%s:\n", stringTreeMapEntry.getKey());
            System.out.printf("Total Errors: %d\n", stringTreeMapEntry.getValue().values().stream().collect(Collectors.summingInt(v -> v.size())));

            if (!stringTreeMapEntry.getValue().containsKey("Critical")) {
                System.out.printf("Critical: %d\n", 0);
            } else {
                System.out.printf("Critical: %d\n", stringTreeMapEntry.getValue().get("Critical").size());
            }

            if (!stringTreeMapEntry.getValue().containsKey("Warning")) {
                System.out.printf("Warnings: %d\n", 0);
            } else {
                System.out.printf("Warnings: %d\n", stringTreeMapEntry.getValue().get("Warning").size());
            }

            System.out.println("Critical Messages:");
            if (!stringTreeMapEntry.getValue().containsKey("Critical")) {
                System.out.println("--->None");

            } else {
                stringTreeMapEntry.getValue().get("Critical").stream().sorted((m1, m2) -> {
                    if (m1.length() != m2.length()) {
                        return Integer.compare(m1.length(), m2.length());
                    }
                    return m1.compareTo(m2);
                }).forEach(m -> System.out.println("--->" + m));
            }

            System.out.println("Warning Messages:");
            if (!stringTreeMapEntry.getValue().containsKey("Warning")) {
                System.out.println("--->None");

            } else {
                stringTreeMapEntry.getValue().get("Warning").stream().sorted((m1, m2) -> {
                    if (m1.length() != m2.length()) {
                        return Integer.compare(m1.length(), m2.length());
                    }
                    return m1.compareTo(m2);
                }).forEach(m -> System.out.println("--->" + m));
            }
            if (count > 0){
                System.out.println();
            }
        }

    }
}
