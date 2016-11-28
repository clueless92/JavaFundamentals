package Hw02SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pr07FixEmails {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String email = "";

        LinkedHashMap<String, String> emails = new LinkedHashMap<>();

        while (!name.equals("stop")) {
            email = sc.nextLine();
            if (!email.contains(".us") && !email.contains(".uk")) {
                emails.put(name, email);
            }

            name = sc.nextLine();
        }

        for (Map.Entry<String, String> pair : emails.entrySet()) {
            System.out.printf("%s -> %s%n", pair.getKey(), pair.getValue());
        }
    }
}
