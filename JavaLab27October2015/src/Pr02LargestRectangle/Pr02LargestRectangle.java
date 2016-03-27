package Pr02LargestRectangle;

import java.util.*;

public class Pr02LargestRectangle {

    static List<List<String>> matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        matrix = new ArrayList<>();
        String input = sc.nextLine();
        while (!input.equals("END")) {
            input = input.substring(1);
            String[] line = input.split(",");
            matrix.add(Arrays.asList(line));
            input = sc.nextLine();
        }

        for (int i = 0; i < matrix.size(); i++) {
            printLine(matrix.get(i));
        }
    }

    public static void printLine(String[] line) {
        for (int i = 0; i < line.length - 1; i++) {
            System.out.printf("%4s ", line[i]);
        }
        System.out.printf("%4s", line[line.length - 1]);
        System.out.println();
    }

    public static void printLine(List<String> line) {
        for (int i = 0; i < line.size() - 1; i++) {
            System.out.printf("%4s ", line.get(i));
        }
        System.out.printf("%4s", line.get(line.size() - 1));
        System.out.println();
    }
}
