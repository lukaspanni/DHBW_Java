package dhbw.exercise.datatypes;

public class Round {

	public static void main(String[] args) {
		double pi = 3.1415926; // Naeherung der Kreiszahl Pi
		double e = 2.7182818; // Naeherung der Eulerschen Zahl e

		int piInt = (int) pi;
		int eInt = (int) e;

		System.out.println("cast pi: " + piInt);
		System.out.println("cast e: " + eInt);

		piInt = round(pi);
		eInt = round(e);

		System.out.println("round pi: " + piInt);
		System.out.println("round e: " + eInt);
	}

	private static int round(double num) {
		int ret = (int) num;
		num -= ret;
		if (num > 0 && num >= 0.5) { // positive Zahlen
			ret++;
		} else if (num < 0 && num <= -0.5) { // negative Zahlen
			ret--;
		}

		return ret;
	}

	@SuppressWarnings("unused")
	private static int round2(double num) { // Musterlösung
		num += num > 0 ? 0.5 : -0.5;
		return (int) num;
	}

}
