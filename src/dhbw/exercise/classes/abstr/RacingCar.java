package dhbw.exercise.classes.abstr;

public class RacingCar extends Car {

	public RacingCar() {
		this(0);
	}

	public RacingCar(double speed) {
		super();
		this.setvMax(220);
		this.setSpeed(speed);
	}

}
