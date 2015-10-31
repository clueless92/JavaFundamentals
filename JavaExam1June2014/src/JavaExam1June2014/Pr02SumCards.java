package JavaExam1June2014;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pr02SumCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] cards = sc.nextLine().split(" ");
        List<String> allCards = Arrays.asList("0", "0", "2", "3", "4", "5", "6", "7", "8", "9", "10", "0", "J", "Q", "K", "A");
        String lastCard = cards[0].substring(0, cards[0].length() - 1);
        int lastCardValue = allCards.indexOf(lastCard);
        if (cards.length == 1) {
            System.out.println(lastCardValue);
            return;
        }
        int multiplier = 1;
        String card = cards[1].substring(0, cards[1].length() - 1);
        if (card.equals(lastCard)) {
            multiplier = 2;
        }
        int handSum = lastCardValue * multiplier;
        for (int i = 1; i < cards.length - 1; i++) {
            card = cards[i].substring(0, cards[i].length() - 1);
            String nextCard = cards[i + 1].substring(0, cards[i + 1].length() - 1);
            int cardValue = allCards.indexOf(card);
            if (card.equals(lastCard) || card.equals(nextCard)) {
                multiplier = 2;
            } else {
                multiplier = 1;
            }
            handSum += cardValue * multiplier;
            lastCard = card;
        }
        card = cards[cards.length - 1].substring(0, cards[cards.length - 1].length() - 1);
        if (card.equals(lastCard)) {
            multiplier = 2;
        } else {
            multiplier = 1;
        }
        handSum += allCards.indexOf(card) * multiplier;
        System.out.println(handSum);
    }
}
