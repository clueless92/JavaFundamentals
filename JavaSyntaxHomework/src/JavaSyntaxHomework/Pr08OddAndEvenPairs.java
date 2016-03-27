package JavaSyntaxHomework;

import java.util.Scanner;

public class Pr08OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        if (input.length % 2 != 0) {
            System.out.println("Invalid length");
            return;
        }
        for (int i = 0; i < input.length - 1; i += 2) {
            int first = Integer.parseInt(input[i]);
            int second = Integer.parseInt(input[i + 1]);
            if (first % 2 == second % 2) {
                if (first % 2 == 0) {
                    System.out.printf("%d, %d -> both are even", first, second);
                } else {
                    System.out.printf("%d, %d -> both are odd", first, second);
                }
            } else {
                System.out.printf("%d, %d -> different", first, second);
            }
            System.out.println();
        }
    }
}
