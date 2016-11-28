package Hw05ManualStringProcessing;

import java.util.Scanner;

public class Pr06CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String word = sc.nextLine();
        text = text.toLowerCase();
        word = word.toLowerCase();
        int counter = 0;
        for (int i = 0; i <= text.length() - word.length(); i++) {
            boolean isSubString = text.substring(i, i + word.length()).equals(word);
            if (isSubString) {
                counter++;
            }
        }

        System.out.println(counter);
    }
}
