package dhbw.exercise.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("String eingeben: ");
		String s = sc.next();
		sc.close();
		String reversed = reverse(s);
		System.out.println(reversed);
		if (s.equalsIgnoreCase(reversed)) {
			System.out.print("Ist Palindrom!\n");
			try (FileWriter fw = new FileWriter("palindrom.txt", true)) {
				fw.write(s + "\n");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Kein Palindrom!");
		}

		try (BufferedReader br = new BufferedReader(new FileReader("palindrom.txt"))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		int sLength = s.length();
		for (int i = 0; i < sLength; i++) {
			sb.append(s.charAt(sLength - i - 1));
		}
		return sb.toString();
	}

	/*
	 * private static boolean isPalindrom(String s1, String s2) { boolean b = true;
	 * int length = s1.length(); if (length == s2.length()) { s1 = s1.toUpperCase();
	 * s2 = s2.toUpperCase(); for (int i = 0; i < length; i++) { if (s1.charAt(i) !=
	 * s2.charAt(i)) { b = false; break; } } return b; } return false; }
	 *
	 */
}
