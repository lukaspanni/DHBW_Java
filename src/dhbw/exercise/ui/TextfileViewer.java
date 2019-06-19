package dhbw.exercise.ui;

import java.awt.GridLayout;
import java.awt.Label;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;

public class TextfileViewer extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public TextfileViewer(File f) {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(10, 1));
		this.setTitle(f.getName());
		this.setSize(400, 500);
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			for (int i = 0; i < 10; i++) {
				String line = br.readLine();
				if (line != null) {
					this.add(new Label(line));
				}
			}
		} catch (Exception e) {
			System.err.println("Fehler " + e.getStackTrace());
		}
		this.setVisible(true);
	}

}
