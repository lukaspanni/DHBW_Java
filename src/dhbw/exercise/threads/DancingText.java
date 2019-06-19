package dhbw.exercise.threads;

import java.awt.Component;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class DancingText extends JFrame {

	public DancingText() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Dancing Text");
		this.setSize(700, 200);
		TextComponent tc = new TextComponent("Dancing Text LoL");
		this.add(tc);
		this.setVisible(true);
		new Update(tc).start();
	}

	public static void main(String[] args) {
		new DancingText();
	}

	private class Update extends Thread {
		private Component c;

		public Update(Component c) {
			this.c = c;
		}

		@Override
		public void run() {
			while (true) {
				c.repaint();
				try {
					sleep(150);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
