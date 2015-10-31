package JavaCollectionsBasicsHomework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pr09CombineListsOfLetters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<Character> firstList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ') {
                firstList.add(c);
            }
        }
        List<Character> secondList = new ArrayList<>();
        input = sc.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ') {
                secondList.add(c);
            }
        }
        List<Character> charsToAdd = new ArrayList<>();
        for (char c : secondList) {
            if (!firstList.contains(c)) {
                charsToAdd.add(c);
            }
        }
        firstList.addAll(charsToAdd);
        printChars(firstList);
    }

    private static void printChars(List<Character> firstList) {
        for (int i = 0; i < firstList.size() - 1; i++) {
            System.out.printf("%c ", firstList.get(i));
        }
        System.out.println(firstList.get(firstList.size() - 1));
    }
}
