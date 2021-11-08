package lists;

import java.util.LinkedList;
import java.util.List;

public class Problem {
	List<Book> list_adult = new LinkedList<Book>();
	List<Book> list_children = new LinkedList<Book>();
	List<Book> top_10_books = new LinkedList<Book>();
	
	/*********************************************************************
	* Method name: top_10_books											 *
	*																	 *
	* Name of the original author: Andrés González Vareña, Maria Jesus   *
	* Dueñas Recuero, Juan Gigante Rios.								 *
	*																	 *
	* Description of the Method: This method is the one that we will be  *
	* using to fill the Top 10 books list. In case that the top_10_books *
	* list is empty the book that is readed will be introduced directly. *
	* In the case that the list has at least one element we will send it *
	* to compare it to the compareTo method so we can place it correctly *
	* in the list														 *
	*																	 *
	* Calling arguments: In this method the argument is the list that 	 *
	* has all the books from the file stored						     *
	*																     *
	* Return value: This method will return a list with Book type 		 *
	* objects  															 *
	*********************************************************************/
	
	public List<Book> top_10_book(List<Book> list_book_file) {
		Book compareBook;
		for (int i = 0; i < list_book_file.size(); i++) {
			if (top_10_books.isEmpty()) {
				top_10_books.add(list_book_file.get(i));
			}else {
				compareBook = list_book_file.get(i);
				for (int j = 0; j < top_10_books.size(); i++) {
					if (top_10_books.get(i).compareTo(compareBook)==-1) {
						top_10_books.add(i+1, compareBook);
					}else if (top_10_books.get(i).compareTo(compareBook)==1) {
						top_10_books.add(i, compareBook);
					}
				}
			}
		}
		return top_10_books;
	}

	public List<Book> list_adults(List<Book> list_book_file) {
		for (int i = 0; i < list_book_file.size(); i++) {
			if (list_book_file.get(i).getGenre() == "Sci-Fi" || list_book_file.get(i).getGenre() == "Biography"|| list_book_file.get(i).getGenre() == "Novel") {
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

	public Problem(List<Book> list_adult, List<Book> list_children, List<Book> top_10_book) {
		this.list_adult = list_adult;
		this.list_children = list_children;
		this.top_10_books = top_10_books;
	}
	
}