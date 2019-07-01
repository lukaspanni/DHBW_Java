package dhbw.exercise.speedy;

import java.awt.Color;

public interface GameClient {
	public String getPlayerName();

	public int getPoints();

	public void setQuestion(int questionIndex, Question q);

	public void setRemainingSeconds(int seconds);

	public void gameIsOver();

	public void setAnswerState(int questionIndex, Status status);

	enum Status {

		ACTIVE(0, Color.ORANGE), CORRECT(1, Color.GREEN), WRONG(-1, Color.RED), PENDING(0, Color.WHITE),
		NO_ANSWER(0, Color.GRAY);

		private int points;
		private Color color;

		public int getPoints() {
			return points;
		}

		public Color getColor() {
			return color;
		}

		Status(int points, Color color) {
			this.points = points;
			this.color = color;
		}
	}
}
