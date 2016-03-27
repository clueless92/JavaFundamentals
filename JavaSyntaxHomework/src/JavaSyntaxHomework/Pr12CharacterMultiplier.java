package JavaSyntaxHomework;

import java.util.Scanner;

public class Pr12CharacterMultiplier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        String firstWord = input[0];
        String secondWord = input[1];
        int result = multiplyStrings(firstWord, secondWord);
        System.out.println(result);
    }

    private static int multiplyStrings(String firstWord, String secondWord) {
        int sum = 0;
        int smallerSize = firstWord.length();
        String biggerWord = secondWord;
        if (smallerSize > secondWord.length()) {
            smallerSize = secondWord.length();
            biggerWord = firstWord;
        }
        for (int i = 0; i < smallerSize; i++) {
            sum += (firstWord.charAt(i) * secondWord.charAt(i));
        }
        for (int i = smallerSize; i < biggerWord.length(); i++) {
            sum += biggerWord.charAt(i);
        }
        return sum;
    }
}
