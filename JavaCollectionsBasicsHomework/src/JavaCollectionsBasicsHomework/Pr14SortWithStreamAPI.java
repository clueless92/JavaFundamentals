package JavaCollectionsBasicsHomework;

import java.util.*;
import java.util.stream.Collectors;

public class Pr14SortWithStreamAPI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        Integer[] nums = new Integer[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        String command = sc.nextLine();
        List<Integer> sortedList;
        if (command.equals("Ascending")) {
            sortedList = Arrays.asList(nums).stream()
                    .sorted(Comparator.naturalOrder())
                    .collect(Collectors.toList());
        } else {
            sortedList = Arrays.asList(nums).stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());
        }

        for (int i = 0; i < sortedList.size() - 1; i++) {
            System.out.printf("%d ", sortedList.get(i));
        }
        System.out.println(sortedList.get(sortedList.size() - 1));
    }
}
