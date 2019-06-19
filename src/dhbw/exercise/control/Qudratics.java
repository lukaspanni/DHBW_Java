package dhbw.exercise.control;

import java.util.Scanner;

public class Qudratics {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a, b, c;
		System.out.println("Gleichung in der Form ax² + bx + c = 0");
		System.out.print("a:");
		a = sc.nextDouble();
		System.out.print("b:");
		b = sc.nextDouble();
		System.out.print("c:");
		c = sc.nextDouble();
		calc(a, b, c);
		sc.close();
		// input();
	}

	private static void calc(double a, double b, double c) {
		if (a == 0) {
			if (b == 0) {
				System.out.println("Die Gleichung ist degeneriert");
			} else {
				System.out.printf("x=%f\n", -(c / b));
			}
		} else {
			double d = b * b - 4 * a * c;
			if (d < 0) {
				System.out.println("Die Lösung ist konjugiert komplex");
			} else {
				double l1 = (-b + Math.sqrt(d)) / (2 * a);
				double l2 = (-b - Math.sqrt(d)) / (2 * a);
				System.out.printf("x1 = %f\nx2 = %f", l1, l2);
			}
		}
	}

	@SuppressWarnings("unused")
	private static void input() {
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		in = in.toLowerCase();
		if (in.contains("x²") && in.contains("x")) {
			double a = 0, b = 0, c = 0;
			int sq_in = in.indexOf("x²");
			String a_string = in.substring(0, sq_in);
			a = Double.parseDouble(a_string);
			int x_in = in.indexOf("x", sq_in + 2);
			String b_string = in.substring(in.indexOf('+', sq_in), x_in);
			b = Double.parseDouble(b_string);
			if (in.indexOf('+', x_in) != -1) {
				String c_string = in.substring(in.indexOf('+', x_in));
				c = Double.parseDouble(c_string);
			}
			calc(a, b, c);
		}
		sc.close();
	}

}
