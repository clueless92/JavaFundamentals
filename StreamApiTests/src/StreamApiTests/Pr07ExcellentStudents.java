package StreamApiTests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pr07ExcellentStudents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String[]> studentList = new ArrayList<>();
        while (true) {
            String[] input = sc.nextLine().split(" ");
            if(input[0].equals("END")) {
                break;
            }
            studentList.add(input);
        }

        studentList.stream().filter(student -> {
            for (int i = 2; i < student.length; i++) {
                if(student[i].equals("6")) {
                    return true;
                }
            }
            return false;
        }).forEach(student -> {
            System.out.printf("%s %s%n", student[0], student[1]);
        });
    }
}
