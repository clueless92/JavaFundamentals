package JavaExam26Oct2015Retake;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr02WeirdScript {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int keyNum = sc.nextInt();
        sc.nextLine();
        while (keyNum > 52) {
            keyNum -= 52;
        }
        char keyChar;
        if (keyNum > 26) {
            keyChar = (char) (keyNum - 27 + 'A');
        } else {
            keyChar = (char) (keyNum + 'a' - 1);
        }
//        System.out.println(keyChar);
        String key = keyChar + "" + keyChar;
        String regex = key + "(.*?)" + key;
        Pattern pattern = Pattern.compile(regex);
        String input = sc.nextLine();
        StringBuilder text = new StringBuilder();
        while (!input.equals("End")) {
            text.append(input);
            input = sc.nextLine();
        }
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
