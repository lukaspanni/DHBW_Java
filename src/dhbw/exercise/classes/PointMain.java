package dhbw.exercise.classes;

public class PointMain {

	public static void main(String[] args) {
		Point pointA = new Point(4.0, 2.0);
		System.out.println("A: " + pointA);
		System.out.println("Abstand zum Urpsrung: " + pointA.distanceOrigin());
		Point pointB = new Point(-1.0, -1.0);
		System.out.println("B: " + pointB);
		System.out.println("AbstandA-B:" + pointA.distanceTo(pointB));
		pointA = pointA.mirrorOrigin();
		System.out.println("A': " + pointA);
		System.out.println("AbstandA’-B: " + pointA.distanceTo(pointB));
		System.out.println("B: " + pointB);
		pointB = pointB.mirrorX();
		System.out.println("B' (X-Achse): " + pointB);
	}

}
