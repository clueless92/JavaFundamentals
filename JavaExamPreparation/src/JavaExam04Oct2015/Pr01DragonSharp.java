package JavaExam04Oct2015;

import java.util.Scanner;

public class Pr01DragonSharp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        boolean goToElse = false;
        StringBuilder output = new StringBuilder();
        sc.nextLine();
        for (int i = 1; i <= lines; i++) {
            try {
                String input = sc.nextLine();
                if (input.charAt(input.length() - 1) != ';') {
                    System.out.println(String.format("Compile time error @ line %d", i));
                    return;
                }
                String toPrint = input.split(" \"+")[1];
                toPrint = toPrint.substring(0, toPrint.length() - 2);
                String[] statement = input.split(" \"+")[0].split(" ");
                if (statement[0].equals("if")) {
                    //goToElse = false;
                    String firstString = statement[1].split("[><=]+")[0].substring(1);
                    int firstInt = Integer.parseInt(firstString);
                    String secondString = statement[1].split("[><=]+")[1];
                    int secondInt = Integer.parseInt(secondString.substring(0, secondString.length() - 1));
                    String operand = statement[1].split("[\\d()]+")[1];
                    if (operand.equals("==") && firstInt != secondInt) {
                        goToElse = true;
                        continue;
                    } else if (operand.equals("<") && firstInt > secondInt) {
                        goToElse = true;
                        continue;
                    } else if (operand.equals(">") && firstInt < secondInt) {
                        goToElse = true;
                        continue;
                    }
                    int repeatTimes = 1;
                    if (statement[2].equals("loop")) {
                        repeatTimes = Integer.parseInt(statement[3]);
                    }
                    for (int j = 0; j < repeatTimes; j++) {
                        output.append(toPrint);
                        output.append("\n");
                    }
                } else if (goToElse) {
                    int repeatTimes = 1;
                    if (statement[1].equals("loop")) {
                        repeatTimes = Integer.parseInt(statement[2]);
                    }
                    for (int j = 0; j < repeatTimes; j++) {
                        output.append(toPrint);
                        output.append("\n");
                    }
                }
                goToElse = false;
            } catch (Throwable t) {
                System.out.println(String.format("Compile time error @ line %d", i));
                return;
            }
        }
        System.out.print(output);
    }
}
