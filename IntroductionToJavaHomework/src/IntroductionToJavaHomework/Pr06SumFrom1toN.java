package IntroductionToJavaHomework;

import java.util.Scanner;

public class Pr06SumFrom1toN {

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			int n = sc.nextInt();
			int sum = 0;
			for (int i = 1; i <= n; i++) {
				sum += i;
			}
			System.out.println(sum);
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

	}

}
