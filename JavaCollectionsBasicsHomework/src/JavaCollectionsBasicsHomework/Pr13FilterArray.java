package JavaCollectionsBasicsHomework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pr13FilterArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        List<String> output = Arrays.asList(input).stream()
                .filter(w -> w.length() > 3)
                .collect(Collectors.toList());
        if (output.size() > 0) {
            System.out.println(String.join(" ", output));
        } else {
            System.out.println("(empty)");
        }
    }
}
