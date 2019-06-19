package dhbw.exercise.ui.event;

import java.io.FileWriter;

public class NumberGuessGame {
	private String name;
	private int random;
	private int guessCount = 1;
	private boolean finished = false;

	public NumberGuessGame(String name) {
		this.name = name;
		this.random = (int) (Math.random() * 1000 + 1);
	}

	public String guess(int num) {
		if (!finished) {
			if (num < random) {
				return "Attempt #" + String.valueOf(guessCount++) + ": " + String.valueOf(num) + " => too small!";
			} else if (num > random) {
				return "Attempt #" + String.valueOf(guessCount++) + ": " + String.valueOf(num) + " => too big!";
			} else {
				finished = true;
				fileOut();
				return "Attempt #" + String.valueOf(guessCount++) + ": " + String.valueOf(num) + " Number Guessed by "
						+ name;
			}
		} else {
			return "Already Finished";
		}
	}

	private void fileOut() {
		try (FileWriter fw = new FileWriter("NumberGuessResult.txt", true)) {
			fw.write(name + " " + guessCount + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
