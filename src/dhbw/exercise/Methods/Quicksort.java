package dhbw.exercise.Methods;

import java.util.Random;

public class Quicksort {

	public static void main(String[] args) {
		int[] test = new int[100];
		Random r = new Random();
		for (int i = 0; i < test.length; i++) {
			test[i] = r.nextInt(200) - 100;
		}
		test = sorter(test);
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
		System.out.println();
	}

	static int[] bubblesort(int[] unsorted) {
		boolean sw = false;
		do {
			sw = false;
			for (int i = 0; i < unsorted.length - 1; i++) {
				if (unsorted[i] > (unsorted[i + 1])) {
					int h = unsorted[i + 1];
					unsorted[i + 1] = unsorted[i];
					unsorted[i] = h;
					sw = true;
				}
			}
		} while (sw);
		return unsorted;

	}

	public static int[] sorter(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		return quicksort(arr, 0, arr.length - 1);
	}

	public static int[] quicksort(int[] arr, int left, int right) {
		int l = left;
		int r = right;
		int pivot = arr[right];
		while (l <= r) {
			while (arr[l] < pivot) {
				l++;
			}
			while (arr[r] > pivot) {
				r--;
			}
			if (l <= r) {
				int temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
				l++;
				r--;
			}
		}
		if (l < right) {
			arr = quicksort(arr, l, right);
		}
		if (left < r) {
			arr = quicksort(arr, left, r);
		}
		return arr;
	}
}
