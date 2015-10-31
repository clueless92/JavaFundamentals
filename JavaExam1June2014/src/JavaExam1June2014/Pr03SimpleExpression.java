package JavaExam1June2014;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pr03SimpleExpression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        String[] inputNums = line.split("[\\s\\+\\-]+");
        String[] actions = line.split("[^+-]+");
        List<Double> asd = new ArrayList<>();
        BigDecimal sum = new BigDecimal(inputNums[0]);
        for (int i = 1; i < actions.length; i++) {
            if (actions[i].equals("+")) {
                sum = sum.add(new BigDecimal(inputNums[i]));
            } else {
                sum = sum.subtract(new BigDecimal(inputNums[i]));
            }
        }
        System.out.println(sum);
    }
}
