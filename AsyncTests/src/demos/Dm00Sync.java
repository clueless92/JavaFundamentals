package demos;

public class Dm00Sync {
    public static void main(String[] args) {
        int n = 9999999;
        printNumbersInRange(0, n);
        System.out.println("Main thread is done.");
    }

    private static void printNumbersInRange(int a, int b) {
        for (int i = a; i <= b; i++) {
            System.out.println(i);
        }
    }
}