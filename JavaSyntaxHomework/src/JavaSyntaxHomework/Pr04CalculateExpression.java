package JavaSyntaxHomework;

import java.util.Scanner;

public class Pr04CalculateExpression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double powerFirst = (a + b + c) / Math.sqrt(c);
        double squareA = Math.pow(a, 2.0d);
        double squareB = Math.pow(b, 2.0d);
        double expressionFirst = Math.pow((squareA + squareB) / (squareA - squareB), powerFirst);
        double cubeC = Math.pow(c, 3.0d);
        double powerSecond = a - b;
        double expressionSecond = Math.pow(squareA + squareB - cubeC, powerSecond);
        double diff = Math.abs((a + b + c) / 3 - (expressionFirst + expressionSecond) / 2);
        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", expressionFirst, expressionSecond, diff);
        System.out.println();
    }
}
