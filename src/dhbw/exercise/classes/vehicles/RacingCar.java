package dhbw.exercise.classes.vehicles;

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
