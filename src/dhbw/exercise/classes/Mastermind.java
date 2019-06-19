package dhbw.exercise.classes;

import java.util.Random;
import java.util.Scanner;

public class Mastermind {

	private int tryCounter = 0;
	private boolean running;
	private char[] combination;

	public Mastermind() {
		createNewCombination();
		running = true;
		System.out.println(combination);
		startGameLoop();
	}

	private void createNewCombination() {
		combination = new char[5];
		Random r = new Random();
		for (int i = 0; i < combination.length; i++) {
			combination[i] = (char) (r.nextInt(8) + Character.valueOf('A'));
		}
	}

	private void startGameLoop() {
		Scanner sc = new Scanner(System.in);
		char[] currentTry;
		int[] correct;
		while (running) {
			if (tryCounter > 20) {
				running = false;
				System.out.print("Zu viele Versuche, richtige lösung ist: ");
				System.out.println(combination);
				break;
			}
			System.out.print("Tipp eingeben: ");
			currentTry = sc.next().toUpperCase().toCharArray();
			correct = compare(currentTry);
			if (correct[0] == -1) {
				System.out.println("Ungültige Eingabe, erneut versuche: ");
				continue;
			}
			if (correct[0] == 5) {
				running = false;
				System.out.println("Gewonnen!");
			}
			tryCounter++;
			System.out.printf("%d bisherige Versuche\nrichtige: %d, richtige an falscher Stelle: %d\n", tryCounter,
					correct[0], correct[1]);
		}
		sc.close();
	}

	private int[] compare(char[] c) {
		if (c.length != 5) {
			return new int[] { -1, -1 };
		}
		int[] ret = new int[2];
		char[] combCopy = combination.clone();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == combCopy[i]) {
				ret[0]++;
				c[i] = ' ';
				combCopy[i] = ' ';
			}
		}
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ') {
				continue;
			}
			for (int j = 0; j < combCopy.length; j++) {
				if (c[i] == combCopy[j]) {
					ret[1]++;
					c[i] = ' ';
					combCopy[j] = 0;
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		new Mastermind();
	}
}
