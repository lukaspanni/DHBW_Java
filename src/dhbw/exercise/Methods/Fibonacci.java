package dhbw.exercise.Methods;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		do {
			System.out.print("Wie viele Fibonacci-Zahlen anzeigen: ");
			n = sc.nextInt();
			sc.close();

		} while (n <= 0);
		for (int i = 0; i < n; i++) {
			System.out.println(i + ": " + fibonacci(i));
		}

	}

	private static int fibonacci(int n) {
		if (n < 2) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

}
