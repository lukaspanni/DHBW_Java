package dhbw.exercise.arrays;

public class Pascal {

	public static void main(String[] args) {
		int[][] triangle = new int[9][];
		for (int i = 0; i < triangle.length; i++) {
			triangle[i] = new int[i + 1];
		}
		triangle[0][0] = 1;
		for (int i = 1; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				if (j == 0 || j == triangle[i].length - 1) {
					triangle[i][j] = 1;
				} else {
					triangle[i][j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
				}
			}
		}

		for (int i = 0; i < triangle.length; i++) {
			for (int j2 = 0; j2 < (triangle.length - triangle[i].length + 1); j2++) {
				System.out.print(" ");
			}
			for (int j = 0; j < triangle[i].length; j++) {

				System.out.printf(triangle[i][j] + " ");
			}
			System.out.println();
		}
	}

}
