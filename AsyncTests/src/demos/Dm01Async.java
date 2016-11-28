package demos;

public class Dm01Async {
    public static void main(String[] args) {
        int n = 10000;
        Thread thread = new Thread(() -> getNumbersInRange(0, n));
        thread.start();
        System.out.println("Main thread is done.");

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void getNumbersInRange(int a, int b) {
        for (int i = a; i <= b; i++) {
            System.out.println(i);
        }
        System.out.printf("Thread %d done.%n", Thread.currentThread().getId());
    }
}
