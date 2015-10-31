package JavaCollectionsBasicsHomework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pr03LargestSequenceEqualStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split("\\s+");
        List<String> longestSeq = new ArrayList<>();
        List<String> currentSeq = new ArrayList<>();
        String lastWord = words[0];
        currentSeq.add(lastWord);
        longestSeq = currentSeq;
        for (int i = 1; i < words.length; i++) {
            if (words[i].equals(lastWord)) {
                currentSeq.add(words[i]);
            } else {
                currentSeq = new ArrayList<>();
                currentSeq.add(words[i]);
            }
            if (currentSeq.size() > longestSeq.size()) {
                longestSeq = currentSeq;
            }
            lastWord = words[i];
        }
        System.out.println(String.join(" ", longestSeq));
    }
}
