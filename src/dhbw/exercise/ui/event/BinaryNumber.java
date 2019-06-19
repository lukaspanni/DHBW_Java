package dhbw.exercise.ui.event;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class BinaryNumber extends JFrame implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new BinaryNumber();
	}

	JToggleButton[] btns = new JToggleButton[8];
	JLabel resultLabel;

	public BinaryNumber() {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(700, 300);
		this.setTitle("Binary Number");

		JPanel panel = new JPanel();
		ImageIcon imgOff = new ImageIcon("off.png");
		ImageIcon imgOn = new ImageIcon("on.png");
		for (int i = 0; i < 8; i++) {
			btns[i] = new JToggleButton();
			btns[i].addActionListener(this);
			btns[i].setIcon(imgOff);
			btns[i].setSelectedIcon(imgOn);
			btns[i].setActionCommand(String.valueOf(i));
			panel.add(btns[i]);
		}
		resultLabel = new JLabel("0");
		resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(resultLabel);
		this.add(panel);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int num = 0;
		for (int i = 0; i < btns.length; i++) {
			if (btns[i].isSelected()) {
				num += Math.pow(2, 7 - i);
			}
		}
		resultLabel.setText(String.valueOf(num));
	}

}
