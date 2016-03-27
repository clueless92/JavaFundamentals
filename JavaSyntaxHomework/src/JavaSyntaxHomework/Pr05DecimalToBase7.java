package JavaSyntaxHomework;

import java.util.Scanner;

public class Pr05DecimalToBase7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base10 = sc.nextInt();
        //String base7 = Integer.toString(base10, 7); // built in is too easy
        StringBuilder base7 = new StringBuilder();
        while (base10 > 0) {
            base7.append(base10 % 7);
            base10 /= 7;
        }
        base7.reverse();
        System.out.println(base7);
    }
}
