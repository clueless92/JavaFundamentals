package Hw01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Pr07BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Deque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = true;
        for (int i = 0; i < input.length(); i++) {
            char bracket = input.charAt(i);
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.addLast(bracket);
            } else {
                if (stack.size() == 0) {
                    isBalanced = false;
                    break;
                }
                char lastBracket = stack.peekLast();
                if (lastBracket == '(') {
                    lastBracket = ')';
                } else if (lastBracket == '{') {
                    lastBracket = '}';
                } else {
                    lastBracket = ']';
                }
                if (lastBracket == bracket) {
                    stack.removeLast();
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }

        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
