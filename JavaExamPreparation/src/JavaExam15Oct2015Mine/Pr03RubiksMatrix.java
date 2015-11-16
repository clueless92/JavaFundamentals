package JavaExam15Oct2015Mine;

import java.util.Scanner;

public class Pr03RubiksMatrix {

    static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();
        matrix = new int[rows][cols];
        int filler = 1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = filler;
                filler++;
            }
        }
//        printMatrix(matrix); // test
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();
            String[] parts = command.split(" ");
            String way = parts[1];
            if (way.equals("up")) {
                moveUp(parts);
            } else if (way.equals("down")) {
                moveDown(parts);
            } else if (way.equals("left")) {
                moveLeft(parts);
            } else { // right
                moveRight(parts);
            }
//            printMatrix(matrix); // test
        }
        reArange();
    }

    private static void reArange() {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int checker = 1;
        for (int r1 = 0; r1 < rows; r1++) {
            for (int c1 = 0; c1 < cols; c1++) {
                if (matrix[r1][c1] == checker) {
                    System.out.println("No swap required");
                    checker++;
                } else {
                    for (int r2 = 0; r2 < rows; r2++) {
                        for (int c2 = 0; c2 < cols; c2++) {
                            if (matrix[r2][c2] == checker) {
                                System.out.printf("Swap (%d, %d) with (%d, %d)%n", r1, c1, r2, c2);
                                int swap = matrix[r1][c1];
                                matrix[r1][c1] = matrix[r2][c2];
                                matrix[r2][c2] = swap;
                            }
                        }
                    }
                    checker++;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) { // for testing only
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.printf("%d ", matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static void moveLeft(String[] parts) {
        int row = Integer.parseInt(parts[0]);
        int sizeRow = matrix[row].length;
        int amount = Integer.parseInt(parts[2]) % sizeRow;
        if (amount == 0) {
            return;
        }
        for (int i = 0; i < amount; i++) {
            int temp = matrix[row][0];
            for (int k = 0; k < sizeRow - 1; k++){
                matrix[row][k] = matrix[row][k + 1];
            }
            matrix[row][sizeRow - 1] = temp;
        }
    } // end left

    private static void moveUp(String[] parts) {
        int col = Integer.parseInt(parts[0]);
        int sizeCol = matrix.length;
        int amount = Integer.parseInt(parts[2]) % sizeCol;
        if (amount == 0) {
            return;
        }
        for (int i = 0; i < amount; i++) {
            int temp = matrix[0][col];
            for (int k = 0; k < sizeCol - 1; k++){
                matrix[k][col] = matrix[k + 1][col];
            }
            matrix[sizeCol - 1][col] = temp;
        }
    } // end up

    private static void moveRight(String[] parts) {
        int row = Integer.parseInt(parts[0]);
        int sizeRow = matrix[row].length;
        int amount = Integer.parseInt(parts[2]) % sizeRow;
        if (amount == 0) {
            return;
        }
        for (int i = 0; i < amount; i++) {
            int temp = matrix[row][sizeRow - 1];
            for (int k = sizeRow - 1; k >= 1; k--){
                matrix[row][k] = matrix[row][k - 1];
            }
            matrix[row][0] = temp;
        }
    } // end right

    private static void moveDown(String[] parts) {
        int col = Integer.parseInt(parts[0]);
        int sizeCol = matrix.length;
        int amount = Integer.parseInt(parts[2]) % sizeCol;
        if (amount == 0) {
            return;
        }
        for (int i = 0; i < amount; i++) {
            int temp = matrix[sizeCol - 1][col];
            for (int k = sizeCol - 1; k >= 1; k--){
                matrix[k][col] = matrix[k - 1][col];
            }
            matrix[0][col] = temp;
        }
    } // end down
}
