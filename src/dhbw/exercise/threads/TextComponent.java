package dhbw.exercise.threads;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class TextComponent extends JComponent {

	private String text;

	private String[] fontNames = new String[] { "Sans-Serif", "Monospaced", "Serif", "Arial", "Helvetica",
			"Comic Sans MS" };

	@Override
	protected void paintComponent(Graphics g) {
		Random r = new Random();
		int x = 20;
		int y = 80;
		int xOffset;
		int yOffset;
		int fontIndex;
		int fontSize;
		Color charColor;
		Font font;

		for (char c : text.toCharArray()) {
			xOffset = r.nextInt(31) + 20; // zw 20 u. 50
			yOffset = r.nextInt(41) - 20; // zw, -20 u. 20
			fontIndex = r.nextInt(fontNames.length);
			fontSize = r.nextInt(51) + 10; // zw 10 u. 60
			charColor = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
			font = new Font(fontNames[fontIndex], Font.BOLD, fontSize);
			g.setColor(charColor);
			g.setFont(font);
			g.drawString(String.valueOf(c), x += xOffset, y + yOffset);
		}
	}

	public TextComponent(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
