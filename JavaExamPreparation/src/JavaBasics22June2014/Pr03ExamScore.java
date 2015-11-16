package JavaBasics22June2014;

import java.util.Scanner;
import java.util.TreeMap;

public class Pr03ExamScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, TreeMap<String, Double>> scoreMap = new TreeMap<>();
        sc.nextLine();
        sc.nextLine();
        sc.nextLine();
        String input = sc.nextLine();
        while (!input.contains("---")) {
            String[] inputParts = input.split("\\|");
            String name = inputParts[1].trim();
            Integer score = Integer.parseInt(inputParts[2].trim());
            double grade = Double.parseDouble(inputParts[3].trim());
            if (!scoreMap.containsKey(score)) {
                scoreMap.put(score, new TreeMap<>());
            }
            scoreMap.get(score).put(name, grade);
            input = sc.nextLine();
        }
        for (Integer scoreKey : scoreMap.keySet()) {
            System.out.printf("%s -> ", scoreKey);
            TreeMap<String, Double> gradeMap = scoreMap.get(scoreKey);
            double avgGrade = 0.0d;
            for (String nameKey : gradeMap.keySet()) {
                avgGrade += gradeMap.get(nameKey);
            }
            System.out.print(gradeMap.keySet());
            System.out.println(String.format("; avg=%.2f", avgGrade / gradeMap.size()));
        }
    }
}
