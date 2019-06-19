package dhbw.exercise.ui.paint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.TreeSet;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Drawing extends JComponent {

	private TreeSet<Party> parties;

	public Drawing(TreeSet<Party> parties) {
		this.parties = parties;

	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(new Color(173, 216, 230));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.WHITE);
		g.drawLine(0, (int) (getHeight() * 0.25), getWidth(), (int) (getHeight() * 0.25));
		g.drawLine(0, (int) (getHeight() * 0.5), getWidth(), (int) (getHeight() * 0.5));
		g.drawLine(0, (int) (getHeight() * 0.75), getWidth(), (int) (getHeight() * 0.75));
		drawParties(g);
	}

	private void drawParties(Graphics g) {
		int maxHeight = (int) ((getHeight() * 0.8));
		int maxPercent = (int) (parties.first().getPercent());
		int offsetX = 5;
		int barWidth = (int) ((getWidth() * 0.8) / parties.size()) - offsetX;
		int x = (int) (getWidth() * 0.1); // startX
		int startY = (int) (getHeight() * 0.1);
		int textOffset = 15;

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), (int) (getHeight() * 0.07));
		g.setColor(Color.WHITE);
		g.setFont(new Font("Helvetica", Font.BOLD, 14));
		g.drawString("Wahl", 10, 20);

		g.setColor(Color.WHITE);
		g.fillRect(0, startY + maxHeight, getWidth(), (int) (getHeight() * 0.1));

		for (Party p : parties) {
			g.setColor(p.getColor());
			int barHeight = (int) (maxHeight * (p.getPercent() / maxPercent));
			g.fillRect(x, startY + (maxHeight - barHeight), barWidth, barHeight);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Helvetica", Font.BOLD, 14));
			g.drawString(p.getName(), x, startY + maxHeight + textOffset);
			g.drawString(String.valueOf(p.getPercent()) + "%", x, startY + maxHeight + textOffset * 2);

			x += offsetX + barWidth;

		}
	}

}
