package JavaBasics22June2014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pr04StraightFlush {

    private static List<String> values = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> hand = Arrays.asList(sc.nextLine().split("\\W+"));
        if (hand.size() < 5) {
            System.out.println("No Straight Flushes");
            return;
        }
        boolean dontHaveOutput = true;
        for (String card : hand) {
            List<String> straightFlush = new ArrayList<>();
            char suit = card.charAt(card.length() - 1);
            String face = card.substring(0, card.length() - 1);
            for (int i = 0; i < 5; i++) {
                straightFlush.add(face + suit);
                face = getNextFace(face);
            }
            if (hand.containsAll(straightFlush)) {
                System.out.println(straightFlush);
                dontHaveOutput = false;
            }
        }
        if (dontHaveOutput) {
            System.out.println("No Straight Flushes");
        }

    }

    private static String getNextFace(String face) {
        int faceIndex = values.indexOf(face);
        if (faceIndex + 1 < values.size()) {
            return values.get(faceIndex + 1);
        }
        return null;
    }
}
