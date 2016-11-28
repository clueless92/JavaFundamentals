package StreamApiTests;

import java.util.*;
import java.util.stream.Collectors;

public class Pr09StudentsSince2014 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String readLine = scanner.nextLine();
        Map<String, List<Integer>> container = new LinkedHashMap<>();

        while (!readLine.equals("END")) {
            String[] tokens = readLine.split("[\\s]+");
            String facultyNumber = tokens[0];
            List<Integer> marks = new ArrayList<>();

            for (int i = 1; i < tokens.length; i++) {
                marks.add(Integer.valueOf(tokens[i]));
            }

            container.put(facultyNumber, marks);
            readLine = scanner.nextLine();
        }

        container.entrySet().stream().filter(e -> {
            int year = Integer.parseInt(e.getKey().substring(e.getKey().length() - 2));
            return year >= 14;
        }).forEach(e -> System.out.printf("%s%n", String.join(" ", e.getValue().stream().map(Object::toString).collect(Collectors.toList()))));
    }

}

