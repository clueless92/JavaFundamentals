package JavaCollectionsBasicsHomework;

import java.util.Scanner;

public class Pr16CalculateFactN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long factN = fact(n);
        System.out.println(factN);
    }

    private static long fact(long n) {
        if (n < 2) {
            return 1;
        }
        return n * fact(n - 1);
    }
}
