package dhbw.exercise.classes;

public class Complex {

	double a;
	double b;

	public double getReal() {
		return a;
	}

	public double getImag() {
		return b;
	}

	public Complex() {
		super();
	}

	public Complex(double real, double imag) {
		super();
		this.a = real;
		this.b = imag;
	}

	public Complex add(Complex c2) {
		return new Complex(this.a + c2.a, this.b + c2.b);
	}

	public Complex sub(Complex c2) {
		return new Complex(this.a - c2.a, this.b - c2.b);
	}

	public Complex mult(Complex c2) {
		return new Complex((this.a * c2.a) - (this.b * c2.b), (this.a * c2.b) + (this.b * c2.a));
	}

	public Complex div(Complex c2) {
		double newA = ((this.a * c2.a) + (this.b + c2.b)) / ((c2.a * c2.a) + (c2.b * c2.b));
		double newB = ((this.b * c2.a) - (this.a + c2.b)) / ((c2.a * c2.a) + (c2.b * c2.b));
		return new Complex(newA, newB);
	}

	public double getMagnitude() {
		return Math.sqrt((this.a * this.a) + (this.a * this.b));
	}

	public boolean isLess(Complex c2) {
		return this.getMagnitude() < c2.getMagnitude();
	}

	@Override
	public String toString() {
		return String.format("%5f + %5fi\tBetrag: %f", a, b, getMagnitude());
	}

}
