package dhbw.exercise.classes;

public class Horner {
	private double[] coeffs;

	public void setCoef(int n, double c) {
		if (n < coeffs.length) {
			coeffs[n] = c;
		}
	}

	public Horner(int grad) {
		super();
		coeffs = new double[grad];
	}

	public Horner(double[] co) {
		coeffs = co;
	}

	public double getValue(double x) {
		double fx = coeffs[0];
		for (int i = 1; i < coeffs.length; i++) {
			fx *= x;
			fx += coeffs[i];
		}
		return fx;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Polynom: ");
		for (int i = 0; i < coeffs.length; i++) {
			sb.append(coeffs[i] + "*X^" + (coeffs.length - i - 1));
			if (i != coeffs.length - 1) {
				sb.append(" + ");
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		double[] coe = new double[] { -6, -5, 8, 10, 7, 1, 6, 12, 2, 4, 2 };
		double[] coe1 = new double[] { 1, 5, 2 };
		Horner a = new Horner(coe);
		System.out.println(a);
		System.out.println(a.getValue(1));
		Horner a1 = new Horner(coe1);
		System.out.println(a1);
		System.out.println(a1.getValue(15));
	}
}
