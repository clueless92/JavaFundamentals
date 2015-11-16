package JavaExam04Oct2015;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Pr02DragonAccounting {

    static BigDecimal month = new BigDecimal("30");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigDecimal initialCapital = new BigDecimal(sc.nextLine());
        String line = sc.nextLine();
        List<EmployeeSet> emplyees = new LinkedList<>();
        boolean hasBankrupt = false;
        int day = 0;

        while (!line.equals("END")) {
            String[] tokens = line.split(";");
            long hired = Long.parseLong(tokens[0]);
            long fired = Long.parseLong(tokens[1]);
            BigDecimal salary = new BigDecimal(tokens[2]);

            emplyees.add(new EmployeeSet(hired, 0, salary));

            day++;

            for (EmployeeSet es : emplyees) {
                es.day++;
                if (es.day % 365 == 0) {
                    es.salary = es.salary.multiply(new BigDecimal("1.006"));
                }
                if (day % 30 == 0) {
                    if (es.day < 30) {
                        BigDecimal salaryToRecieve = es.salary
                                .divide(month, 9, BigDecimal.ROUND_UP)
                                .setScale(7, BigDecimal.ROUND_DOWN)
                                .multiply(new BigDecimal(es.day))
                                .multiply(new BigDecimal(es.count));
                        initialCapital = initialCapital.subtract(salaryToRecieve);
                    } else {
                        BigDecimal salaryToRecieve = es.salary
                                .divide(month, 9, BigDecimal.ROUND_UP)
                                .setScale(7, BigDecimal.ROUND_DOWN)
                                .multiply(month)
                                .multiply(new BigDecimal(es.count));
                        initialCapital = initialCapital.subtract(salaryToRecieve);
                    }
                }

                if (fired > 0) {
                    es.count -= fired;
                    if (es.count < 0) {
                        fired = es.count * -1;
                        es.count = 0;
                    } else {
                        fired = 0;
                    }
                }
            }

            for (int i = 3; i < tokens.length; i++) {
                String[] activities = tokens[i].split(":");
                String reason = activities[0];
                BigDecimal money = new BigDecimal(activities[1]);
                if (reason.equals("Product development") || reason.equals("Unconditional funding")) {
                    initialCapital = initialCapital.add(money);
                } else {
                    initialCapital = initialCapital.subtract(money);
                }
            }

            if (initialCapital.compareTo(BigDecimal.ZERO) <= 0) {
                hasBankrupt = true;
                break;
            }

            line = sc.nextLine();
        }
        if (hasBankrupt) {
            System.out.println("BANKRUPTCY: " + initialCapital.setScale(4, BigDecimal.ROUND_DOWN).abs());
        } else {
            BigInteger employeesCount = BigInteger.ZERO;
            for (EmployeeSet es : emplyees) {
                employeesCount = employeesCount.add(new BigInteger(Long.toString(es.count)));
            }
            System.out.println(employeesCount + " " + initialCapital.setScale(4, BigDecimal.ROUND_DOWN));
        }
    }

    static class EmployeeSet {
        public long count;
        public int day;
        public BigDecimal salary;

        public EmployeeSet(long count, int day, BigDecimal salary) {
            this.count = count;
            this.day = day;
            this.salary = salary;
        }
    }
}
