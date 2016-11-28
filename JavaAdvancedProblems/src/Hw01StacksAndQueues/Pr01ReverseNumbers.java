package Hw01StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Pr01ReverseNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            stack.push(Integer.parseInt(input[i]));
        }
        while (!stack.isEmpty()) {
            System.out.printf("%s ", stack.pop());
        }
    }
}
