package dhbw.exercise.collections;

public class Book {

	private String title;
	private String author;
	private int year;
	private String publisher;

	public Book() {
	}

	public Book(String title, String author, String year, String publisher) {
		super();
		this.title = title;
		this.author = author;
		this.year = Integer.parseInt(year);
		this.publisher = publisher;
	}

	public Book(String bookString) {
		String[] sp = bookString.split(";");
		try {
			title = sp[0];
			author = sp[1];
			year = Integer.parseInt(sp[2]);
			publisher = sp[3];
		} catch (Exception e) {

		}
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getYear() {
		return year;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return title + ";" + author + ";" + year + ";" + publisher;
	}

}
