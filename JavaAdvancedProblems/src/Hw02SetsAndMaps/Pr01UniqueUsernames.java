package Hw02SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Pr01UniqueUsernames {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        LinkedHashSet<String> set = new LinkedHashSet<String>();
        String line;

        for (int i = 0; i < n; i++) {
            line = sc.nextLine();
            set.add(line);
        }

        for (String name : set) {
            System.out.println(name);
        }
    }
}