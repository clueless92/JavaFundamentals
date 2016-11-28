package Hw02SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Pr02SetsOfElements {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] setSizes = sc.nextLine().split("\\s+");

        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < Integer.parseInt(setSizes[0]); i++){
            set.add(sc.nextLine());
        }

        LinkedHashSet<String> setTwo = new LinkedHashSet<>();
        for (int i = 0; i < Integer.parseInt(setSizes[1]); i++){
            setTwo.add(sc.nextLine());
        }

        set.retainAll(setTwo);

        String joined = String.join(" ", set);
        System.out.println(joined);
    }
}