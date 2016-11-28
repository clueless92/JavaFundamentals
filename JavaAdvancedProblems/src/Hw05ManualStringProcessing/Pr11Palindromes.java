package Hw05ManualStringProcessing;

import java.text.Collator;
import java.util.*;

public class Pr11Palindromes {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = text.split("\\W+");
        ArrayList<String> output = new ArrayList<String>();
        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder();
            for (int i = word.length() - 1; i >= 0; i--) {
                reversedWord.append(word.charAt(i));
            }
            if (word.equals(reversedWord.toString()) && !output.contains(word)) {
                output.add(word);
            }
        }
        Collator usCollator = Collator.getInstance(Locale.US);
        usCollator.setStrength(Collator.FULL_DECOMPOSITION);
        Collections.sort(output, usCollator);
        System.out.println(output);
    }
}
