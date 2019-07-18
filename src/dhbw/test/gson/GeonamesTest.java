package dhbw.test.gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;

import com.google.gson.Gson;

public class GeonamesTest {

	public static void main(String[] args) {
		Gson gson = new Gson();

		// String json = "{\"fcodeName\": \"seat of a third-order administrative
		// division\",\"toponymName\": \"Mannheim\",\"countrycode\": \"DE\",\"fcl\":
		// \"P\",\"fclName\": \"city, village,...\",\"name\":
		// \"Mannheim\",\"wikipedia\": \"en.wikipedia.org/wiki/Mannheim\",\"lng\":
		// 8.479547,\"fcode\": \"PPLA3\",\"geonameId\": 2873891,\"lat\":
		// 49.496706,\"population\": 307960}";
		String json = getStringContentFromUrl("https://www.iai.kit.edu/javavl/data/static/cities.json", "UTF-8");
		// Geoname result = gson.fromJson(json, Geoname.class);
		GeonameResults result = gson.fromJson(json, GeonameResults.class);
		System.out.println(json);
		for (Iterator iterator = result.geonames.iterator(); iterator.hasNext();) {
			System.out.print(((Geoname) iterator.next()).getName() + ", ");

		}
	}

	public static String getStringContentFromUrl(String url, String encoding) {
		StringBuilder buffer = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream(), encoding))) {
			String line = br.readLine();
			while (line != null) {
				buffer.append(line);
				line = br.readLine();
			}
		} catch (IOException ex) {
		}
		return buffer.toString();
	}
}
