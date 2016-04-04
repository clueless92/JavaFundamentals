package JavaExam15Oct2015Live;

import java.util.Scanner;

public class Pr01SoftUniPalatkaConf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalPeople = sc.nextInt();
        int inputCount = sc.nextInt();
        sc.nextLine();

        int totalMeals = 0;
        int totalBeds = 0;
        for (int i = 0; i < inputCount; i++) {
            String[] line = sc.nextLine().split("\\s+");
            String something = line[0];
            int count = Integer.parseInt(line[1]);
            String type = line[2];

            if (something.equals("tents")) {
                if (type.equals("normal")) {
                    totalBeds += 2 * count;
                } else { // first class
                    totalBeds += 3 * count;
                }
            } else if (something.equals("rooms")) {
                if (type.equals("single")) {
                    totalBeds += count;
                } else if (type.equals("double")) {
                    totalBeds += 2 * count;
                } else { // tripple
                    totalBeds += 3 * count;
                }
            } else { // food
                if (type.equals("musaka")) {
                    totalMeals += 2 * count;
                }
            }
        }


        if ( totalPeople > totalBeds) {
            System.out.printf(
                    "Some people are freezing cold. Beds needed: %d%n",
                    totalPeople - totalBeds);
        } else {
            System.out.printf(
                    "Everyone is happy and sleeping well. Beds left: %d%n",
                    totalBeds - totalPeople);
        }
        if (totalPeople > totalMeals) {
            System.out.printf(
                    "People are starving. Meals needed: %d%n",
                    totalPeople - totalMeals);
        } else {
            System.out.printf(
                    "Nobody left hungry. Meals left: %d%n",
                    totalMeals - totalPeople);
        }
    }
}
