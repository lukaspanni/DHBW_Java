package dhbw.exercise.strings;

import java.util.Scanner;

public class CrossTotal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Zahl eingeben: ");
		String input = sc.next();
		sc.close();
		int length = input.length();
		int parsed = 0;
		for (int i = 0; i < length; i++) {
			int pChar = parseChar(input.charAt(i));
			if (pChar < 0) {
				System.out.println("Eingabe enthält ein ungültiges Zeichen");
			} else {
				parsed += (pChar * Math.pow(10d, length - i - 1));
			}
		}
		int cT = getCrossTotal(parsed);
		System.out.println("Eingegeben: " + parsed + " Quersumme: " + cT);

		System.out.println("Quersumme direkt aus String: " + getCTFromString(input));

	}

	private static int parseChar(char c) {
		if (c >= Character.valueOf('0') && c <= Character.valueOf('9')) {
			return c - Character.valueOf('0');
		} else {
			return -1;
		}
	}

	private static int getCrossTotal(int n) {
		if ((n / 10) < 1) {
			return n;
		}
		return (n % 10) + getCrossTotal(n / 10);
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
