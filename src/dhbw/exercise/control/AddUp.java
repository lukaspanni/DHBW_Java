package dhbw.exercise.control;

import java.util.Scanner;

public class AddUp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int in = 0;
		do {
			System.out.print("Zahl eingeben (<0 für abbruch):");
			in = sc.nextInt();
			sum += in > 0 ? in : 0;
		} while (in >= 0);
		System.out.println("Summe = " + sum);
		sc.close();
	}

}
