package dhbw.exercise.classes;

public class Polynomial {

	public static void main(String[] args) {
		Polynomial p1 = new Polynomial(1, 0, -1);
		Polynomial p2 = new Polynomial(12, 8, 6);

		System.out.println("P1: " + p1);
		System.out.println("P2: " + p2);
		System.out.println("P1+P2: " + p1.add(p2));
		double[] zero = p1.getZero();
		for (double z : zero) {
			System.out.println("P1: L = " + z);
		}

	}

	private double a;
	private double b;
	private double c;

	public Polynomial(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Polynomial() {
		super();
		a = 0;
		b = 0;
		c = 0;
	}

	public double f(double x) {
		return (a * x * x) + (b * x) + c;
	}

	public Polynomial add(Polynomial p2) {
		return new Polynomial(a + p2.a, b + p2.b, c + p2.c);
	}

	public Polynomial mult(double s) {
		return new Polynomial(a * s, b * s, c * s);
	}

	public double[] getZero() {
		if (a == 0) {
			if (b == 0) {
				return new double[0];
			} else {
				return new double[] { -(c / b) };
			}
		} else {
			double d = b * b - 4 * a * c;
			if (d < 0) {
				return new double[0];
			} else {
				double l1 = (-b + Math.sqrt(d)) / (2 * a);
				double l2 = (-b - Math.sqrt(d)) / (2 * a);
				return new double[] { l1, l2 };
			}
		}

	}

	@Override
	public String toString() {
		return a + "x² + " + b + "x +" + c;
	}

}
