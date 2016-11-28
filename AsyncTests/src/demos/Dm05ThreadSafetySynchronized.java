package demos;

import java.util.ArrayList;
import java.util.List;

public class Dm05ThreadSafetySynchronized {
    private final static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            numbers.add(i);
        }
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(() -> removeAllElementsSync());
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(numbers);
    }

    private static void removeAllElementsSync() {
        while (true) {
            synchronized (numbers) {
                int lastIndex = numbers.size() - 1;
                if(numbers.size() == 0) {
                    break;
                }
                numbers.remove(lastIndex);
            }
        }
    }
}
