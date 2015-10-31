package JavaCollectionsBasicsHomework;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr08ExtractEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        Matcher m = Pattern.compile("\\w+[-._]*\\w+[-._]*\\w+@\\w+[-.]*\\w+[-.]*\\w+.\\w+").matcher(text);
        while(m.find()) {
            System.out.println(m.group(0));
        }
    }
}
