package dhbw.exercise.io;

import java.io.File;

public class Files {

	public static void main(String[] args) {
		File folder = new File("myDir");
		folder.mkdir();
		File files[] = new File[3];
		files[0] = new File("myDir/foo1");
		files[1] = new File("myDir/foo2");
		files[2] = new File("myDir/foo3");

		try {
			for (File file : files) {
				file.createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(folder.getAbsolutePath());
		for (File file : folder.listFiles()) {
			System.out.println(file.getAbsolutePath());
			file.delete();
		}

		try {
			folder.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
