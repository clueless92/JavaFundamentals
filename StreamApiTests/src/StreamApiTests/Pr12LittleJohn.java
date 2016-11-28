package StreamApiTests;

import java.util.Scanner;
import java.util.regex.*;
public class Pr12LittleJohn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 4;
        Pattern rgx = Pattern.compile("(>>>----->>)|(>>----->)|(>----->)");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(String.format(" %s", sc.nextLine()));
        }
        Matcher matcher = rgx.matcher(sb.toString());
        int smallAraowsCount = 0;
        int mediumArrowCount = 0;
        int largeArrowsCount = 0;
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                largeArrowsCount++;
            }
            else if (matcher.group(2) != null) {
                mediumArrowCount++;
            }
            else {
                smallAraowsCount++;
            }
        }
        String numberAsString = String.format("%d%d%d", smallAraowsCount, mediumArrowCount, largeArrowsCount);
        int decNumber = Integer.parseInt(numberAsString);
        String binNumber = Integer.toString(decNumber, 2);
        String reversedBin = "";
        for (int i = binNumber.length() - 1; i >= 0; i--) {
            reversedBin += binNumber.charAt(i);
        }
        String totalBin = binNumber + reversedBin;
        int result = Integer.parseInt(totalBin, 2);
        System.out.println(result);
    }
}
