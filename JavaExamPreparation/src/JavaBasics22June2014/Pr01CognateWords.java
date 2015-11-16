package JavaBasics22June2014;

import java.util.Scanner;
import java.util.TreeSet;

public class Pr01CognateWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = text.split("[\\W\\d]+");
        boolean noneFound = true;
        TreeSet<String> wordSet = new TreeSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int k = 0; k < words.length; k++) {
                for (String w3 : words) {
                    if ((words[i] + words[k]).equals(w3) && i != k) {
                        wordSet.add(String.format("%s|%s=%s", words[i], words[k], w3));
                        noneFound = false;
                    }
                }
            }
        }
        if (noneFound) {
            System.out.println("No");
        } else {
            for (String match : wordSet) {
                System.out.println(match);
            }
        }
    }
}
