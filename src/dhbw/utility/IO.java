package dhbw.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class IO {

	public static void writeFile() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt", true))) {
			bw.write("Text");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void readFile() {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
			String line = br.readLine();
			while (line != null) {
				sb.append(line+"\n");
				line = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void showErrorDialog(Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

	}
}
