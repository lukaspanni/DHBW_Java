package dhbw.exercise.speedy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import dhbw.exercise.speedy.GameClient.Status;

public class Game {

	private List<Question> selectedQuestions;
	private List<GameClient> clients;
	private boolean gameRunning = false;
	private int lastAnswered;
	private int currentQuestionIndex;
	private long startDate;
	private Timer timer = new Timer();
	private Thread timerThread;

	public Game(List<Question> questions, int questionCount) throws GameException {
		if (questionCount > questions.size()) {
			throw new GameException("Too few questions available");
		}
		Random r = new Random();
		selectedQuestions = new ArrayList<Question>();
		while (selectedQuestions.size() < questionCount) {
			Question q = questions.get(r.nextInt(questions.size()));
			questions.remove(q);
			selectedQuestions.add(q);
		}
		clients = new ArrayList<GameClient>();
		timer.setGame(this);
	}

	public void registerClient(GameClient client) {
		if (!gameRunning) {
			clients.add(client);
		}
	}

	public int getQuestionsCount() {
		return selectedQuestions.size();
	}

	public void startGame() {
		currentQuestionIndex = -1;
		this.gameRunning = true;
		this.startDate = System.currentTimeMillis();
		nextQuestion();
	}

	public void answerSelected(GameClient client, int index) {
		for (GameClient gameClient : clients) {
			gameClient.setAnswerState(currentQuestionIndex, Status.NO_ANSWER);
		}
		if (selectedQuestions.get(currentQuestionIndex).getCorrectIndex() == index) {
			client.setAnswerState(currentQuestionIndex, Status.CORRECT);
		} else {
			client.setAnswerState(currentQuestionIndex, Status.WRONG);
		}
		this.lastAnswered = currentQuestionIndex;
		nextQuestion();

	}

	private void nextQuestion() {
		if (currentQuestionIndex < selectedQuestions.size() - 1) {
			currentQuestionIndex++;
			for (GameClient gameClient : clients) {
				gameClient.setQuestion(currentQuestionIndex, selectedQuestions.get(currentQuestionIndex));
			}
			startTimer();
		} else {
			String message = "Game finished after " + (System.currentTimeMillis() - startDate) / 1000
					+ " seconds, score: ";
			for (GameClient gameClient : clients) {
				gameClient.gameIsOver();
				message += gameClient.getPlayerName() + " (" + gameClient.getPoints() + ")";

			}
			JOptionPane.showMessageDialog(null, message);
			writeHighscore(message);
			this.gameRunning = false;
			this.timer.terminate();
		}
	}

	private void writeHighscore(String message) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("highscore.txt", true))) {
			bw.write(message);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Game Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void startTimer() {
		timer.resetTimer();
		if (timerThread == null) {
			timerThread = new Thread(timer);
			timerThread.start();
		}
	}

	public void update(int seconds) {
		for (GameClient gameClient : clients) {
			gameClient.setRemainingSeconds(seconds);
		}
	}

	public void timeOver() {
		for (GameClient gameClient : clients) {
			gameClient.setAnswerState(currentQuestionIndex, Status.NO_ANSWER);
		}
		nextQuestion();
	}

}
