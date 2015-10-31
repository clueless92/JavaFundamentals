package JavaCollectionsBasicsHomework;

import java.util.Scanner;

public class Pr06CountSpecifiedWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        text = text.toLowerCase();
        String word = sc.nextLine();
        word = word.toLowerCase();
        int matches = 0;
        String[] textArr = text.split("\\W+");
        for (int i = 0; i < textArr.length; i++) {
            if (textArr[i].equals(word)){
                matches++;
            }
        }
        System.out.println(matches);
    }
}
