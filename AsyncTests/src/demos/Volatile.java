package demos;

import java.util.Scanner;

public class Volatile {
    static class Counter extends Thread {
        boolean flag = true;
        int counter = 0;

        public void run() {
            while (flag) {
                counter++;
                System.out.println(counter);
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        void stopCounting() {
            flag = false;
        }
    }

    public static void main(String[] args) {
        Counter counterThread = new Counter();
        counterThread.start();
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        counterThread.stopCounting();
    }
}