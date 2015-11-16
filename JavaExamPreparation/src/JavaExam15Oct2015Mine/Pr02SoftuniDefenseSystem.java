package JavaExam15Oct2015Mine;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr02SoftuniDefenseSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int litersTotal = 0;
        while (!line.equals("OK KoftiShans")) {
            Pattern pattern = Pattern.compile("([A-Z]{1}[a-z]+).*?([A-Z]{1}[a-z]*[A-Z]{1}).*?(\\d+)L");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String name = matcher.group(1);
                String drink = matcher.group(2).toLowerCase();
                int liters = Integer.parseInt(matcher.group(3));
                litersTotal += liters;
                System.out.printf("%s brought %d liters of %s!%n", name, liters, drink);
            }
            line = sc.nextLine();
        }
        double softuniLiters = litersTotal * 0.001d;
        System.out.printf("%.3f softuni liters%n", softuniLiters);
    }
}
