package dhbw.utility;

import javax.swing.JFrame;

import dhbw.exercise.speedy.Game;

public class Timer implements Runnable {

	private int countdown;
	private JFrame target;
	private boolean terminated = false;

	public void setGame(JFrame targetFrame) {
		this.target = targetFrame;
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
				if (countdown > 0) {
					//update target
					target.setTitle(String.valueOf(countdown));
					Thread.sleep(1000);
				} else {
					//Time over
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			countdown--;
		}

	}

}

