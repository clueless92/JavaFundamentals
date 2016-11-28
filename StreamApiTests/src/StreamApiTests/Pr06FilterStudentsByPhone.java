package StreamApiTests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pr06FilterStudentsByPhone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String[]> studentList = new ArrayList<>();
        while (true) {
            String[] input = sc.nextLine().split(" ");
            if(input[0].equals("END")) {
                break;
            }
            String fullName = input[0] + " " + input[1];
            String phone = input[2];
            studentList.add(new String[] {fullName, phone});
        }

        studentList.stream().filter(student -> {
            String phone = student[1];
            return phone.startsWith("02") || phone.startsWith("+3592");
        }).forEach(student -> {
            System.out.println(student[0]);
        });
    }
}
