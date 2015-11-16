package JavaExam26Oct2015Retake;

import java.util.Scanner;

public class Pr03TheHeiganDance {

    static int playerRow = 7;
    static int playerCol = 7;
    static int hitRow;
    static int hitCol;
    static boolean isInRange;
    static int playerHealth = 18500;
    static double heiganHealth = 3000000.0d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double playerDamage = sc.nextDouble();
        sc.nextLine();
        String lastSpell = "";
        while (sc.hasNextLine()) {
            isInRange = true; // reset isInRange

            // check for player death
            if (playerHealth <= 0) {
                break;
            }

            // player hit
            heiganHealth -= playerDamage;

            // plague cloud second damage
            if (lastSpell.equals("Plague Cloud")) {
                playerHealth -= 3500;
            }

            // check for deaths
            if (heiganHealth <= 0.0d || playerHealth <= 0) {
                break;
            }
            lastSpell = "";


            // read input
            String[] input = sc.nextLine().split(" ");
            hitRow = Integer.parseInt(input[1]);
            hitCol = Integer.parseInt(input[2]);
            String spell = input[0];

            // check if there is need to try to move
            int maxHitRow = hitRow + 1;
            int minHitRow = hitRow - 1;
            int maxHitCol = hitCol + 1;
            int minHitCol = hitCol - 1;
            if (playerCol > maxHitCol) {
                isInRange = false;
            }
            if (playerCol < minHitCol) {
                isInRange = false;
            }
            if (playerRow > maxHitRow) {
                isInRange = false;
            }
            if (playerRow < minHitRow) {
                isInRange = false;
            }

            // check for chance AND need to move
            if (!(playerRow == hitRow && playerCol == hitCol) && isInRange) {
                moveUp();
            }

            if (isInRange) { // perform hit if true
                if (spell.equals("Eruption")) {
                    playerHealth -= 6000;
                    lastSpell = spell;
                } else {
                    playerHealth -= 3500;
                    lastSpell = "Plague Cloud";
                }
            }
        }

        // print
        if (heiganHealth <= 0.0d) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.println(String.format("Heigan: %.2f", heiganHealth));
        }
        if (playerHealth <= 0) {
            System.out.println(String.format("Player: Killed by %s", lastSpell));
        } else {
            System.out.println(String.format("Player: %d", playerHealth));
        }
        System.out.println(String.format("Final position: %d, %d", playerRow, playerCol));
    }

    private static void moveUp() {
        int hitMinR = hitRow - 1;
        playerRow--;
        if (playerRow < hitMinR && playerRow >= 0) {
            isInRange = false;
            return;
        } else {
            playerRow++;
        }
        moveRight();
    }

    private static void moveRight() {
        int hitMaxC = hitCol + 1;
        playerCol++;
        if (playerCol > hitMaxC && playerCol <= 14) {
            isInRange = false;
            return;
        } else {
            playerCol--;
        }
        moveDown();
    }

    private static void moveDown() {
        int hitMaxR = hitRow + 1;
        playerRow++;
        if (playerRow > hitMaxR && playerRow <= 14) {
            isInRange = false;
            return;
        } else {
            playerRow--;
        }
        moveLeft();
    }

    private static void moveLeft() {
        int hitMinC = hitCol - 1;
        playerCol--;
        if (playerCol < hitMinC && playerCol >= 0) {
            isInRange = false;
        } else {
            playerCol++;
        }
    }
}
