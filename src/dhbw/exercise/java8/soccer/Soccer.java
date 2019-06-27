package dhbw.exercise.java8.soccer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Soccer {

	public static void main(String[] args) {
		Path p = Paths.get("33_Java8_Aufgaben_TeamDE.txt");

		try {
			List<Player> players = Files.readAllLines(p).stream().map(Player::parse).collect(Collectors.toList());
			System.out.println(players);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
