package dhbw.exercise.threads;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class TrafficLightComponent extends JComponent implements Runnable {

	private LightPhase[] phase;
	private int currentPhase = 0;

	public TrafficLightComponent() {
		phase = new LightPhase[] { new LightPhase(true, false, false, 2000), new LightPhase(true, true, false, 500),
				new LightPhase(false, false, true, 5000), new LightPhase(false, true, false, 1000) };

	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());

		int width = getWidth() / 3;
		int x = (getWidth() / 2) - (width / 2);
		int startY = (getHeight() / 3) - width;
		int yOffset = (int) (width * 1.2);

		g.setColor(phase[currentPhase % phase.length].getTop()); // top
		g.fillOval(x, startY, width, width);
		g.setColor(phase[currentPhase % phase.length].getMid()); // mid
		g.fillOval(x, startY + yOffset, width, width);
		g.setColor(phase[currentPhase % phase.length].getBot()); // bot
		g.fillOval(x, startY + 2 * yOffset, width, width);

	}

	@Override
	public void run() {
		while (true) {
			this.repaint();
			try {
				Thread.sleep(phase[currentPhase % phase.length].getDuration());
			} catch (Exception e) {
				e.printStackTrace();
			}
			currentPhase++;
		}
	}

	private class LightPhase {
		private boolean top;
		private boolean mid;
		private boolean bot;
		private int duration;

		private LightPhase(boolean t, boolean m, boolean b, int d) {
			this.top = t;
			this.mid = m;
			this.bot = b;
			this.duration = d >= 0 ? d : 1000;
		}

		public Color getTop() {
			return top ? Color.red : Color.white;
		}

		public Color getMid() {
			return mid ? Color.yellow : Color.white;
		}

		public Color getBot() {
			return bot ? Color.green : Color.white;
		}

		public int getDuration() {
			return duration;
		}

	}

}
