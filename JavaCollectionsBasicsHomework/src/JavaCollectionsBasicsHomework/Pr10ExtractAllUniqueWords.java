package JavaCollectionsBasicsHomework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Pr10ExtractAllUniqueWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\W+");
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            String word = input[i].toLowerCase();
            if (!wordList.contains(word)) {
                wordList.add(word);
            }
        }
        Collections.sort(wordList);
        System.out.println(String.join(" ", wordList));
    }
}
