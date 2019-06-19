package dhbw.exercise.enums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import dhbw.exercise.enums.PlayingCard.CardValue;
import dhbw.exercise.enums.PlayingCard.Suit;

public class CardGame {

	private Stack<PlayingCard> cards;

	public CardGame() {
		cards = new Stack<PlayingCard>();
		for (Suit s : Suit.values()) {
			for (CardValue val : CardValue.values()) {
				cards.add(new PlayingCard(s, val));
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public void sort() {
		Collections.sort(cards);
	}

	public PlayingCard get() {
		return cards.pop();
	}

	public List<PlayingCard> all() {
		return new ArrayList<PlayingCard>(cards);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (PlayingCard card : cards) {
			sb.append(card.toString() + " ");
		}
		return sb.toString();
	}

}
