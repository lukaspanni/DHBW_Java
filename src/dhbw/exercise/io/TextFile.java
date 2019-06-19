package dhbw.exercise.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import dhbw.exercise.io.textfile.LineNumberOutOfBoundsException;

public class TextFile {

	private File file;
	private String[] buffer;

	public TextFile(File f) {
		file = f;
		this.read();
	}

	public TextFile(String fileName) {
		this(new File(fileName));
	}

	public void read() {
		int lineCount = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			while (line != null) {
				lineCount++;
				line = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		buffer = new String[lineCount];
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			int i = 0;
			while (line != null) {
				buffer[i] = line;
				i++;
				line = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void write() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			bw.write(buffer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int availableLines() {
		return buffer.length;
	}

	public String getLine(int i) throws LineNumberOutOfBoundsException {
		if (buffer != null && i < 1 || i >= buffer.length) {
			throw new LineNumberOutOfBoundsException();
		}
		return buffer[i - 1];
	}

	public String[] getLines() {
		return buffer;
	}

	public void setLine(int i, String s) throws LineNumberOutOfBoundsException {
		if (buffer != null && i < 1 || i >= buffer.length) {
			throw new LineNumberOutOfBoundsException();
		}
		buffer[i - 1] = s;
	}

	public void replaceAll(String regexp, String rep) throws LineNumberOutOfBoundsException {
		if (regexp != null && rep != null) {
			for (int i = 1; i <= buffer.length; i++) {
				setLine(i, getLine(i).replaceAll(regexp, rep));
			}
		}
	}

	public void close() {
		buffer = null;
		file = null;
	}

}
