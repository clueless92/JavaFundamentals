package ACSharpExam11Oct2015;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr03ShmoogleCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder wholeCodeSB = new StringBuilder();
        while (input.compareTo("//END_OF_CODE") != 0) {
            wholeCodeSB.append(input);
            input = sc.nextLine();
        }
        String wholeCode = wholeCodeSB.toString();
        Pattern doubleDetector = Pattern.compile("double(\\s([a-z]\\w*))");
        Matcher matcher = doubleDetector.matcher(wholeCode);
        List<String> detectedDoubles = new ArrayList<>();
        while (matcher.find()) {
            detectedDoubles.add(matcher.group(1));
        }
        if (detectedDoubles.size() == 0) {
            System.out.println("Doubles: None");
        }
        else {
            detectedDoubles.sort(Comparator.<String>naturalOrder());
            System.out.printf("Doubles:%s%n", String.join(",", detectedDoubles));
        }

        Pattern intDetector = Pattern.compile("int(\\s([a-z]\\w*))");
        matcher = intDetector.matcher(wholeCode);
        List<String> detectedInts = new ArrayList<>();
        while (matcher.find()) {
            detectedInts.add(matcher.group(1));
        }
        if (detectedInts.size() == 0) {
            System.out.println("Ints: None");
        }
        else {
            detectedInts.sort(Comparator.<String>naturalOrder());
            System.out.printf("Ints:%s%n", String.join(",", detectedInts));
        }
    }
}
