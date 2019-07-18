package dhbw.test.gson;

import java.io.BufferedWriter;
import java.io.FileWriter;

import com.google.gson.Gson;

import dhbw.exercise.classes.vehicles.Race;

public class GSONTest {

	public GSONTest() {
		Race r = new Race();
		r.fillTest();

		Gson gson = new Gson();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("race.json", true))) {
			bw.write(gson.toJson(r));
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		new GSONTest();

	}

}
