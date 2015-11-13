package JavaBasicsExam8thFebruary2015;

import java.util.Scanner;

public class Pr02LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split("\\s+");
        double sum = 0;
        for (String word : words) {
            char firstLetter = word.charAt(0);
            char secondLetter = word.charAt(word.length() - 1);
            double num = Double.parseDouble(word.substring(1, word.length() - 1));
            if (Character.isLowerCase(firstLetter)) {
                num *= (double) (firstLetter - 'a' + 1);
            } else {
                num /= (double) (firstLetter - 'A' + 1);
            }
            if (Character.isLowerCase(secondLetter)) {
                num += (double) (secondLetter - 'a' + 1);
            } else {
                num -= (double) (secondLetter - 'A' + 1);
            }
            sum += num;
        }
        System.out.println(String.format("%.2f", sum));
    }
}
