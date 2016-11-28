package Hw05ManualStringProcessing;

import java.util.Scanner;

public class Pr02StringLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder process = new StringBuilder();
        process.append(input);
        if (process.length() < 20) {
            String filter = new String(new char[20 - process.length()]).replace('\0', '*');
            process.append(filter);
            System.out.println(process);
        }
        else {
            String output = input.substring(0, 20);
            System.out.println(output);
        }
    }
}
