package dhbw.exercise.strings;

import java.util.Scanner;

public class RomanNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Römische Zahl eingeben: ");
		String roman = sc.next();
		sc.close();
		System.out.println(translate(roman));
	}

	private static int translate(String s) {
		s = s.toUpperCase();
		int length = s.length();
		int num = 0;
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			switch (c) {
			case 'I':
				if (i < length - 1) {
					c = s.charAt(i + 1);
					if (c == 'V') {
						num += 4;
						i++;
						break;
					} else if (c == 'X') {
						num += 9;
						i++;
						break;
					}
				}
				num += 1;

				break;
			case 'V':
				num += 5;
				break;
			case 'X':
				if (i < length - 1) {
					c = s.charAt(i + 1);
					if (c == 'L') {
						num += 40;
						i++;
						break;
					} else if (c == 'C') {
						num += 90;
						i++;
						break;
					}
				}
				num += 10;
				break;
			case 'L':
				num += 50;
				break;
			case 'C':
				if (i < length - 1) {
					c = s.charAt(i + 1);
					if (c == 'D') {
						num += 400;
						i++;
						break;
					} else if (c == 'M') {
						num += 900;
						i++;
						break;
					}
				}
				num += 100;
				break;
			case 'D':
				num += 500;
				break;
			case 'M':
				num += 1000;
				break;

			default:
				break;
			}
		}
		return num;
	}

}
