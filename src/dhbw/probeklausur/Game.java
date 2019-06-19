package dhbw.probeklausur;

import java.io.FileWriter;
import java.util.Scanner;

public class Game {

	private Board dartBoard;
	private Player[] players;
	private boolean isRunning = false;

	public Game(Board dartBoard, Player[] players) {
		super();
		this.dartBoard = dartBoard;
		this.players = players;
	}

	public void start() {
		if (this.players != null) {
			this.isRunning = true;
			gameLoop();
		}
	}

	private void gameLoop() {
		Scanner sc = new Scanner(System.in);
		String input = null;
		while (isRunning) {
			for (Player player : players) {
				System.out.println(player);
				System.out.print("Enter visit: ");
				input = sc.nextLine();
				Visit v = new Visit(dartBoard.parseMultipleFields(input.split(" ")));
				if (player.addVisit(v)) {
					System.out.println("Scored: " + v.getValue());
				} else {
					System.out.println("Not allowed");
				}
				if (player.getRemainingPoints() == 0) {
					// won
					this.isRunning = false;
					String winnerString = player.getName() + " won with: " + player.getCountDartsThrown() + " Darts!";
					System.out.println("Finished: " + winnerString);
					saveHighScore(winnerString);
					break;
				}
				System.out.println("======================");
			}
			if (players[players.length - 1].getVisitsLeft() == 0) {
				// too many tries
				this.isRunning = false;
				System.out.println("Game Over");
			}
		}
		sc.close();
	}

	private void saveHighScore(String winnerString) {
		try (FileWriter fw = new FileWriter("highscore.txt", true)) {
			fw.write(winnerString + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
