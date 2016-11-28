package demos;

import java.util.ArrayList;
import java.util.List;

public class Dm08Concurrent {
    private static final StringBuffer queue = new StringBuffer();

    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();

        int coreCount = 4;

        for (int i = 0; i < coreCount; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    queue.append("a");
                }
            });
            thread.start();
            threadList.add(thread);
        }

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(queue.length());
    }
}
