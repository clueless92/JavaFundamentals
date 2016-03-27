package JavaSyntaxHomework;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr11StartsAndEndsWithCapitalLetter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\b[A-Z][a-zA-Z]*[A-Z]\\b");

//   // Solution with string array input
        String[] input = sc.nextLine().split(" ");
        for (String word : input) {
            Matcher m = pattern.matcher(word);
            if (m.matches()) {
                System.out.printf("%s ", word);
            }
        }

//     // Solution with single string input
//        String input = sc.nextLine();
//        Matcher m = pattern.matcher(input);
//        while (m.find()) {
//            System.out.printf("%s ", m.group(0));
//        }
    }
}
