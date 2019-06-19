package dhbw.exercise.ui;

import javax.swing.*;

public class ComponentFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public ComponentFrame() {
		setTitle("Aufgabe 1");
		this.setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();

		p.add(new JLabel("JLabel"));
		p.add(new JTextArea(1, 25));
		p.add(new JPasswordField(25));
		p.add(new JButton("BTN"));
		p.add(new JToggleButton("ToggleButton"));
		p.add(new JCheckBox("CheckBox"));
		String[] str = { "Item1", "Item2" };
		p.add(new JComboBox<String>(str));
		ButtonGroup bg = new ButtonGroup();
		JRadioButton b = new JRadioButton("RBtn1");
		JRadioButton b1 = new JRadioButton("RBtn2");
		JRadioButton b2 = new JRadioButton("RBtn3");

		bg.add(b);
		bg.add(b1);
		bg.add(b2);
		p.add(b);
		p.add(b1);
		p.add(b2);

		this.add(p);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ComponentFrame();
	}

}
