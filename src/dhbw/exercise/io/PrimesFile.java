package dhbw.exercise.io;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class PrimesFile {

	public static void main(String[] args) {
		int max = 100000;
		boolean[] prim = new boolean[max];
		for (int i = 2; i < prim.length; i++) {
			prim[i] = true;
		}
		for (int i = 2; i < prim.length; i++) {
			if (prim[i]) {
				for (int j = i * 2; j < prim.length; j += i) {
					prim[j] = false;
				}
			}
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("primes.txt"))) {
			for (int i = 0; i < prim.length; i++) {
				if (prim[i]) {
					bw.write(String.valueOf(i));
					bw.write("\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
