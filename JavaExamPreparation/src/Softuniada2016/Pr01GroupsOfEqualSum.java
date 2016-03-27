package Softuniada2016;

import java.util.Scanner;

public class Pr01GroupsOfEqualSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[4];
        int biggestNum = Integer.MIN_VALUE;
//        int biggestIndex = -1;
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
            if(biggestNum < nums[i]) {
                biggestNum = nums[i];
                //biggestIndex = i;
            }
        }
        if (biggestNum == sum - biggestNum) {
            System.out.println("Yes");
            System.out.println(biggestNum);
            return;
        }
        if (nums[0] + nums[1] == nums[2] + nums[3]) {
            System.out.println("Yes");
            System.out.println(nums[0] + nums[1]);
            return;
        }
        if (nums[0] + nums[2] == nums[1] + nums[3]) {
            System.out.println("Yes");
            System.out.println(nums[0] + nums[2]);
            return;
        }
        if (nums[0] + nums[3] == nums[1] + nums[2]) {
            System.out.println("Yes");
            System.out.println(nums[0] + nums[3]);
            return;
        }
        System.out.println("No");
    }
}
