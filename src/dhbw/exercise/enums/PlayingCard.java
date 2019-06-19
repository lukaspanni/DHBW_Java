package dhbw.exercise.enums;

public class PlayingCard implements Comparable<PlayingCard> {

	public enum Suit {
		Clubs, Spade, Heart, Diamonds
	}

	public enum CardValue {
		Seven(7), Eight(8), Nine(9), Jack(9.1), Queen(9.2), King(9.3), Ten(10), Ace(11);

		public double value;

		CardValue(double value) {
			this.value = value;
		}

		public String getValue() {
			if ((this.value > 9 && this.value < 10) || this.value == 11) {
				return this.name();
			}
			return String.valueOf((int) this.value);
		}
	}

	private Suit suit;
	private CardValue cardValue;

	public PlayingCard(Suit s, CardValue v) {
		this.suit = s;
		this.cardValue = v;
	}

	@Override
	public String toString() {
		return suit.name() + " " + cardValue.getValue();
	}

	@Override
	public int compareTo(PlayingCard p) {
		if (this.suit != p.suit) {
			return this.suit.ordinal() - p.suit.ordinal();
		} else {
			return this.cardValue.ordinal() - p.cardValue.ordinal();
		}
	}

}
