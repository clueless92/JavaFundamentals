package JavaSyntaxHomework;

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
        int binaryA = Integer.parseInt(binaryStringA);
        String format = String.format("|%-10X|%010d|%10.2f|%-10.3f|", a, binaryA, b, c);
        System.out.println(format);
    }
}
