package demos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dm02PrimesInRange {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int to = 999999;
        Thread primeThread = new Thread(() -> printNashtePrimesInRange(0, to));
        primeThread.start();

        while (true) {
            String input = reader.readLine();
            if (input.equals("exit")) {
                break;
            } else if (input.equals("stop")) {
                primeThread.interrupt();
            } else {
                System.out.println("chuvam te");
            }
        }

        try {
            primeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printNashtePrimesInRange(int from, int to) {
        boolean isPrime;
        StringBuilder primes = new StringBuilder();
        for (int num = from; num < to; num++) {
            isPrime = isNumberPrime(num);
            if (isPrime) {
                primes
                        .append(num)
                        .append(System.lineSeparator());
            }

            if (Thread.currentThread().isInterrupted()) {
                System.out.printf(
                        "Thread %d interrupted! Here are results so far:%n",
                        Thread.currentThread().getId());
                break;
            }
        }

        System.out.println(primes);
    }

    private static boolean isNumberPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
