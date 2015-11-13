package JavaBasicsExam8thFebruary2015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Pr03LegoBlocks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        sc.nextLine();
        Integer[][] leftArr = new Integer[rows][];
        Integer[][] rightArr = new Integer[rows][];
        int countItems = 0;
        for (int r = 0; r < rows; r++) {
            String[] line = sc.nextLine().trim().split("\\s+");
            leftArr[r] = new Integer[line.length];
            for (int c = 0; c < leftArr[r].length; c++) {
                leftArr[r][c] = Integer.parseInt(line[c]);
                countItems++;
            }
        }
        for (int r = 0; r < rows; r++) {
            String[] line = sc.nextLine().trim().split("\\s+");
            rightArr[r] = new Integer[line.length];
            for (int c = 0, i = rightArr[r].length - 1; c < rightArr[r].length; c++, i--) {
                rightArr[r][c] = Integer.parseInt(line[i]);
                countItems++;
            }
        }
        int firstLength = leftArr[0].length + rightArr[0].length;
        ArrayList<ArrayList<Integer>> finalArr = new ArrayList<>(rows);
        boolean resNotPrinted = true;
        for (int r = 0; r < rows; r++) {
            int currentLength = leftArr[r].length + rightArr[r].length;
            if (firstLength == currentLength) {
                finalArr.add(new ArrayList<Integer>());
                finalArr.get(r).addAll(Arrays.asList(leftArr[r]));
                finalArr.get(r).addAll(Arrays.asList(rightArr[r]));
            } else {
                resNotPrinted = false;
                System.out.println(String.format("The total number of cells is: %d", countItems));
                break;
            }
        }
        if (resNotPrinted) {
            for (int r = 0; r < rows; r++) {
                System.out.println(finalArr.get(r));
            }
        }
    }
}
