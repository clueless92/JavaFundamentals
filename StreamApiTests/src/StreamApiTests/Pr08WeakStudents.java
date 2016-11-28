package StreamApiTests;

import java.util.*;

public class Pr08WeakStudents {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String readLine = scanner.nextLine();

        Map<String, List<Integer>> container = new LinkedHashMap<>();

        while (!readLine.equals("END")) {
            String[] inputTokens = readLine.split("[\\s]+");
            String name = inputTokens[0] + " " +inputTokens[1];
            List<Integer> grades = new ArrayList<>();

            for (int i = 2; i < inputTokens.length; i++) {
                grades.add(Integer.valueOf(inputTokens[i]));
            }

            container.put(name, grades);

            readLine = scanner.nextLine();
        }

        container.entrySet().stream().filter(e -> e.getValue().stream().filter(x -> x <= 3).count() >= 2).forEach
                (e -> System.out.println(e.getKey()));
    }

}

