package JavaCollectionsBasicsHomework;

import java.util.Arrays;
import java.util.Scanner;

public class Pr01SortArrayOfNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));
        for (int i = 0; i < n - 1; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println(arr[n-1]);
    }
}
