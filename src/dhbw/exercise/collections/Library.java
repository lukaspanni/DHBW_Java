package dhbw.exercise.collections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Library {

	public enum SortCategories {
		Title, Author, Year, Publisher
	}

	private HashSet books;

	public HashSet getBooks() {
		return books;
	}

	public void setBooks(HashSet books) {
		this.books = books;
	}

	public Library(HashSet books) {
		super();
		this.books = books;
	}

	public Library() {
		super();
		books = new HashSet();
	}

	public void add(Book b) {
		books.add(b);
	}

	public void loadFromFile(String filePath) {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line = br.readLine();
			while (line != null) {
				Book b = new Book(line);
				books.add(b);
				line = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveToFile(String filePath) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
			for (Object b : books) {
				bw.write(((Book) (b)).toString());
				bw.write("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String sort(SortCategories sc) {
		ArrayList a = new ArrayList(books);
		a.sort(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				if (o1 != null && o2 != null) {
					Book b1 = (Book) o1;
					Book b2 = (Book) o2;
					switch (sc) {
					case Title:
						return b1.getTitle().compareTo(b2.getTitle());
					case Author:
						return b1.getAuthor().compareTo(b2.getAuthor());
					case Year:
						return b1.getYear() - b2.getYear();
					case Publisher:
						return b1.getPublisher().compareTo(b2.getPublisher());
					}
				}
				return 0;
			}

		});
		StringBuilder sb = new StringBuilder();
		for (Object o : a) {
			if (o instanceof Book) {
				Book b = (Book) o;
				sb.append(b.toString());
			}
		}
		return sb.toString();
	}
}
