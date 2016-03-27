package Softuniada2016;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr03SumTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] firstLine = sc.nextLine().split("::");
        int firstDays = 0;
        if (firstLine.length > 1) {
            firstDays = Integer.parseInt(firstLine[0]);
        }
        String[] firstTime = firstLine[firstLine.length - 1].split(":");
        int firstHours = Integer.parseInt(firstTime[0]);
        int firstMins = Integer.parseInt(firstTime[1]);

//        System.out.println(firstDays);
//        System.out.println(firstHours);
//        System.out.println(firstMins);

        String[] secondLine = sc.nextLine().split("::");
        int secondDays = 0;
        if (secondLine.length > 1) {
            secondDays = Integer.parseInt(secondLine[0]);
        }

        String[] secondTime = secondLine[secondLine.length - 1].split(":");
        int secondHours = Integer.parseInt(secondTime[0]);
        int secondMins = Integer.parseInt(secondTime[1]);

        int sumMins = (firstMins + secondMins) % 60;
        int minsToHours = (firstMins + secondMins) / 60;
        int sumHours = (minsToHours + firstHours + secondHours) % 24;
        int hoursToDays = (minsToHours + firstHours + secondHours) / 24;
        int sumDays = hoursToDays + firstDays + secondDays;

        if (sumDays > 0) {
            System.out.printf("%d::", sumDays);
        }
        System.out.printf("%d:%02d", sumHours, sumMins);
    }
}
