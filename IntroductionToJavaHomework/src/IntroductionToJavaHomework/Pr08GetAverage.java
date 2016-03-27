package IntroductionToJavaHomework;

import java.util.Scanner;

public class Pr08GetAverage {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			double c = sc.nextDouble();
			double avg = Average(a, b, c);
			System.out.printf("%.2f", avg);
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

	private static double Average(double a, double b, double c) {
		double avg = (a + b + c) / 3.0d;
		return avg;
	}

}
