package StreamApiTests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pr05FilterStudentsByEmailDomain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String[]> studentList = new ArrayList<>();
        while (true) {
            String[] input = sc.nextLine().split(" ");
            if(input[0].equals("END")) {
                break;
            }
            String fullName = input[0] + " " + input[1];
            String email = input[2];
            studentList.add(new String[] {fullName, email});
        }

        studentList.stream().filter(student -> {
            int index = student[1].lastIndexOf('@');
            String domain = student[1].substring(index + 1);
            return domain.equals("gmail.com");
        }).forEach(student -> {
            System.out.println(student[0]);
        });
    }
}
