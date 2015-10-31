package JavaCollectionsBasicsHomework;

import java.util.Scanner;

public class Pr02SequencesOfEqualStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split("\\s+");
        if (words.length == 1) {
            System.out.println(words[0]);
            return;
        }
        String lastWord = words[0];
        System.out.printf("%s ", lastWord);
        for (int i = 1; i < words.length; i++) {
            if (!words[i].equals(lastWord)) {
                System.out.println();
            }
            System.out.printf("%s ", words[i]);
            lastWord = words[i];
        }
    }
}
