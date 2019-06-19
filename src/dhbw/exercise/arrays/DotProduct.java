package dhbw.exercise.arrays;

import java.util.Scanner;

public class DotProduct {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Anzahl der Elemente eingeben: ");
		int n = sc.nextInt();
		if (n < 1) {
			sc.close();
			return;
		}
		int[] vect = new int[n];
		int[] vect2 = new int[n];
		for (int i = 0; i < vect.length; i++) {
			System.out.print("x_" + i + " eingeben: ");
			vect[i] = sc.nextInt();
		}
		for (int i = 0; i < vect2.length; i++) {
			System.out.print("y_" + i + " eingeben: ");
			vect2[i] = sc.nextInt();
		}

		double scal = 0;
		for (int i = 0; i < vect.length; i++) {
			scal += vect[i] * vect2[i];
		}

		System.out.println("Skalarprodukt: " + scal);
		sc.close();
	}
}
