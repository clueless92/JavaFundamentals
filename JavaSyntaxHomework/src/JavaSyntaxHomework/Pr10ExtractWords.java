package JavaSyntaxHomework;

import java.util.Arrays;
import java.util.Scanner;

public class Pr10ExtractWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] words = input.split("[\\W+\\d+]+");
        for(String word : words){
            if (word.length() > 1) {
                System.out.printf("%s ", word);
            }
        }
        System.out.println();
    }
}
