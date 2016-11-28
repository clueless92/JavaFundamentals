package Hw05ManualStringProcessing;

import java.util.HashMap;
import java.util.Scanner;

public class Pr13MagicExchangeableWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Character> charMap = new HashMap<>();
        String[] input = sc.nextLine().split(" ");
        String longWord = input[0];
        String shortWord = input[1];

        if (shortWord.length() > longWord.length()) {
            String temp = shortWord;
            shortWord = longWord;
            longWord = temp;
        }

        boolean isMagic = true;
        for (int i = 0; i < shortWord.length(); i++) {
            if (!charMap.containsKey(longWord.charAt(i))) {
                charMap.put(longWord.charAt(i), shortWord.charAt(i));
            } else if (charMap.get(longWord.charAt(i)) != shortWord.charAt(i)) {
                isMagic = false;
                break;
            }
        }

        if (isMagic) {
            for (int i = shortWord.length(); i < longWord.length(); i++) {
                if (!charMap.containsKey(longWord.charAt(i))) {
                    isMagic = false;
                    break;
                }
            }
        }

        System.out.println(isMagic);
    }
}
