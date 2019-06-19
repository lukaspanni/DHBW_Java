package dhbw.exercise.classes.abstr;

public class Bike extends Vehicle {

	public Bike() {
		super(2, 30);
	}

	public Bike(double speed) {
		super(2, 30, speed);
	}

	@Override
	public void info() {
		System.out.println(this.toString());
	}

}
