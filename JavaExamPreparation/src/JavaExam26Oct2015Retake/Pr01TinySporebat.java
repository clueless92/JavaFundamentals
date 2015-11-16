package JavaExam26Oct2015Retake;

import java.util.Scanner;

public class Pr01TinySporebat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int health = 5800;
        int glowcapsTotal = 0;
        String input = sc.nextLine();
        boolean isDead = false;
        while (!input.equals("Sporeggar")) {
            int glowcaps = input.charAt(input.length() - 1) - '0';
            String enemies = input.substring(0, input.length() - 1);
            if (isDead) {
                input = sc.nextLine();
                continue;
            }
            for (int i = 0; i < enemies.length(); i++) {
                int value = enemies.charAt(i) * -1;
                if (enemies.charAt(i) == 'L') {
                    value = 200;
                }
                health += value;
                if (health <= 0) {
                    isDead = true;
                    break;
                }
            }
            if (!isDead) {
                glowcapsTotal += glowcaps;
            }
            input = sc.nextLine();
        }
        if (isDead) {
            System.out.println(String.format("Died. Glowcaps: %d", glowcapsTotal));
        } else {
            System.out.println(String.format("Health left: %d", health));
            if (glowcapsTotal >= 30) {
                System.out.println(String.format("Bought the sporebat. Glowcaps left: %d", glowcapsTotal - 30));
            } else {
                System.out.println(String.format("Safe in Sporeggar, but another %d Glowcaps needed.", 30 - glowcapsTotal));
            }
        }
    }
}
