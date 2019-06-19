package dhbw.exercise.classes;

public class Point {

	private double xCoor;
	private double yCoor;

	public double getXCoor() {
		return xCoor;
	}

	public void setXCoor(double xCoor) {
		this.xCoor = xCoor;
	}

	public double getYCoor() {
		return yCoor;
	}

	public void setYCoor(double yCoor) {
		this.yCoor = yCoor;
	}

	public Point() {
		super();
		this.xCoor = 0;
		this.yCoor = 0;
	}

	public Point(double x, double y) {
		super();
		this.xCoor = x;
		this.yCoor = y;
	}

	@Override
	public String toString() {
		return "Point [X=" + xCoor + ", Y=" + yCoor + "]";
	}

	public double distanceOrigin() {
		return Math.sqrt(Math.pow(this.xCoor, 2) + Math.pow(this.yCoor, 2));
	}

	public double distanceTo(Point p) {
		return Math.sqrt(Math.pow(this.xCoor - p.xCoor, 2) + Math.pow(this.yCoor - p.yCoor, 2));
	}

	public Point mirrorX() {
		return new Point(this.xCoor, -this.yCoor);
	}

	public Point mirrorY() {
		return new Point(-this.xCoor, this.yCoor);
	}

	public Point mirrorOrigin() {
		return new Point(-this.xCoor, -this.yCoor);
	}

}
