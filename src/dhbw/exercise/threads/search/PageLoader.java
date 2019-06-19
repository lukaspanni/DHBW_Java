package dhbw.exercise.threads.search;

public class PageLoader implements Runnable {

	private String pageContent;
	private String url;

	public PageLoader(String url) {
		this.url = url;
	}

	@Override
	public void run() {
		pageContent = ReadURL.getStringContentFromUrl(url, "UTF-8");
	}

	public boolean pageLoaded() {
		return pageContent != null;
	}

	public String getPageContent() {
		return pageContent;
	}

	public String getURL() {
		return url;
	}

}
