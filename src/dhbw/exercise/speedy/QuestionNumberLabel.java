package dhbw.exercise.speedy;

import javax.swing.JLabel;

import dhbw.exercise.speedy.GameClient.Status;

@SuppressWarnings("serial")
public class QuestionNumberLabel extends JLabel {
	private Status questionStatus = Status.PENDING;

	public QuestionNumberLabel(String text) {
		super(text);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setOpaque(true);
		this.setBackground(questionStatus.color);
	}

	public void updateStatus(Status status) {
		this.questionStatus = status;
		this.setBackground(questionStatus.color);
		System.out.println(status);
	}

}
