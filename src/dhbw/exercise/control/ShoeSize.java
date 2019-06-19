package dhbw.exercise.control;

public class ShoeSize {

	public static void main(String[] args) {
		System.out.println("Zentimeter    | Größe");
		int gr = 30;
		double sm, bg;
		while (gr < 50) {
			sm = (gr - 1) / 1.5;
			bg = gr / 1.5;
			System.out.printf("%5.2f - %5.2f | %5d\n", sm, bg, gr);
			gr++;
		}
	}

}
