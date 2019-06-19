package dhbw.exercise.classes.abstr;

public class Car extends Vehicle {

	public Car() {
		super(4, 140);
	}

	public Car(double speed) {
		super(4, 140, speed);
	}

	@Override
	public void info() {
		System.out.println(this.toString());
	}

}
