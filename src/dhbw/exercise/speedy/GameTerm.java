package dhbw.exercise.speedy;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameTerm extends JFrame implements GameClient, ActionListener {

	private JLabel questionText;
	private JLabel remainingTime;
	private JButton[] answerButtons = new JButton[4];
	private QuestionNumberLabel[] labels;
	private Game game;
	private String name;
	private int points = 0;

	@Override
	public String getPlayerName() {
		return this.name;
	}

	@Override
	public int getPoints() {
		return points < 0 ? 0 : points;
	}

	@Override
	public void setQuestion(int questionIndex, Question q) {
		this.questionText.setText(q.getQuestionText());
		this.labels[questionIndex].updateStatus(Status.ACTIVE);
		for (int i = 0; i < q.getAnswers().length; i++) {
			answerButtons[i].setText(q.getAnswers()[i]);
		}
	}

	@Override
	public void setRemainingSeconds(int seconds) {
		this.remainingTime.setText(String.valueOf(seconds));
	}

	@Override
	public void gameIsOver() {
		for (JButton btn : answerButtons) {
			btn.setEnabled(false);
		}
	}

	@Override
	public void setAnswerState(int questionIndex, Status status) {
		this.labels[questionIndex].updateStatus(status);
		this.points += status.getPoints();

	}

	public GameTerm(String name, Game game) {
		this.game = game;
		this.name = name;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle(this.name);
		this.setSize(400, 400);

		this.setLayout(new BorderLayout());
		JPanel top = new JPanel(new BorderLayout());
		JPanel toptop = new JPanel();
		labels = new QuestionNumberLabel[this.game.getQuestionsCount()];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new QuestionNumberLabel(String.valueOf(i));
			toptop.add(labels[i]);
		}
		top.add(toptop, BorderLayout.NORTH);
		JPanel mid = new JPanel(new GridLayout(2, 1));
		questionText = new JLabel();
		remainingTime = new JLabel();
		mid.add(questionText);
		mid.add(remainingTime);
		top.add(mid, BorderLayout.SOUTH);
		this.add(top, BorderLayout.NORTH);

		JPanel bot = new JPanel(new GridLayout(2, 2));
		for (int i = 0; i < answerButtons.length; i++) {
			answerButtons[i] = new JButton();
			answerButtons[i].setActionCommand(String.valueOf(i));
			answerButtons[i].addActionListener(this);
			bot.add(answerButtons[i]);
		}
		this.add(bot, BorderLayout.CENTER);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.game.answerSelected(this, Integer.parseInt(e.getActionCommand()));
	}

}
