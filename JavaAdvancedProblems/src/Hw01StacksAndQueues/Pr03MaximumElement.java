package Hw01StacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class Pr03MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Stack<Integer> myStack = new Stack<>();
        Stack<Integer> maxNumbersStack = new Stack<>();
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int commandType = sc.nextInt();
            if(commandType == 1) {
                int numberToPush = sc.nextInt();
                myStack.push(numberToPush);
                // check if the element we are pushing to the main stack
                // is bigger than maxElement
                if (numberToPush >= maxElement) {
                    maxElement = numberToPush;
                    // push it onto maxNumbersStack if it is
                    maxNumbersStack.push(maxElement);
                }
            } else if (commandType == 2) {
                int currentMaxNumber = maxNumbersStack.peek();
                int itemAtTop = myStack.pop();
                // check if we are about to pop the maximum element from
                // the main stack
                if (currentMaxNumber == itemAtTop) {
                    // if we are, then pop it from the
                    // maxNumbersStack too
                    maxNumbersStack.pop();
                    if (maxNumbersStack.size() > 0) {
                        // if the maxNumber stack is not empty
                        // set the next element of the maxNumbersStack
                        // as the maxElement
                        maxElement = maxNumbersStack.peek();
                    } else {
                        maxElement = Integer.MIN_VALUE;
                    }
                }
            } else {
                System.out.println(maxNumbersStack.peek());
            }
        }
    }
}
