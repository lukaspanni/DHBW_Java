package dhbw.exercise.speedy;

public class Question {

	private String questionText;
	private String[] answers;
	private int correctIndex;

	public Question(String questionText, String[] answers, int correctIndex) {
		super();
		this.questionText = questionText;
		this.answers = answers;
		this.correctIndex = correctIndex;
	}

	public String getQuestionText() {
		return questionText;
	}

	public String[] getAnswers() {
		return answers;
	}

	public int getCorrectIndex() {
		return correctIndex;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	public void setCorrectIndex(int correctIndex) {
		this.correctIndex = correctIndex;
	}

}
