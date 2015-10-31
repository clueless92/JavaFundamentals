package JavaCollectionsBasicsHomework;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pr12CardsFrequencies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        double numberOfCards = input.length;
        LinkedHashMap<String, Integer> cardMap = new LinkedHashMap<>();
        for (String card : input) {
            String cardFace = card.substring(0, card.length() - 1);
            if (!cardMap.containsKey(cardFace)) {
                cardMap.put(cardFace, 1);
            } else {
                int count = cardMap.get(cardFace) + 1;
                cardMap.put(cardFace, count);
            }
        }
        for (Map.Entry<String, Integer> pair : cardMap.entrySet()) {
            double frequency = pair.getValue() / numberOfCards * 100.0d;
            System.out.printf("%s -> %.2f%%", pair.getKey(), frequency);
            System.out.println();
        }
    }
}
