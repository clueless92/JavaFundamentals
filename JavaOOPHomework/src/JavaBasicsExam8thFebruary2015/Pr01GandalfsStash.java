package JavaBasicsExam8thFebruary2015;

import java.util.Scanner;

public class Pr01GandalfsStash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int happiness = sc.nextInt();
        sc.nextLine();
        String[] foods = sc.nextLine().toLowerCase().split("[\\W+_]+");
        for (String food : foods) {
            int points = getPoints(food);
            happiness += points;
        }
        System.out.println(happiness);
        System.out.println(getMood(happiness));
    }

    private static String getMood(int happiness) {
        if (happiness < -5) {
            return "Angry";
        } else if (happiness < 1) {
            return "Sad";
        } else if (happiness < 16) {
            return "Happy";
        }
        return "Special JavaScript mood";
    }

    private static int getPoints(String food) {
        switch (food) {
            case "apple":
            case "melon":
                return 1;
            case "cram":
                return 2;
            case "lembas":
                return 3;
            case "honeycake":
                return 5;
            case "mushrooms":
                return -10;
            default:
                return -1;
        }
    }
}
