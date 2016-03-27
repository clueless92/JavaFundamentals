package JavaSyntaxHomework;

import java.util.Scanner;

public class Pr06Base7ToDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base7 = sc.nextInt();
        String base7String = Integer.toString(base7);
        int sevenPower = 1;
        int base10 = 0;
        for (int i = base7String.length() - 1; i >= 0 ; i--) {
            int digit = Integer.parseInt(base7String.charAt(i) + "");
            base10 += digit * sevenPower;
            sevenPower *= 7;
        }
        System.out.println(base10);
    }
}
