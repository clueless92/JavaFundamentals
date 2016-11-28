package demos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Dm03PrimesInRangeThreads {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Thread primesThread = new Thread(() -> printPrimesInRange(0, 999999));
        primesThread.start();
        System.out.println("What should I do?");
        while (true) {
            String command = reader.readLine();
            if (command.equals("stop")) {
                primesThread.interrupt();
            }
            else if (command.equals("exit")) {
                primesThread.interrupt();
                break;
            }
        }

        try {
            primesThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread done.");
    }

    private static void printPrimesInRange(int rangeFirst, int rangeLast) {
        List<Integer> primes = new ArrayList<>();
        for (int number = rangeFirst; number < rangeLast; number++) {
            boolean isPrime = true;
            for (int divider = 2; divider < number; divider++) {
                if (number % divider == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(number);
            }
            if(Thread.currentThread().isInterrupted()) {
                System.out.printf("Thread %d interrupted, results so far are:%n", Thread.currentThread().getId());
                break;
            }
        }
        System.out.println(primes);
    }
}
