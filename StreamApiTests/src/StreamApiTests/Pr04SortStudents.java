package StreamApiTests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pr04SortStudents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String[]> studentList = new ArrayList<>();
        while (true) {
            String[] input = sc.nextLine().split(" ");
            if(input[0].equals("END")) {
                break;
            }
            String firstName = input[0];
            String lastName = input[1];
            studentList.add(new String[] {firstName, lastName});
        }

        studentList.stream().sorted((s1, s2) -> {
            String lastName1 = s1[1];
            String lastName2 = s2[1];
            int result = lastName1.compareTo(lastName2);
            if (result == 0) {
                String firstName1 = s1[0];
                String firstName2 = s2[0];
                result = firstName2.compareTo(firstName1);
            }
            return result;
        }).forEach(student -> {
            System.out.printf("%s %s%n", student[0], student[1]);
        });
    }
}
