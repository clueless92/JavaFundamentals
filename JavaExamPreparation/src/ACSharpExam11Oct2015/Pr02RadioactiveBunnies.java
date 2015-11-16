package ACSharpExam11Oct2015;

import java.util.Scanner;

public class Pr02RadioactiveBunnies {static int rows;
    static int cols;
    static char[][] matrix;
    static int playerC;
    static int playerR;
    static int deadC;
    static int deadR;
    static int winC;
    static int winR;
    static boolean hasWon = false;
    static boolean hasDied = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        rows = sc.nextInt();
        cols = sc.nextInt();
        sc.nextLine();
        matrix = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            String line = sc.nextLine();
            matrix[r] = new char[cols];
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = line.charAt(c);
                if (line.charAt(c) == 'P') {
                    playerR = r;
                    playerC = c;
                }
            }
        }
        String commands = sc.nextLine();
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            movePlayer(command);
            matrix = spreadBuniues(playerR, playerC);
            if (hasWon || hasDied) {
                break;
            }
        }
        if (hasDied) {
            printMatrix(matrix);
            System.out.println(String.format("dead: %d %d", deadR, deadC));
            return;
        }
        if (hasWon) {
            printMatrix(matrix);
            System.out.println(String.format("won: %d %d", winR, winC));
        }

    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static void movePlayer(char command) {
        matrix[playerR][playerC] = '.';
        if (command == 'L') {
            if (isInMatrix(playerR, playerC - 1)) {
                if (matrix[playerR][playerC - 1] == 'B') {
                    deadC = playerC - 1;
                    deadR = playerR;
                    hasDied = true;
                } else {
                    matrix[playerR][playerC - 1] = 'P';
                }
                playerC--;
            } else {
                winC = playerC;
                winR = playerR;
                hasWon = true;
            }
        } else if (command == 'R') {
            if (isInMatrix(playerR, playerC + 1)) {
                if (matrix[playerR][playerC + 1] == 'B') {
                    deadC = playerC + 1;
                    deadR = playerR;
                    hasDied = true;
                } else {
                    matrix[playerR][playerC + 1] = 'P';
                }
                playerC++;
            } else {
                winC = playerC;
                winR = playerR;
                hasWon = true;
            }
        } else if (command == 'U') {
            if (isInMatrix(playerR - 1, playerC)) {
                if (matrix[playerR - 1][playerC] == 'B') {
                    deadC = playerC;
                    deadR = playerR - 1;
                    hasDied = true;
                } else {
                    matrix[playerR - 1][playerC] = 'P';
                }
                playerR--;
            } else {
                winC = playerC;
                winR = playerR;
                hasWon = true;
            }
        } else if (command == 'D') {
            if (isInMatrix(playerR + 1, playerC)) {
                if (matrix[playerR + 1][playerC] == 'B') {
                    deadC = playerC;
                    deadR = playerR + 1;
                    hasDied = true;
                } else {
                    matrix[playerR + 1][playerC] = 'P';
                }
                playerR++;
            } else {
                winC = playerC;
                winR = playerR;
                hasWon = true;
            }
        }
    }

    private static char[][] spreadBuniues(int playerR, int playerC) {
        char[][] temp = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            temp[r] = matrix[r].clone();
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char ch  = matrix[r][c];
                if (ch == 'B') {
                    if(isInMatrix(r - 1, c)) {
                        if (matrix[r - 1][c] == 'P') {
                            deadC = c;
                            deadR = r - 1;
                            hasDied = true;
                        }
                        temp[r - 1][c] = 'B';
                    }
                    if(isInMatrix(r + 1, c)) {
                        if (matrix[r + 1][c] == 'P') {
                            deadC = c;
                            deadR = r + 1;
                            hasDied = true;
                        }
                        temp[r + 1][c] = 'B';
                    }
                    if(isInMatrix(r, c - 1)) {
                        if (matrix[r][c - 1] == 'P') {
                            deadC = c - 1;
                            deadR = r;
                            hasDied = true;
                        }
                        temp[r][c - 1] = 'B';
                    }
                    if(isInMatrix(r, c + 1)) {
                        if (matrix[r][c + 1] == 'P') {
                            deadC = c + 1;
                            deadR = r;
                            hasDied = true;
                        }
                        temp[r][c + 1] = 'B';
                    }
                }
            }
        }
        return temp;
    }

    private static boolean isInMatrix(int r, int c) {
        boolean isInMatrix = (r >= 0 && c >= 0) && (r < rows && c < cols);
        return isInMatrix;
    }
}