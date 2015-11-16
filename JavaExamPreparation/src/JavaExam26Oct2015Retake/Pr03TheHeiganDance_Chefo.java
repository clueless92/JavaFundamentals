package JavaExam26Oct2015Retake;

import java.util.Scanner;

public class Pr03TheHeiganDance_Chefo {

    static final int CHAMBER_TOP = 0;
    static final int CHAMBER_BOTTOM = 14;
    static final int CHAMBER_LEFT = 0;
    static final int CHAMBER_RIGHT = 14;

    static final int PLAYER_ROW_START = 7;
    static final int PLAYER_COL_START = 7;
    static final int PLAYER_HEALTH_START = 18500;
    static final double HEIGAN_HEALTH_START = 3000000.0;

    static final int HEIGAN_SPELL_CLOUD_DAMAGE = 3500;
    static final int HEIGAN_SPELL_ERUPTION_DAMAGE = 6000;

    static int playerRow;
    static int playerCol;
    static int playerHealth;
    static double heiganHealth;
    static String heiganSpellLast;

    static void printResult() {
        if (heiganHealth < 1e-6) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHealth);
        }
        if (playerHealth < 1) {
            System.out.printf("Player: Killed by %s%n", heiganSpellLast);
        } else {
            System.out.printf("Player: %d%n", playerHealth);
        }
        System.out.printf("Final position: %d, %d%n", playerRow, playerCol);
    }

    static void movePlayer(int heiganSpellRow, int heiganSpellCol) {
        if (playerHealth < 1) {
            return;
        }
        if (heiganHealth < 1e-6) {
            return;
        }
        int rowDiff = playerRow - heiganSpellRow;
        int colDiff = playerCol - heiganSpellCol;
        if (rowDiff == -1) {
            if (colDiff == -1) {
                if (playerRow > CHAMBER_TOP) {
                    playerRow--;
                } else if (playerCol > CHAMBER_LEFT) {
                    playerCol--;
                }
            } else if (colDiff == 0) {
                if (playerRow > CHAMBER_TOP) {
                    playerRow--;
                }
            } else if (colDiff == 1) {
                if (playerRow > CHAMBER_TOP) {
                    playerRow--;
                } else if (playerCol < CHAMBER_RIGHT) {
                    playerCol++;
                }
            }
        } else if (rowDiff == 0) {
            if (colDiff == -1) {
                if (playerCol > CHAMBER_LEFT) {
                    playerCol--;
                }
            } else if (colDiff == 1) {
                if (playerCol < CHAMBER_RIGHT) {
                    playerCol++;
                }
            }
        } else if (rowDiff == 1) {
            if (colDiff == -1) {
                if (playerRow < CHAMBER_BOTTOM) {
                    playerRow++;
                } else if (playerCol > CHAMBER_LEFT) {
                    playerCol--;
                }
            } else if (colDiff == 0) {
                if (playerRow < CHAMBER_BOTTOM) {
                    playerRow++;
                }
            } else if (colDiff == 1) {
                if (playerCol < CHAMBER_RIGHT) {
                    playerCol++;
                } else if (playerRow < CHAMBER_BOTTOM) {
                    playerRow++;
                }
            }
        }
    }

    static void hitPlayerWithLastSpell() {
        if (heiganSpellLast == null) {
            return;
        }
        if (heiganSpellLast.compareTo("Cloud") != 0) {
            return;
        }
        heiganSpellLast = null;
        if (playerHealth < 1) {
            return;
        }
        playerHealth -= HEIGAN_SPELL_CLOUD_DAMAGE;
        if (playerHealth < 1) {
            heiganSpellLast = "Plague Cloud";
        }
    }

    static void hitPlayer(String heiganSpell, int heiganSpellRow, int heiganSpellCol) {
        if (playerHealth < 1) {
            return;
        }
        if (heiganHealth < 1e-6) {
            return;
        }
        int rowDiffAbs = playerRow - heiganSpellRow;
        if (rowDiffAbs < 0) {
            rowDiffAbs = -rowDiffAbs;
        }
        int colDiffAbs = playerCol - heiganSpellCol;
        if (colDiffAbs < 0) {
            colDiffAbs = -colDiffAbs;
        }
        if (rowDiffAbs > 1 || colDiffAbs > 1) {
            return;
        }
        if (heiganSpell.compareTo("Cloud") == 0) {
            playerHealth -= HEIGAN_SPELL_CLOUD_DAMAGE;
            if (playerHealth < 1) {
                heiganSpellLast = "Plague Cloud";
                return;
            }
        } else { // Eruption
            playerHealth -= HEIGAN_SPELL_ERUPTION_DAMAGE;
        }
        heiganSpellLast = heiganSpell;
    }

    static void hitHeigan(double playerDamage) {
        if (playerHealth < 1) {
            return;
        }
        if (heiganHealth < 1e-6) {
            return;
        }
        heiganHealth -= playerDamage;
    }

    public static void main(String[] args) {
        playerRow = PLAYER_ROW_START;
        playerCol = PLAYER_COL_START;
        playerHealth = PLAYER_HEALTH_START;
        heiganHealth = HEIGAN_HEALTH_START;
        heiganSpellLast = null;
        Scanner scanner = new Scanner(System.in);
        double playerDamage = scanner.nextDouble();
        do {
            String heiganSpell = scanner.next();
            int heiganSpellRow = scanner.nextInt();
            int heiganSpellCol = scanner.nextInt();
            hitHeigan(playerDamage);
            hitPlayerWithLastSpell();
            movePlayer(heiganSpellRow, heiganSpellCol);
            hitPlayer(heiganSpell, heiganSpellRow, heiganSpellCol);
        } while (playerHealth > 0 && heiganHealth > 1e-6);
        printResult();
    }
}
