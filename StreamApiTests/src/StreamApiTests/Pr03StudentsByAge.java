package StreamApiTests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pr03StudentsByAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String[]> studMap = new ArrayList<>();
        while (true) {
            String[] input = sc.nextLine().split(" ");
            if(input[0].equals("END")) {
                break;
            }
            String fullName = input[0] + " " + input[1];
            String age = input[2];
            studMap.add(new String[]{fullName, age});
        }

        studMap.stream()
                .filter(student -> {
                    int age = Integer.parseInt(student[1]);
                    return age >= 18 && age <= 24;
                })
                .forEach(student -> {
                    System.out.printf("%s %d%n", student[0], Integer.parseInt(student[1]));
                });
    }
}
