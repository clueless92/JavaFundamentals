package JavaCollectionsBasicsHomework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pr15ImplementRecursiveBinarySearch {

    static int target;
    static List<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        target = Integer.parseInt(sc.nextLine());
        String[] line = sc.nextLine().split(" ");
        list = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            list.add(Integer.parseInt(line[i]));
        }
        int itemIndex = BinarySearchRec(0, list.size() - 1);
        System.out.println(itemIndex);
    }

    private static int BinarySearchRec(int min, int max) {
        if (min > max) {
            return -1;
        }
        int mid = (max + min) / 2;
        int midItem = list.get(mid);
        if (midItem < target) {
            return BinarySearchRec(mid + 1, max);
        } else if (midItem > target) {
            return BinarySearchRec(min, mid - 1);
        }
        while (mid > 0 && list.get(mid - 1) == midItem) {
            mid--;
        }
        return mid;
    }
}
