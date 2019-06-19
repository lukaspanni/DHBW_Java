package dhbw.exercise.control;

public class TemperatureTable {

	public static void main(String[] args) {
		System.out.println("Fahrenheit | Celsius");
		System.out.println("-----------+--------");
		double c;
		double f;
		for (int i = 0; i <= 15; i++) {
			f = i * 20;
			c = (5 / 9.) * (f - 32);
			System.out.printf("%10.0f | %7.2f\n", f, c);
		}
	}

}
