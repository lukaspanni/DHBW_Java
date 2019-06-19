package dhbw.exercise.classes.vehicles;

public class Race {

	public static void main(String[] args) {
		Vehicle[] vehicles = new Vehicle[6];
		vehicles[0] = new Bike(20.0);
		vehicles[1] = new Car(150.0);
		vehicles[2] = new Car(99.0);
		vehicles[3] = new RacingCar(200.0);
		vehicles[4] = new RacingCar(225.0);
		vehicles[5] = new Ambulance(125.0, true);

		vehicles[0].drive(240.0);
		for (int i = 0; i < vehicles.length; i++) {
			vehicles[i].drive(60);
		}
		for (int i = 0; i < vehicles.length; i++) {
			System.out.println(vehicles[i]);
		}
	}

}
