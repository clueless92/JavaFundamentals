package JavaExam15Oct2015Live;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr04LogParserOOP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, Log> totalMap = new TreeMap<>();

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
                totalMap.put(projName, new Log());
            }

            totalMap.get(projName).count++;

            if(type.equals("Warning")) {
                totalMap.get(projName).warningMsgs.add(message);
            } else { // Critical
                totalMap.get(projName).criticalMsgs.add(message);
            }
        }

        totalMap.entrySet().stream()
                .sorted()
                .forEach(entry -> {
                    String name = entry.getKey();
                    System.out.printf("%s:%n", name);
                    System.out.printf("Total Errors: %d%n", entry.getValue().count);

                    System.out.printf("Critical: %d%n", entry.getValue().criticalMsgs.size());
                    System.out.printf("Warnings: %d%n", entry.getValue().warningMsgs.size());

                    System.out.println("Critical Messages:");
                    ArrayList<String> criticals = entry.getValue().criticalMsgs;
                    criticals.sort(Comparator.<String>naturalOrder());
                    criticals.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
                    for (String msg : criticals) {
                        System.out.printf("--->%s%n", msg);
                    }
                    if (criticals.size() == 0) {
                        System.out.println("--->None");
                    }

                    System.out.println("Warning Messages:");
                    ArrayList<String> warnings = entry.getValue().warningMsgs;
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

    static class Log implements Comparable {
        public ArrayList<String> criticalMsgs;
        public ArrayList<String> warningMsgs;
        public int count;
        public String name;

        public Log() {
            criticalMsgs = new ArrayList<>();
            warningMsgs = new ArrayList<>();
            count = 0;
        }

        @Override
        public int compareTo(Object o) {
            Log other = (Log) o;
            return Integer.compare(this.count, other.count);
        }
    }
}
