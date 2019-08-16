package practice;

import javax.swing.JFrame;

public class Timer implements Runnable {

	private boolean terminated = false;
	private long counter;
	private JFrame target;
	
	public void terminate() {
		this.terminated = true;
	}
	
	public void setTarget(JFrame frame) {
		target = frame;
	}

	@Override
	public void run() {

		while (!terminated) {
			try {
				counter++;
				target.setTitle(String.valueOf(counter));
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
