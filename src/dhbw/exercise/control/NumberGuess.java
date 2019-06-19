package dhbw.exercise.control;

import java.util.Scanner;

public class NumberGuess {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Name eingeben: ");
		String name = sc.nextLine();
		int random;
		boolean numberGuessed;
		int guessed;
		boolean continueGame = false;
		do {
			random = (int) (Math.random() * 100 + 1);
			numberGuessed = false;
			int counter = 1;
			do {
				System.out.print("Versuch " + counter + ": " + name + " rate Zahl zwischen 0 - 100: ");
				guessed = sc.nextInt();
				counter++;
				if (guessed < random) {
					System.out.println(guessed + " ist zu klein");
				} else if (guessed > random) {
					System.out.println(guessed + " ist zu groß");
				} else {
					System.out.print("Richtig geraten!!\n Spiel fortsetzen? (0: nein,1: ja)");
					numberGuessed = true;
					int in = sc.nextInt();
					if (in == 1) {
						continueGame = true;
					} else {
						continueGame = false;
						System.out.println("Schade");
					}
				}
			} while (!numberGuessed);
		} while (continueGame);

		sc.close();
	}

}
