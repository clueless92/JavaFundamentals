package Hw05ManualStringProcessing;

import java.math.BigInteger;
import java.util.Scanner;

public class Pr08MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bigNum = trimLeadingZeros(sc.nextLine());
        int multiplier = Integer.parseInt(sc.nextLine());

        if (multiplier == 0) {
            System.out.println(0);
            return;
        }

        StringBuilder result = new StringBuilder();
        int overflow = 0;
        for (int i = bigNum.length() - 1; i >= 0; i--) {
            int resultDigit = multiplier * (bigNum.charAt(i) - '0') + overflow;
            overflow = resultDigit / 10;
            resultDigit %= 10;
            result.append(resultDigit);
        }

        if (overflow > 0) {
            result.append(overflow);
        }

        StringBuilder output = new StringBuilder();
        for (int i = result.length() - 1; i >= 0; i--) {
            output.append(result.charAt(i));
        }

        System.out.println(output);
    }

    private static String trimLeadingZeros(String input) {
        int i = 0;
        while (input.charAt(i) == '0') {
            i++;
        }

        return input.substring(i);
    }
}
