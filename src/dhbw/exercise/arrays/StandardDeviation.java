package dhbw.exercise.arrays;

public class StandardDeviation {

	public static void main(String[] args) {

		int[] array = new int[100];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 10) + 1;
		}

		double var = 0;
		double avg = 0;
		for (int i = 0; i < array.length; i++) {
			avg += array[i];
		}
		avg = avg * (1d / array.length);

		for (int i = 0; i < array.length; i++) {
			var += Math.pow((array[i] - avg), 2);
		}
		var = (1d / (array.length - 1)) * var;
		double dev = Math.sqrt(var);
		System.out.println(dev);
	}

}
