package JavaSyntaxHomework;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Pr07RandomizeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        if (end < start) {
            int temp = end;
            end = start;
            start = temp;
        }
        int[] collection = new int[end - start + 1];
        for (int i = 0; i < collection.length; i++) {
            collection[i] = start + i;
        }
        shuffle(collection);
        for (int i = 0; i < collection.length; i++) {
            System.out.printf("%d ", collection[i]);
        }
    }

    private static int[] shuffle(int[] collection) {
        Random rnd = ThreadLocalRandom.current();
        int size = collection.length;
        for (int i = size - 1; i > 0; i--) {
            int r = rnd.nextInt(i + 1);
            int temp = collection[r];
            collection[r] = collection[i];
            collection[i] = temp;
        }
        return  collection;
    }
}
