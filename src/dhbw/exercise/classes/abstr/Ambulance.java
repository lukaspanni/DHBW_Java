package dhbw.exercise.classes.abstr;

public class Ambulance extends Car {

	private boolean signal;

	public void turnOn() {
		signal = true;
	}

	public void turnOff() {
		signal = false;
	}

	public Ambulance() {
		this(0, false);
	}

	public Ambulance(double speed, boolean on) {
		super(speed);
		signal = on;
	}

	@Override
	public String toString() {
		return super.toString() + " Signal " + (signal ? "on" : "off");
	}

}
