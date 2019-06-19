package dhbw.exercise.ui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShellGame extends JFrame implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new ShellGame();
	}

	JButton btn1 = new JButton("Shell 1");
	JButton btn2 = new JButton("Shell 2");
	JButton btn3 = new JButton("Shell 3");
	JButton statBtn = new JButton("Statistics");
	JButton exitBtn = new JButton("Exit");
	JTextField nameFld = new JTextField(12);
	JTextField outputFld = new JTextField(25);

	int shell;
	int guessCount = 1;

	public ShellGame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Shell Game");
		this.setSize(300, 200);

		JPanel panel = new JPanel();
		panel.add(new JLabel("Player Name"));
		panel.add(nameFld);
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(statBtn);
		panel.add(exitBtn);
		panel.add(outputFld);
		this.add(panel);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		statBtn.addActionListener(this);
		exitBtn.addActionListener(this);

		shell = (int) ((Math.random() * 100) + 1) % 3;

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			checkShell(0);
		} else if (e.getSource() == btn2) {
			checkShell(1);
		} else if (e.getSource() == btn3) {
			checkShell(2);
		} else if (e.getSource() == statBtn) {
			outputFld.setText(getStat());
		} else if (e.getSource() == exitBtn) {
			System.exit(0);
		}
	}

	private String getStat() {
		try (BufferedReader br = new BufferedReader(new FileReader("ShellGameResult.txt"))) {
			String line = br.readLine();
			String[] sp;
			int sum = 0;
			int count = 1;
			while (line != null) {
				sp = line.split(" ");

				try {
					int tmp = Integer.parseInt(sp[1]);
					sum += tmp;
					count++;
				} catch (Exception e) {

				}
				line = br.readLine();
			}
			return "Success after " + ((double) sum / count) + " attempts!";
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	private void checkShell(int i) {
		if (shell == i) {
			outputFld.setText("Attempt " + guessCount++ + " wins: Ball was below shell " + (i + 1));
			try (FileWriter fw = new FileWriter("ShellGameResult.txt", true)) {
				fw.write(nameFld.getText() + " " + guessCount + "\n");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			outputFld.setText("Attempt " + guessCount++ + " Ball was not below shell " + (i + 1));
		}
		shell = (int) ((Math.random() * 100) + 1) % 3;
	}

}
