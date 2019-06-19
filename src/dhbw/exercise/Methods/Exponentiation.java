package dhbw.exercise.Methods;

import java.util.Scanner;

public class Exponentiation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Zahl eingeben: ");
		int num = sc.nextInt();
		System.out.print("Exponent eingeben: ");
		int exp = sc.nextInt();
		sc.close();
		System.out.println(pow(num, exp));

	}

	private static int pow(int x, int n) {
		if (n == 0) {
			return 1;
		} else {
			return x * pow(x, n - 1);
		}
	}
}
