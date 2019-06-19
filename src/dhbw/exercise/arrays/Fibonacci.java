package dhbw.exercise.arrays;

public class Fibonacci {

	public static void main(String[] args) {
		long[] fib = new long[50];
		fib[0] = 1;
		fib[1] = 1;
		for (int i = 2; i < fib.length; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}

		// Ausgabe
		for (int i = 0; i < fib.length; i++) {
			System.out.println(fib[i]);
		}
	}

}
