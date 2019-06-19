package dhbw.exercise.arrays;

import java.util.Scanner;

public class MatrixSubtraction {

	private static int[][] matrRes;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m;
		System.out.print("N eingeben: ");
		n = sc.nextInt();
		System.out.print("M eingeben: ");
		m = sc.nextInt();

		int[][] matr1 = new int[n][m];
		int[][] matr2 = new int[n][m];
		matrRes = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matr1[i][j] = (int) (Math.random() * 100) + 1;
				matr2[i][j] = (int) (Math.random() * 100) + 1;
			}
		}

		System.out.println("X: ");
		arrOut(matr1);

		System.out.println("Y: ");
		arrOut(matr2);

		System.out.println("X-Y: ");
		matrSubtract(matr1, matr2);
		arrOut(matrRes);
		sc.close();
	}

	private static void arrOut(int[][] ar) {
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				System.out.print(ar[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void matrSubtract(int[][] matr1, int[][] matr2) {
		for (int i = 0; i < matr1.length; i++) {
			for (int j = 0; j < matr1[i].length; j++) {
				matrRes[i][j] = matr1[i][j] - matr2[i][j];
			}
		}
	}

}
