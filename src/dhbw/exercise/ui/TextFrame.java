package dhbw.exercise.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TextFrame extends JFrame {

	private static final long serialVersionUID = 1423909417027228078L;

	File file;

	public TextFrame(String file, int width, int height) {
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.file = new File(file);
		this.setTitle(this.file.getName());

		JTextArea txt = new JTextArea();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			while (line != null) {
				txt.append(line + "\n");
				line = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.add(txt);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		if (args.length < 3) {
			System.out.println("Korrekte Syntax: <filepath> <width> <height>");
		} else if (args.length == 3) {
			try {
				new TextFrame(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
			} catch (NumberFormatException e) {
				System.out.println("Fehlerhafte eingabe");
				e.printStackTrace();
			}
		}
	}

}
