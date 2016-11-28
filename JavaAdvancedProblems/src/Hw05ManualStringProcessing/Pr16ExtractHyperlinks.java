package Hw05ManualStringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Pr16ExtractHyperlinks {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder();
        while (true) {
            String line = sc.readLine();
            if (line.equals("END")) {
                break;
            }

            input.append(line);
        }

        String text = input.toString();
        ArrayList<String> aTags = new ArrayList<>();
        while (true) {
            int start = text.indexOf("<a");
            int end = text.indexOf(">", start + 1);
            if (start == -1 || end == -1) {
                break;
            }

            String atag = text.substring(start, end);
            aTags.add(atag);
            text = text.substring(end + 1);
        }

        for (String aTag : aTags) {
            int startI = aTag.lastIndexOf("href") + 4;
            while (startI < aTag.length() &&
                            (aTag.charAt(startI) == ' ' ||
                            aTag.charAt(startI) == '\t' ||
                            aTag.charAt(startI) == '=' ||
                            aTag.charAt(startI) == '\'' ||
                            aTag.charAt(startI) == '\"')) {
                startI++;
            }

            char delimiter = aTag.charAt(startI - 1);
            if (delimiter != ' ' && delimiter != '\'' && delimiter != '\"' && delimiter != '=') {
                System.out.println(aTag.substring(startI));
                continue;
            }

            if (delimiter == '=') {
                delimiter = ' ';
            }

            int endI = startI;
            while (endI < aTag.length() && aTag.charAt(endI) != delimiter) {
                endI++;
            }

            String output = aTag.substring(startI, endI).trim();
            if (output.equals("")) {
                continue;
            }

            System.out.println(output);
        }
    }
}
