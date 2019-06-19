package dhbw.exercise.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class PrimesTest {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Zahl eingeben: ");
			int n = sc.nextInt();
			System.out.println("Ist " + (isPrime(String.valueOf(n)) ? "" : "Keine ") + "Primzahl");
		}
	}

	public static boolean isPrime(String n) {
		try (BufferedReader bw = new BufferedReader(new FileReader("primes.txt"))) {
			String in = bw.readLine();
			while (in != null) {
				if (in.equals(n)) {
					return true;
				}
				in = bw.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void printAll() {
		try (BufferedReader bw = new BufferedReader(new FileReader("primes.txt"))) {
			int r = bw.read();
			while (r != -1) {
				while (r != Character.valueOf('\n')) {
					System.out.print(r - Character.valueOf('0'));
					r = bw.read();
				}
				System.out.println();
				r = bw.read();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
