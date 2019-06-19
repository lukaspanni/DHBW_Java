package dhbw.exercise.classes;

import java.util.Scanner;

public class Lotto {
	private int m;
	private int n;
	private int[] tipp;
	private int[] gezogen;
	private Scanner sc = new Scanner(System.in);

	public Lotto(int m, int n) {
		super();
		this.m = m;
		this.n = n < m ? n : m - 1;

	}

	public void tippen() {
		for (int i = 0; i < tipp.length; i++) {
			do {
				System.out.print("Zahl " + i + " eingeben: ");
				tipp[i] = sc.nextInt();
			} while (tipp[i] >= m && tipp[i] <= 0);
		}
		tipp = sort(tipp);
	}

	public void tippen(int[] tipp) {
		if (tipp.length == n) {
			this.tipp = sort(tipp);

		}
	}

	public void ziehen() {
		int[] nums = new int[m];
		this.gezogen = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i;
		}
		for (int i = 0; i < gezogen.length; i++) {
			do {
				int index = (int) (Math.random() * m);
				gezogen[i] = nums[index];
				nums[index] = 0;
			} while (gezogen[i] == 0);
		}

		gezogen = sort(gezogen);
	}

	public int richtige() {
		int ret = 0;
		for (int i = 0; i < tipp.length; i++) {
			for (int j = 0; j < gezogen.length; j++) {
				if (tipp[i] == gezogen[j]) {
					ret++;
					break;
				}
			}
		}
		return ret;
	}

	private static int[] sort(int[] arr) {
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
		return arr;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(String.format("Lotto: %d aus %d", n, m));
		if (tipp != null && tipp.length >= 0) {
			sb.append("\nTipp: ");
			for (int i = 0; i < tipp.length; i++) {
				sb.append(tipp[i]);
				if (i != tipp.length - 1) {
					sb.append(", ");
				} else {
					sb.append("  ");
				}
			}
		}
		if (gezogen != null && gezogen.length >= 0) {
			sb.append("\nGezogen: ");
			for (int i = 0; i < gezogen.length; i++) {
				sb.append(gezogen[i]);
				if (i != gezogen.length - 1) {
					sb.append(", ");
				} else {
					sb.append("  ");
				}
			}
			sb.append("\nRichtige: ");
			sb.append(this.richtige());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Lotto l = new Lotto(49, 6);
		l.tippen(new int[] { 1, 2, 3, 4, 5, 6 });
		System.out.println(l);
		l.ziehen();
		System.out.println(l);
	}

}
