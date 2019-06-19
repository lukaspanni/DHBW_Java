package dhbw.exercise.enums;

import dhbw.exercise.enums.PlayingCard.CardValue;
import dhbw.exercise.enums.PlayingCard.Suit;

public class TestGame {

	public static void main(String[] args) {
		CardGame game = new CardGame();
		game.shuffle();
		PlayingCard h7 = new PlayingCard(Suit.Heart, CardValue.Seven);
		for (int i = 0; i < 10; i++) {
			PlayingCard card = game.get();
			System.out.print(card);
			int compare = h7.compareTo(card);
			if (compare == 0) {
				System.out.print(" = ");
			} else if (compare < 0) {
				System.out.print(" > ");
			} else {
				System.out.print(" < ");
			}
			System.out.println(h7.toString());
		}
		game.sort();
		System.out.println(game.toString());
	}

}
