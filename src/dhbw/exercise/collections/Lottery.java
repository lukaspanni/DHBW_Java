package dhbw.exercise.collections;

import java.util.Random;
import java.util.TreeSet;

public class Lottery {

	public static void main(String[] args) {
		TreeSet s = new TreeSet();
		Random r = new Random();
		while (s.size() < 6) {
			s.add(r.nextInt(49) + 1);
		}
		int rand = r.nextInt(49) + 1;
		while (s.contains(rand)) {
			rand = r.nextInt(49) + 1;
		}
		System.out.println(s + " Zusatzzahl: " + rand);
	}

}
