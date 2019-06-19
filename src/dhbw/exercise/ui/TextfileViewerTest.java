package dhbw.exercise.ui;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class TextfileViewerTest {
	public static void main(String[] args) {
		JFileChooser fileDialog = new JFileChooser();
		fileDialog.setFileFilter(new FileFilter() {
			@Override
			public boolean accept(File f) {
				return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");
			}

			@Override
			public String getDescription() {
				return "Text Files";
			}
		});
		int state = fileDialog.showOpenDialog(null);
		// Datei ausgewählt
		if (state == JFileChooser.APPROVE_OPTION) {
			// new TextfileViewer(fileDialog.getSelectedFile());
			new TextfileViewerArea(fileDialog.getSelectedFile());
		}
	}
}
