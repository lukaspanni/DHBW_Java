package dhbw.exercise.classes;

import java.util.Scanner;

public class NimmSpiel {
	private String playerA;
	private String playerB;
	private int heaps[];
	private String playerNext;
	private Scanner sc = new Scanner(System.in);

	public NimmSpiel(String nameA, String nameB) {
		this.playerA = nameA;
		this.playerB = nameB;
		this.playerNext = nameA;
		this.heaps = new int[2];
		this.heaps[0] = (int) (Math.random() * 100);
		this.heaps[1] = (int) (Math.random() * 100);
	}

	@Override
	protected void finalize() {
		sc.close();
	}

	public int getHeap1() {
		return this.heaps[0];
	}

	public int getHeap2() {
		return this.heaps[1];
	}

	public void take(int from, int amnt) {
		this.heaps[from - 1] -= amnt;
	}

	public void nextStep() {
		System.out.println(this.toString());
		int heap = 0;
		do {
			System.out.print("Spieler " + playerNext + " von welchem Haufen nehmen Sie Kugeln? ");
			heap = this.sc.nextInt();
		} while ((heap == 1 | heap == 2) && heaps[heap - 1] <= 0);
		int amnt = 0;
		do {
			System.out.print("Spieler " + playerNext + " wie viele Kugeln nehmen Sie? ");
			amnt = this.sc.nextInt();
		} while (amnt < 1 || amnt > heaps[heap - 1]);
		take(heap, amnt);
		if (heaps[0] == 0 && heaps[1] == 0) {
			System.out.println(this.toString());
			System.out.println("Spiel beendet!");
			System.out.println(playerNext + " hat gewonnen");
		} else {
			playerNext = playerNext == playerA ? playerB : playerA;
			nextStep();
		}
	}

	@Override
	public String toString() {
		return "Spieler:" + playerA + ", " + playerB + ", Haufen1: " + heaps[0] + " Kugel(n), Haufen2:" + heaps[1]
				+ " Kugel(n)";
	}

	public static void main(String[] args) {
		NimmSpiel a = new NimmSpiel("A", "B");
		a.nextStep();
	}

}
