package Hw05ManualStringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr01ReverseString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
//        long start = System.nanoTime();
        StringBuilder output = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
//            System.out.print(input.charAt(i));
            output.append(input.charAt(i));
        }
//        System.out.println();
        System.out.println(output);
//        System.out.println(System.nanoTime() - start);
    }
}
