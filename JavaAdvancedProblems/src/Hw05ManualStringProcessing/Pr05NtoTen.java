package Hw05ManualStringProcessing;

import java.math.BigInteger;
import java.util.Scanner;

public class Pr05NtoTen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        String baseN = sc.nextBigInteger().toString();
        BigInteger nPower = BigInteger.ONE;
        BigInteger base10 = BigInteger.ZERO;
        for (int i = baseN.length() - 1; i >= 0 ; i--) {
            int digit = baseN.charAt(i) - '0';
            BigInteger addition = (new BigInteger(digit + "")).multiply(nPower);
            base10 = base10.add(addition);
            nPower = nPower.multiply(n);
        }
        System.out.println(base10);
    }
}
