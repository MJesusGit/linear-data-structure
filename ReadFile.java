package list;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReadFile {
	private String fileName;

	public ReadFile(String fileName) {
		this.fileName = fileName;
	}

	public List<Book> fill_list() throws FileNotFoundException {
		File file = new File(fileName);
		List<Book> list_book_file = new LinkedList();
		Scanner reader = new Scanner(file);
		String author, tittle, aux_rating;
		Book each_Book;
		String each_line_Book;
		double rating;

		do {
			each_line_Book = reader.nextLine();
			StringTokenizer books_Separator = new StringTokenizer(each_line_Book, "\n");
			StringTokenizer category_Separator = new StringTokenizer(each_line_Book, ";");
			do {
				tittle = category_Separator.nextToken();
				author = category_Separator.nextToken();
				aux_rating = category_Separator.nextToken();
				rating = Double.parseDouble(aux_rating);

				each_Book = new Book(tittle, author, rating);
				list_book_file.add(each_Book);

			} while (books_Separator.hasMoreTokens());
		} while (reader.hasNext());

		reader.close();
		return list_book_file;

	}

}
