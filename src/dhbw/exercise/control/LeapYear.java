package dhbw.exercise.control;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		System.out.println(isLeapYear(input));
		sc.close();
	}

	private static boolean isLeapYear(int year) {
		boolean ret = false;
		if (year % 4 == 0) {
			ret = true;
		}
		if (year % 100 == 0) {
			ret = false;
		}
		if (year % 400 == 0) {
			ret = true;
		}
		return ret;
	}

}
