package IntroductionToJavaHomework;

import java.util.Scanner;

public class Pr07GhettoNumeralSystem {

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			String[] ghetoNums = {
					"Gee",
					"Bro",
					"Zuz",
					"Ma",
					"Duh",
					"Yo",
					"Dis",
					"Hood",
					"Jam",
					"Mack" };
			String input = sc.nextLine();
			for (int i = 0; i < input.length(); i++) {
				int digit = Integer.parseInt(input.charAt(i) + "");
				System.out.printf("%1s", ghetoNums[digit]);
			}
			System.out.println();
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}
