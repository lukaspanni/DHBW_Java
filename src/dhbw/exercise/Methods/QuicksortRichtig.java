package dhbw.exercise.Methods;

import java.util.Random;

public class QuicksortRichtig {

	public static void quicksort(int left, int right, int[] data) {
		if (left < right) {
			int pivot = part(left, right, data);
			quicksort(left, pivot - 1, data);
			quicksort(pivot + 1, right, data);
		}
	}

	private static int part(int left, int right, int[] data) {
		int i = left;
		int j = right - 1;
		int pivot = data[right];

		do {
			while (data[i] <= pivot && i < right) {
				i++;
			}
			while (data[j] >= pivot && j > left) {
				j--;
			}
			if (i < j) {
				int h = data[i];
				data[i] = data[j];
				data[j] = h;
			}
		} while (i < j);

		if (data[i] > pivot) {
			int h = data[i];
			data[i] = data[right];
			data[right] = h;
		}
		return i;
	}

	private static void sort(int[] arr) {
		quicksort(0, arr.length - 1, arr);
	}

	public static void main(String[] args) {
		int[] test = new int[10];
		Random r = new Random();
		for (int i = 0; i < test.length; i++) {
			test[i] = r.nextInt(100) - 50;
		}
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
		System.out.println("\nSortiert: ");
		sort(test);
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
	}

}
