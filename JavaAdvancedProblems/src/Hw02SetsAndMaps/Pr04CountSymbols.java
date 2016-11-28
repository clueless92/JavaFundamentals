package Hw02SetsAndMaps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Pr04CountSymbols {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        TreeMap<Character, Integer> dictionary = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (!dictionary.containsKey(currentChar)) {
                dictionary.put(currentChar, 1);
            }
            else {
                int charCount = dictionary.get(currentChar);
                dictionary.replace(currentChar, charCount + 1);
            }
        }

        for (Map.Entry<Character, Integer> pair : dictionary.entrySet()) {
            System.out.printf("%s: %s time/s%n", pair.getKey(), pair.getValue());
        }
    }
}