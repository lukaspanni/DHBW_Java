package dhbw.exercise.arrays;

import java.util.Scanner;

public class Norm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Anzahl der Elemente eingeben: ");
		int n = sc.nextInt();
		if (n < 1) {
			sc.close();
			return;
		}
		int[] vect = new int[n];
		for (int i = 0; i < vect.length; i++) {
			System.out.print("x_" + i + " eingeben: ");
			vect[i] = sc.nextInt();
		}

		double abs = 0;
		for (int i = 0; i < vect.length; i++) {
			abs += vect[i] * vect[i];
		}
		abs = Math.sqrt(abs);

		System.out.println("Der Betrag ist: " + abs);

		sc.close();
	}

}
