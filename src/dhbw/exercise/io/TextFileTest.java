package dhbw.exercise.io;

import dhbw.exercise.io.textfile.LineNumberOutOfBoundsException;

public class TextFileTest {

	public static void main(String[] args) {
		TextFile tf = new TextFile("text.txt");
		for (String string : tf.getLines()) {
			System.out.println(string);
		}
		try {
			tf.replaceAll("meine", "unsere");
			System.out.println("\nErsetzt: meine -> unsere\n");
			for (String string : tf.getLines()) {
				System.out.println(string);
			}
		} catch (LineNumberOutOfBoundsException e) {
			e.printStackTrace();
		}

	}

}
