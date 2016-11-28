package demos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Dm04NoThreadSafety {

    static List<Integer> numbers;
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        numbers = new ArrayList<>();
        for (int i = 0; i < 9999; i++) {
            numbers.add(i);
        }

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(() ->
                    removeAllElements(), "Thread " + i);
            threadList.add(thread);
            thread.start();
        }

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(numbers.size());
    }

    private static void removeAllElements() {
        while (numbers.size() > 0) {
//            lock.lock();
            int indexToRemove = numbers.size() - 1;
            if (numbers.size() > 0) {
                numbers.remove(indexToRemove);
            }
        }
    }
}
