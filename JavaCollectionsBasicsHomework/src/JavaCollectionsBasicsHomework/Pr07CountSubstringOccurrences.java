package JavaCollectionsBasicsHomework;

import java.util.Scanner;

public class Pr07CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        text = text.toLowerCase();
        String word = sc.nextLine();
        word = word.toLowerCase();
        int matches = 0;
        int textSize = text.length();
        int wordSize = word.length();
        for (int i = 0; i <= textSize - wordSize; i++) {
            String wordToCheck = text.substring(i, wordSize + i);
            if (wordToCheck.equals(word)) {
                matches++;
            }
        }
        System.out.println(matches);
    }
}
