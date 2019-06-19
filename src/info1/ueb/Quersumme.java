package info1.ueb;

import java.util.Scanner;

public class Quersumme {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Zahl eingeben: ");
		int n = sc.nextInt();
		System.out.print("Quersumme von " + n + " ist: ");
		System.out.println(quersumme(n));
		sc.close();
	}

	private static int quersumme(int n) {
		if (n / 10 < 1) {
			return n;
		}
		return quersumme(n % 10 + quersumme(n / 10));
	}

}
