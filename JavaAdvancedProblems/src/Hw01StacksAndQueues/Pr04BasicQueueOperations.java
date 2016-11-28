package Hw01StacksAndQueues;

import java.util.*;

public class Pr04BasicQueueOperations {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(" ");
        int s = Integer.parseInt(tokens[1]);
        int x = Integer.parseInt(tokens[2]);
        String[] input = scanner.nextLine().split(" ");
        Integer[] numbers = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);

        for (int j = 0; j < numbers.length; j++) {
            queue.add(numbers[j]);
        }

        for (int j = 0; j < s; j++) {
            queue.remove();
        }

        if (queue.contains(x)) {
            System.out.printf("%s", "true");
            return;
        }

        if (queue.size() > 0) {
            System.out.printf("%d", queue.stream().min((o1, o2) -> Integer.compare(o1, o2)).get());
            return;
        }

        if (queue.size() == 0) {
            System.out.printf("%d", queue.size());
        }
    }
}

