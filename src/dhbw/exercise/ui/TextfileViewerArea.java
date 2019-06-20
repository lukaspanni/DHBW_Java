package dhbw.exercise.ui;

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextfileViewerArea extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public TextfileViewerArea(File f) {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(10, 1));
		this.setTitle(f.getName());
		JTextArea txt = new JTextArea();
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String line = br.readLine();
			while (line != null) {
				txt.append(line + "\n");
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setSize(400, 400);
		JScrollPane scr = new JScrollPane(txt);
		scr.setSize(400, 400);
		this.setContentPane(scr);
		this.setVisible(true);
	}
}
