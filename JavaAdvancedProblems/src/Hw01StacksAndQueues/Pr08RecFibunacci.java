package Hw01StacksAndQueues;

import java.util.Scanner;

public class Pr08RecFibunacci {
    private static long[] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        cache = new long[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        System.out.println(memoFib(n));
    }

    private static long recFib(int n) {
        if(n < 2) {
            return 1;
        }

        return recFib(n - 1) + recFib(n - 2);
    }

    private static long memoFib(int n) {
        long fibN = cache[n];
        if (fibN == 0) {
            fibN = memoFib(n - 1) + memoFib(n - 2);
            cache[n] = fibN;
        }

        return fibN;
    }
}
