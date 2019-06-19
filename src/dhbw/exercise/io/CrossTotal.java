package dhbw.exercise.io;

import java.io.FileWriter;
import java.util.Scanner;

public class CrossTotal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Zahl eingeben: ");
		String input = sc.next();
		sc.close();
		int cT = getCTFromString(input);
		System.out.println("Quersumme direkt aus String: " + cT);

		try (FileWriter fw = new FileWriter("crossTotal.txt", true)) {
			fw.write(input + ", " + cT + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static int getCTFromString(String s) {
		int length = s.length();
		int sum = 0;
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if (c >= Character.valueOf('0') && c <= Character.valueOf('9')) {
				sum += (c - Character.valueOf('0'));
			}
		}
		return sum;
	}

}
