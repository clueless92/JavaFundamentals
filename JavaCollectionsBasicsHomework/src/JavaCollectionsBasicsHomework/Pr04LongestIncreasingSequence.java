package JavaCollectionsBasicsHomework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pr04LongestIncreasingSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        List<Integer> longestSeq = new ArrayList<>();
        List<Integer> currentSeq = new ArrayList<>();
        int lastNum = nums[0];
        currentSeq.add(lastNum);
        longestSeq = currentSeq;
        for (int i = 1; i < input.length; i++) {
            if (nums[i] > lastNum) {
                currentSeq.add(nums[i]);
            } else {
                printNums(currentSeq);
                currentSeq = new ArrayList<>();
                currentSeq.add(nums[i]);
            }
            if (currentSeq.size() > longestSeq.size()) {
                longestSeq = currentSeq;
            }
            lastNum = nums[i];
        }
        printNums(currentSeq);
        System.out.print("Longest: ");
        printNums(longestSeq);
    }

    static void printNums (List<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            System.out.printf("%d ", arr.get(i));
        }
        System.out.println(arr.get(arr.size() - 1));
    }
}
