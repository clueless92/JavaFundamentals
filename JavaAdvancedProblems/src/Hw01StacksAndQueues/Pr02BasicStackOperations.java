package Hw01StacksAndQueues;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Pr02BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int x = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.add(sc.nextInt());
        }
        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        boolean contains = stack.contains(x);
        if (contains) {
            System.out.println(contains);
            return;
        }
        int min = Integer.MAX_VALUE;
        for (Integer num : stack) {
            if (num < min) {
                min = num;
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}
