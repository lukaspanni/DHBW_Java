package dhbw.exercise.classes.vehicles;

import java.util.ArrayList;
import java.util.List;

public class Race {

	private List<Vehicle> vehicles;

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void addVehicle(Vehicle v) {
		this.vehicles.add(v);
	}

	public Race(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Race() {
		vehicles = new ArrayList<Vehicle>();
	}

	public void fillTest() {
		vehicles = new ArrayList<Vehicle>();
		addVehicle(new Bike(20.0));
		addVehicle(new Car(150.0));
		addVehicle(new Car(99.0));
		addVehicle(new RacingCar(200.0));
		addVehicle(new RacingCar(225.0));
		addVehicle(new Ambulance(125.0, true));
	}

	public static void main(String[] args) {
		Race r = new Race();
		r.addVehicle(new Bike(20.0));
		r.addVehicle(new Car(150.0));
		r.addVehicle(new Car(99.0));
		r.addVehicle(new RacingCar(200.0));
		r.addVehicle(new RacingCar(225.0));
		r.addVehicle(new Ambulance(125.0, true));

		r.getVehicles().get(0).drive(240.0);
		for (Vehicle v : r.getVehicles()) {
			v.drive(60);
		}
		for (Vehicle v : r.getVehicles()) {
			System.out.println(v);
		}
	}

}
