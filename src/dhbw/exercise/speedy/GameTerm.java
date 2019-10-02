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
		return this.points < 0 ? 0 : this.points;
	}

	@Override
	public void setQuestion(int questionIndex, Question q) {
		this.questionText.setText(q.getQuestionText());
		this.labels[questionIndex].updateStatus(Status.ACTIVE);
		for (int i = 0; i < q.getAnswers().length; i++) {
			this.answerButtons[i].setText(q.getAnswers()[i]);
		}
	}

	@Override
	public void setRemainingSeconds(int seconds) {
		this.remainingTime.setText(String.valueOf(seconds));
	}

	@Override
	public void gameIsOver() {
		for (JButton btn : this.answerButtons) {
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
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(this.name);
		this.setSize(400, 400);

		setLayout(new BorderLayout());
		JPanel top = new JPanel(new BorderLayout());
		JPanel toptop = new JPanel();
		this.labels = new QuestionNumberLabel[this.game.getQuestionsCount()];
		for (int i = 0; i < this.labels.length; i++) {
			this.labels[i] = new QuestionNumberLabel(String.valueOf(i));
			toptop.add(this.labels[i]);
		}
		top.add(toptop, BorderLayout.NORTH);
		JPanel mid = new JPanel(new GridLayout(2, 1));
		this.questionText = new JLabel();
		this.remainingTime = new JLabel();
		mid.add(this.questionText);
		mid.add(this.remainingTime);
		top.add(mid, BorderLayout.SOUTH);
		this.add(top, BorderLayout.NORTH);

		JPanel bot = new JPanel(new GridLayout(2, 2));
		for (int i = 0; i < this.answerButtons.length; i++) {
			this.answerButtons[i] = new JButton();
			this.answerButtons[i].setActionCommand(String.valueOf(i));
			this.answerButtons[i].addActionListener(this);
			bot.add(this.answerButtons[i]);
		}
		this.add(bot, BorderLayout.CENTER);
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		this.game.answerSelected(this, Integer.parseInt(e.getActionCommand()));
	}

}
