package dhbw.exercise.control;

public class Deers {

	public static void main(String[] args) {
		int deerCount = 200;
		double increaseRate = 0.1;
		int decreaseBy = 15;
		int count = 1;
		while (deerCount <= 300) {
			deerCount += deerCount * increaseRate;
			deerCount -= decreaseBy;
			System.out.printf("%d: %d Hirsche\n", count++, deerCount);
		}
	}

}
