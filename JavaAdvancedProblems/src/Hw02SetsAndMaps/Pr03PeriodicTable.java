package Hw02SetsAndMaps;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Pr03PeriodicTable {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int quantity = Integer.parseInt(sc.nextLine());

        TreeSet<String> elements = new TreeSet<>();
        for (int i = 0; i < quantity; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            for (int j = 0; j < tokens.length; j++) {
                elements.add(tokens[j]);
            }
        }

        String joined = String.join(" ", elements);
        System.out.println(joined);
    }
}