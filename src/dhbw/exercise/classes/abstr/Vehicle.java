package dhbw.exercise.classes.abstr;

public abstract class Vehicle {

	int wheelCount;
	double vMax;
	double position;
	double speed;

	public int getWheelCount() {
		return wheelCount;
	}

	public double getvMax() {
		return vMax;
	}

	public double getPosition() {
		return position;
	}

	public double getSpeed() {
		return speed;
	}

	public void setWheelCount(int wheelCount) {
		if (wheelCount < 0) {
			this.wheelCount = 0;
		} else {
			this.wheelCount = wheelCount;
		}
	}

	public void setvMax(double vMax) {
		this.vMax = vMax;
	}

	public void setPosition(double position) {
		this.position = position;
	}

	public void setSpeed(double speed) {
		if (speed < this.vMax) {
			this.speed = speed;
		} else {
			this.speed = this.vMax;
		}
	}

	public void drive(double minutes) {
		position += speed * (minutes / 60);
	}

	public Vehicle() {
		this(0, 0, 0, 0);
	}

	public Vehicle(int wheelCount, double vMax, double speed) {
		this(wheelCount, vMax, 0, speed);
	}

	public Vehicle(int wheelCount, double vMax) {
		this(wheelCount, vMax, 0, 0);
	}

	public Vehicle(int wheelCount, double vMax, double position, double speed) {
		super();
		this.setWheelCount(wheelCount);
		this.vMax = vMax;
		this.position = position;
		this.setSpeed(speed);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " at position " + position + " with " + wheelCount + " wheels, speed "
				+ speed + " km/h of max " + vMax + " km/h";
	}

	public abstract void info();

}
