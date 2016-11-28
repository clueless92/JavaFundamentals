package Hw05ManualStringProcessing;

import java.util.Locale;
import java.util.Scanner;

public class Pr03FormattingNumbers {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        String binaryStringA = Integer.toString(a, 2);
        while (binaryStringA.length() < 10) {
            binaryStringA = "0" + binaryStringA;
        }
        if (binaryStringA.length() > 10) {
            binaryStringA = binaryStringA.substring(0, 10);
        }
        String format = String.format("|%-10X|%s|%10.2f|%-10.3f|", a, binaryStringA, b, c);
        System.out.println(format);
    }
}
