package dhbw.exercise.threads.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg Cooperative
 * State University.
 *
 * (C) 2016-2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.1
 */
public class ReadURL {
	public static String getStringContentFromUrl(String url, String encoding) {
		StringBuilder buffer = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream(), encoding))) {
			String line = br.readLine();
			while (line != null) {
				buffer.append(line).append("##");
				line = br.readLine();
			}
		} catch (IOException ex) {
		}
		return buffer.toString();
	}

}