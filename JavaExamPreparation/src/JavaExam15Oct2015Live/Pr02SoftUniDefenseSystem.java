package JavaExam15Oct2015Live;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr02SoftUniDefenseSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long totalPijne = 0;
        Pattern pattern = Pattern.compile("([A-Z][a-z]+).*?([A-Z][a-z]*[A-Z]).*?(\\d+)L");
        while (true) {
            String input = sc.nextLine();
            if (input.equals("OK KoftiShans")) {
                break;
            }

            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String name = matcher.group(1);
                String alcohol = matcher.group(2).toLowerCase();
                int liters = Integer.parseInt(matcher.group(3));

                System.out.printf(
                        "%s brought %d liters of %s!%n",
                        name, liters, alcohol);

                totalPijne += liters;
            }
        }

        double softuniLiters = totalPijne / 1000.0d;
        System.out.printf("%.3f softuni liters", softuniLiters);
    }
}
