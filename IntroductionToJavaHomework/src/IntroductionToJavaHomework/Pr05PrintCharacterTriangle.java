package IntroductionToJavaHomework;

import java.util.Scanner;

public class Pr05PrintCharacterTriangle {

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			int n = sc.nextInt();
			int step = 1;
			int start = 0;
			int end = n + step;
			for (int i = start; i != end; i += step) {
				for (int c = 0; c < i; c++) {
					char ch = (char) (97 + c);
					System.out.printf("%1c ", ch);
				}
				System.out.println();
				if (i == end - 1) {
					step = -step;
					int swap = start;
					start = end;
					end = swap;
				}
			}
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}
