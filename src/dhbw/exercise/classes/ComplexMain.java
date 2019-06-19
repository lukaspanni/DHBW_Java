package dhbw.exercise.classes;

import java.util.Random;

public class ComplexMain {

	public static void main(String[] args) {
		Random r = new Random();
		Complex[] arr = new Complex[400];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Complex(r.nextDouble() * 20, r.nextDouble() * 20);
		}
		System.out.println("C1: " + arr[0]);
		System.out.println("C2: " + arr[1]);
		System.out.println("C1+C2: " + arr[0].add(arr[1]));
		System.out.println("C1-C2: " + arr[0].sub(arr[1]));
		System.out.println("C1*C2: " + arr[0].mult(arr[1]));
		System.out.println("C1/C2: " + arr[0].div(arr[1]));

		System.out.println("\n\nUnsortiert:");
		for (Complex complex : arr) {
			System.out.println(complex);
		}
		// arr = sort(arr);
		arr = mergeSort(arr);
		System.out.println("\n\nSortiert:");
		for (Complex complex : arr) {
			System.out.println(complex);
		}

	}

	static Complex[] sort(Complex[] unsorted) {
		boolean sw = false;
		do {
			sw = false;
			for (int i = 0; i < unsorted.length - 1; i++) {
				if (!unsorted[i].isLess(unsorted[i + 1])) {
					Complex h = unsorted[i + 1];
					unsorted[i + 1] = unsorted[i];
					unsorted[i] = h;
					sw = true;
				}
			}
		} while (sw);
		return unsorted;

	}

	public static Complex[] mergeSort(Complex[] B) {
		if (B.length <= 1) {
			return B;
		}
		int midpoint = B.length / 2;
		Complex[] left = new Complex[midpoint];
		Complex[] right = new Complex[B.length - midpoint];

		for (int i = 0; i < midpoint; i++) {
			left[i] = B[i];
		}
		int x = 0;
		for (int j = midpoint; j < B.length; j++) {
			if (x < B.length) {
				right[x] = B[j];
				x++;
			}
		}
		left = mergeSort(left);
		right = mergeSort(right);

		Complex[] result = merge(left, right);
		return result;
	}

	public static Complex[] merge(Complex[] left, Complex[] right) {
		int lengthres = left.length + right.length;
		Complex[] result = new Complex[lengthres];
		int indexL = 0;
		int indexR = 0;
		int indexRes = 0;

		while (indexL < left.length && indexR < right.length) {
			if (left[indexL].isLess(right[indexR])) {
				result[indexRes] = left[indexL];
				indexL++;
				indexRes++;
			} else {
				result[indexRes] = right[indexR];
				indexR++;
				indexRes++;
			}

		}

		while (indexL < left.length) {
			result[indexRes] = left[indexL];
			indexL++;
			indexRes++;
		}

		while (indexR < right.length) {
			result[indexRes] = right[indexR];
			indexR++;
			indexRes++;
		}

		return result;
	}

}
