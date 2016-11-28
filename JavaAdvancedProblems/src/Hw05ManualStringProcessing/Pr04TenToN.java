package Hw05ManualStringProcessing;

import java.math.BigInteger;
import java.util.Scanner;

public class Pr04TenToN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger base10 = sc.nextBigInteger();
        StringBuilder baseN = new StringBuilder();
        while (base10.compareTo(new BigInteger("0")) > 0) {
            BigInteger remainder = base10.divideAndRemainder(new BigInteger(n + ""))[1];
            BigInteger divide = base10.divideAndRemainder(new BigInteger(n + ""))[0];
            baseN.insert(0, remainder);
            base10 = divide;
        }
        System.out.println(baseN);
    }
}
