package Hw05ManualStringProcessing;

import java.util.Scanner;

public class Pr09TextFilter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] banList = sc.nextLine().split(", ");
        String text = sc.nextLine();
        for (String ban : banList) {
            String filter = new String(new char[ban.length()]).replace('\0', '*');
            text = text.replaceAll(ban, filter);
        }

        System.out.println(text);
    }
}
