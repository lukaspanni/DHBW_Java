package dhbw.exercise.io.textfile;

import java.io.BufferedReader;
import java.io.FileReader;

public class TextFileLines {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			int lineCounter = 1;
			while (line != null && lineCounter <= 5) {
				if (lineCounter >= 2) {
					sb.append(line);
					sb.append("\n");
				}
				line = br.readLine();
				lineCounter++;
			}
			System.out.println(sb.toString());
			System.out.println(sb.toString().replace("\n", ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
