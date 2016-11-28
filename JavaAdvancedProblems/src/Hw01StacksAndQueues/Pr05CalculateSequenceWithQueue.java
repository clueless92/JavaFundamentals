package Hw01StacksAndQueues;

import java.util.*;
import java.util.stream.Collectors;

public class Pr05CalculateSequenceWithQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Long.parseLong(scanner.nextLine());
        Queue<Long> queue = new ArrayDeque<>();
        queue.add(n);
        List<Long> results = new ArrayList<>();
        while (results.size() < 50){
            long current = queue.poll();
            results.add(current);
            queue.add(current + 1);
            queue.add(2 * current + 1);
            queue.add(current + 2);
        }

        System.out.println(results.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }
}
