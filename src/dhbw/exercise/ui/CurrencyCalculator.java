package dhbw.exercise.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CurrencyCalculator extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new CurrencyCalculator();
	}

	private JTextField textField = new JTextField();
	private JPanel panel = new JPanel();
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private ALis listener = new ALis();

	public CurrencyCalculator() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Currency Converter");
		this.setLayout(new BorderLayout());
		this.add(textField, BorderLayout.NORTH);
		panel.add(btn1 = new JButton("EUR->USD"));
		panel.add(btn2 = new JButton("USD->EUR"));
		panel.add(btn3 = new JButton("Cancel"));
		btn1.addActionListener(listener);
		btn2.addActionListener(listener);
		btn3.addActionListener(listener);

		this.add(panel, BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
	}

	class ALis implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (textField.getText().isEmpty()) {
				textField.setText("Fehler");
			} else {
				double input = 0;
				try {
					input = Double.parseDouble(textField.getText());
				} catch (Exception e2) {
					textField.setText("Fehler");
				}
				if (e.getSource() == btn1) {
					textField.setText(String.valueOf((input * 1.14)));
				} else if (e.getSource() == btn2) {
					textField.setText(String.valueOf((input / 1.14)));
				} else if (e.getSource() == btn3) {
					System.exit(0);
				}
			}
		}
	}

}
