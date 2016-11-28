package Hw02SetsAndMaps;

import java.util.HashMap;
import java.util.Scanner;

public class Pr05Phonebook {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        HashMap<String, String> phonebook = new HashMap<>();

        while (!command.equals("search") && !command.equals("stop")) {
            String[] tokens = command.split("-");
            phonebook.put(tokens[0], tokens[1]);
            command = sc.nextLine();
        }

        if (command.equals("search") || !command.equals("stop")) {
            command = sc.nextLine();
        }

        while (!command.equals("stop")) {
            if (phonebook.containsKey(command)) {
                System.out.printf("%s -> %s%n", command, phonebook.get(command));
            }
            else {
                System.out.printf("Contact %s does not exist.%n", command);
            }

            command = sc.nextLine();
        }
    }
}
