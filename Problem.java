package lists;

import java.util.LinkedList;
import java.util.List;

public class Problem {
	List<Book> list_adult = new LinkedList<Book>();
	List<Book> list_children = new LinkedList<Book>();

	public List<Book> top_10_book(List<Book> list_book_file) {
		List<Book> top_10_book = new LinkedList<Book>();
		for (int i = 0; i < list_book_file.size(); i++) {
			if (list_book_file.get(i).getRating() > list_book_file.get(i + 1).getRating()) {
				top_10_book.add(list_book_file.get(i));

			}
		}

		return list_book_file;

	}

	public List<Book> list_adults(List<Book> list_book_file) {
		for (int i = 0; i < list_book_file.size(); i++) {
			if (list_book_file.get(i).getGenre() == "Sci-Fi" || list_book_file.get(i).getGenre() == "Biography"
					|| list_book_file.get(i).getGenre() == "Novel") {
				list_adult.add(list_book_file.get(i));

			}
		}

		return list_adult;
	}

	public List<Book> list_children(List<Book> list_book_file) {
		for (int i = 0; i < list_book_file.size(); i++) {
			if (list_book_file.get(i).getGenre() == "Children") {
				list_children.add(list_book_file.get(i));

			}
		}

		return list_children;
	}

}