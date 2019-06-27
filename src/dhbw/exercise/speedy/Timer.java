package dhbw.exercise.speedy;

public class Timer implements Runnable {

	private int countdown;
	private Game game;
	private boolean terminated = false;

	public void setGame(Game game) {
		this.game = game;
	}

	public void resetTimer() {
		this.countdown = 10;
	}

	public void terminate() {
		this.terminated = true;
	}

	@Override
	public void run() {

		while (!terminated) {
			try {
				game.update(countdown);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			countdown--;
			if (countdown == 0) {
				game.timeOver();
			}
		}

	}

}
