package dhbw.exercise.threads.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

	private static String[] urls = new String[] { "http://www.kit.edu", "http://www.google.com",
			"http://moodle.dhbw.de/", "http://www.sueddeutsche.de", "http://www.faz.de", "https://www.spiegel.de",
			"http://www.iai.kit.edu", "https://www.tagesschau.de" };

	public static void main(String[] args) {
		List<PageLoader> pageLoaders = new ArrayList<>();
		for (String url : urls) {
			PageLoader pl = new PageLoader(url);
			pageLoaders.add(pl);
			new Thread(pl).start();
		}

		int finished = 0;
		while (finished < pageLoaders.size()) {
			for (int i = 0; i < pageLoaders.size(); i++) {
				PageLoader pl = pageLoaders.get(i);
				if (pl == null) {
					continue;
				}
				if (pl.pageLoaded()) {
					System.out.print(pl.getURL() + " ");
					if (pl.getPageContent().length() > 40) {
						System.out.println(pl.getPageContent().substring(0, 40));
					} else {
						System.out.println(pl.getPageContent());
					}
					pageLoaders.set(i, null);
					finished++;
				}
			}
		}

	}

}
