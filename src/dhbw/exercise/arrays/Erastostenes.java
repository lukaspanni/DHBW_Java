package dhbw.exercise.arrays;

import java.util.ArrayList;
import java.util.List;

public class Erastostenes {

	public static void main(String[] args) {
		int n = 99;
		// int[] sieve = new int[n];
		List<Integer> sieve = new ArrayList<Integer>();
		// boolean[] primes = new boolean[n];
		List<Integer> primes = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			sieve.add(i + 2);
		}

		for (int i = 0; i < sieve.size(); i++) {
			if (sieve.get(i) != 0) {
				primes.add(sieve.get(i));
				for (int j = i + 1; j < sieve.size(); j++) {
					if (sieve.get(j) % sieve.get(i) == 0) {
						sieve.remove(j);
					}
				}
			}
		}
		for (int i = 0; i < primes.size(); i++) {
			System.out.println(primes.get(i));
		}

	}
}
