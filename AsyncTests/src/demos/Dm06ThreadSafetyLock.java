package demos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Dm06ThreadSafetyLock {
    private final static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            numbers.add(i);
        }
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(() -> removeAllElementsLock());
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

    private static ReentrantLock lock = new ReentrantLock();

    private static void removeAllElementsLock() {
        while (numbers.size() > 0) {
            lock.lock();
            int lastIndex = numbers.size() - 1;
            if (numbers.size() > 0) {
                numbers.remove(lastIndex);
            }
            lock.unlock();
        }
    }
}
