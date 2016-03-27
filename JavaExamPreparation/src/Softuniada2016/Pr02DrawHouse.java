package Softuniada2016;

import java.util.Scanner;

public class Pr02DrawHouse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int dotCount = size - 1;
        String topDots = newString(".", dotCount);
        System.out.printf("%s*%s%n", topDots, topDots);
        int spaceCount = 1;
        for (int i = 0; i < size - 2; i++) {
            dotCount--;
            String currentDots = newString(".", dotCount);
            String currentSpace = newString(" ", spaceCount);
            spaceCount += 2;
            System.out.printf("%s*%s*%s%n", currentDots, currentSpace, currentDots);
        }
        String roofBase = newString("* ", size).trim();
        System.out.println(roofBase);
        String dashes = newString("-", spaceCount);
        String spacesHouse = newString(" ", spaceCount);
        System.out.printf("+%s+%n", dashes);
        for (int i = 0; i < size - 2; i++) {
            System.out.printf("|%s|%n", spacesHouse);
        }
        System.out.printf("+%s+%n", dashes);
    }

    public static String newString(String c, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}
