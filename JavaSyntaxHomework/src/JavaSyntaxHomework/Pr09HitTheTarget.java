package JavaSyntaxHomework;

import java.util.Scanner;

public class Pr09HitTheTarget {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num > 0) {
            for (int i = 1; i <= 20 && i < num; i++) {
                for (int k = 20; k > 0; k--) {
                    if (i + k == num) {
                        System.out.printf("%d + %d = %d", i, k, num);
                        System.out.println();
                    }
                }
            }
        }
        if (num < 20) {
            for (int i = num + 1; i <= 20; i++) {
                for (int k = 1; k <= 20 - num; k++) {
                    if (i - k == num){
                        System.out.printf("%d - %d = %d", i, k, num);
                        System.out.println();
                    }
                }
            }
        }
    }
}
