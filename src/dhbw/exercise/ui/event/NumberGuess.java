package dhbw.exercise.ui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberGuess extends JFrame implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new NumberGuess();
	}

	JTextField nameText = new JTextField(12);
	JTextField numberText = new JTextField(5);
	JButton newBtn = new JButton("New Game");
	JButton okBtn = new JButton("OK");
	JButton bestBtn = new JButton("Best Player");
	JButton exitBtn = new JButton("Exit");
	JTextField outputText = new JTextField(30);
	NumberGuessGame game;

	public NumberGuess() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Number Guessing Game");
		this.setSize(400, 250);

		JPanel panel = new JPanel();
		panel.add(new JLabel("Player name"));
		panel.add(nameText);
		panel.add(new JLabel("enter number between 1 and 1000"));
		panel.add(numberText);
		panel.add(newBtn);
		panel.add(okBtn);
		panel.add(bestBtn);
		panel.add(exitBtn);
		panel.add(outputText);
		this.add(panel);

		newBtn.addActionListener(this);
		okBtn.addActionListener(this);
		numberText.addActionListener(this);
		bestBtn.addActionListener(this);
		exitBtn.addActionListener(this);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitBtn) {
			System.exit(0);
		} else if (e.getSource() == newBtn) {
			if (!nameText.getText().isEmpty()) {
				game = new NumberGuessGame(nameText.getText().replaceAll(" ", ""));
				outputText.setText("Game created");
			}
		} else if (e.getSource() == okBtn || e.getSource() == numberText) {
			if (game != null && !numberText.getText().isEmpty()) {
				try {
					outputText.setText(game.guess(Integer.parseInt(numberText.getText())));
				} catch (NumberFormatException e1) {
					outputText.setText("No valid guess!!");
				}
			}
		} else if (e.getSource() == bestBtn) {
			outputText.setText(getBest());
		}

	}

	private String getBest() {
		try (BufferedReader br = new BufferedReader(new FileReader("NumberGuessResult.txt"))) {
			int min;
			String name;
			String[] sp;
			String line = br.readLine();
			if (line != null) {
				sp = line.split(" ");
				try {
					min = Integer.parseInt(sp[1]);
					name = sp[0];
				} catch (Exception e) {
					return null;
				}
			} else {
				return null;
			}
			line = br.readLine();
			while (line != null) {
				sp = line.split(" ");
				try {
					int tmp = Integer.parseInt(sp[1]);
					if (tmp < min) {
						min = tmp;
						name = sp[0];
					}
				} catch (Exception e) {

				}
			}
			return name;
		} catch (Exception e) {
			return null;
		}
	}

}
