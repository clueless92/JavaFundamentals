package Hw05ManualStringProcessing;

import java.math.BigInteger;
import java.util.Scanner;

public class Pr07SumBigNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String longerBigN = trimLeadingZeros(sc.nextLine());
        String shorterBigN = trimLeadingZeros(sc.nextLine());
        if (longerBigN.length() < shorterBigN.length()) {
            String temp = longerBigN;
            longerBigN = shorterBigN;
            shorterBigN = temp;
        }

        int overflow = 0;
        StringBuilder output = new StringBuilder();
        int l = longerBigN.length() - 1;
        for (int s = shorterBigN.length() - 1; s >= 0; s--, l--) {
            int longDigit = longerBigN.charAt(l) - '0';
            int shorterDigit = shorterBigN.charAt(s) - '0';
            int digitSum = shorterDigit + longDigit + overflow;
            overflow = digitSum / 10;
            digitSum %= 10;
            output.append(digitSum);
        }

        for (; l >= 0; l--) {
            int longDigit = longerBigN.charAt(l) - '0';
            int digitSum = longDigit + overflow;
            overflow = digitSum / 10;
            digitSum %= 10;
            output.append(digitSum);
        }

        if (overflow != 0) {
            output.append(overflow);
        }

        StringBuilder result = new StringBuilder();
        for (int i = output.length() - 1; i >= 0; i--) {
            result.append(output.charAt(i));
        }

        System.out.println(result);
    }

    private static String trimLeadingZeros(String input) {
        int i = 0;
        while (input.charAt(i) == '0') {
            i++;
        }

        return input.substring(i);
    }
}
