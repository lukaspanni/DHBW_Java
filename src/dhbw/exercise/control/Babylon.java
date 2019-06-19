package dhbw.exercise.control;

import java.util.Scanner;

public class Babylon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Wurzel aus welcher Zahl? ");
		int input = sc.nextInt();
		if (input < 0) {
			sc.close();
			return;
		}
		double x = 1, oldX;
		do {
			oldX = x;
			x = (x + (input / x)) / 2;
			System.out.println("xn: " + x);
		} while (Math.abs(oldX - x) > 0.0000000001);
		System.out.println("Die wurzel aus " + input + " ist: " + x);
		sc.close();
	}

}
