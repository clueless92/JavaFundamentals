package Hw05ManualStringProcessing;

import java.util.Scanner;

public class Pr10UnicodeCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            String hexFormat = Integer.toString((int) input.charAt(i), 16);
            int len = hexFormat.length();
            while (len < 4) {
                hexFormat = "0" + hexFormat;
                len = hexFormat.length();
            }

            output.append(String.format("\\u%s", hexFormat));
        }

        System.out.println(output);
    }
}
