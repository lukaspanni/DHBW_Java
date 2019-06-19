package dhbw.exercise.ui.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.util.TreeSet;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Election extends JFrame {

	public Election() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Wahl");
		this.setMinimumSize(new Dimension(450, 450));
		TreeSet<Party> parties = new TreeSet<Party>();
		parties.add(new Party("TEST", 42.42, Color.YELLOW));
		parties.add(new Party("LOL", 26.1337, Color.BLACK));
		parties.add(new Party("Unnötig", 5.9, Color.RED));
		parties.add(new Party("ROFL", 18.2, Color.GREEN));
		parties.add(new Party("LOL2", 8.2, Color.BLUE));

		this.add(new Drawing(parties));

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Election();
	}

}
