package JavaExam15Oct2015Mine;

import java.util.Scanner;

public class Pr01SoftuniPalatkaConf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();
        int foodTotal = 0;
        int roomTotal = 0;
        for (int i = 0; i < n; i++) {
            String item = sc.next();
            int quantity = sc.nextInt();
            String type = sc.next();
            sc.nextLine();
            if (item.equals("tents")) {
                if (type.equals("normal")) {
                    roomTotal += quantity * 2;
                } else { // firstClass
                    roomTotal += quantity * 3;
                }
            } else if (item.equals("rooms")) {
                if (type.equals("single")) {
                    roomTotal += quantity;
                } else if (type.equals("double")) {
                    roomTotal += quantity * 2;
                } else { // triple
                    roomTotal += quantity * 3;
                }
            } else { // food
                if (type.equals("musaka")) {
                    foodTotal += quantity * 2;
                }
            }
        }
        if (roomTotal >= people) {
            System.out.printf("Everyone is happy and sleeping well. Beds left: %d%n", roomTotal - people);
        } else {
            System.out.printf("Some people are freezing cold. Beds needed: %d%n", people - roomTotal);
        }
        if (foodTotal >= people) {
            System.out.printf("Nobody left hungry. Meals left: %d%n", foodTotal - people);
        } else {
            System.out.printf("People are starving. Meals needed: %d%n", people - foodTotal);
        }
    }
}
