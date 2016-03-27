package Pr01DragonEra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int dragonsCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dragonStart = sc.nextInt();
        List<Dragon> dragons = new ArrayList<>();

        for (int i = 1; i <= dragonStart; i++) {
            Dragon dragon = new Dragon("Dragon_" + i, 0);
            int eggs = sc.nextInt();
            for (int e = 0; e < eggs; e++) {
                Egg egg = new Egg(0, dragon);
                dragon.lay(egg);
            }
            dragons.add(dragon);
        }
        dragonsCount = dragonStart + 1;
        int years = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= years; i++) {
            String yearType = sc.nextLine();
            YearType yearFactor = YearType.valueOf(yearType);
        }
    }

    static void passAge (Dragon dragon, YearType yearType) {
        dragon.getAge();
        dragon.lay();
        if (dragon.isAlive) {
            for (Egg egg : dragon.getEggs()) {

            }
        }
    }
}

enum YearType {
    Bad,
    Normal,
    Good
}
