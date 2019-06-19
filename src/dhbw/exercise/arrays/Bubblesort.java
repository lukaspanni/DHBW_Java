package dhbw.exercise.arrays;

import java.util.Scanner;

public class Bubblesort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Anzahl der Elemente eingeben: ");
		int n = sc.nextInt();
		if (n < 1) {
			sc.close();
			return;
		}
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Zahl " + i + " eingeben: ");
			arr[i] = sc.nextInt();
		}
		sc.close();

		boolean sw = false;
		do {
			sw = false;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int h = arr[i + 1];
					arr[i + 1] = arr[i];
					arr[i] = h;
					sw = true;
				}
			}
		} while (sw);

		System.out.println("Sortiert: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
