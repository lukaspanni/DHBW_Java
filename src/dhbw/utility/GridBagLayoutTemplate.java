package dhbw.utility;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridBagLayoutTemplate extends JFrame {
	public GridBagLayoutTemplate() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 1;
		this.add(new JButton("Test1"), c);
		c.gridx = 2;
		c.gridy = 0;
		this.add(new JButton("Test2"), c);
		c.gridx = 1;
		c.gridy = 2;
		this.add(new JButton("Test3"), c);

		setTitle("Titel");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

}
