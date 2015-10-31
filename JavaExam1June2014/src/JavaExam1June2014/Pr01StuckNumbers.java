package JavaExam1June2014;

import java.util.Scanner;

public class Pr01StuckNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        String[] nums = sc.nextLine().split(" ");
        boolean thereAreNone = true;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                for (int k = 0; k < count; k++) {
                    for (int l = 0; l < count; l++) {
                        if (i != j && i != k && i != l && j != k && j != l && k != l) {
                            String first = nums[i] + nums[j];
                            String second = nums[k] + nums[l];
                            if (first.equals(second)) {
                                System.out.printf("%s|%s==%s|%s", nums[i], nums[j], nums[k], nums[l]);
                                System.out.println();
                                thereAreNone = false;
                            }
                        }
                    }
                }
            }
        }
        if (thereAreNone) {
            System.out.println("No");
        }
    }
}
