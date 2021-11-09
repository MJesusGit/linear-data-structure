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
	* Name of the original author: Andr�s Gonz�lez Vare�a, Maria Jesus   *
	* Due�as Recuero, Juan Gigante Rios.								 *
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
	* objects  		
	* D:\WORKSPACE_ECLIPSE\lists\src\lists\books.txt													 *
	*********************************************************************/
	
	public List<Book> top_10_book(List<Book> list_book_file) {
		Book compareBook;
		for (int i = 0; i < list_book_file.size(); i++) {
			if (top_10_books.isEmpty()) {
				top_10_books.add(list_book_file.get(i));
			} else {
				compareBook = list_book_file.get(i);
				for (int j = 0; j < top_10_books.size(); j++) {
					if (top_10_books.get(j).compareTo(compareBook) == 1 || top_10_books.get(j).compareTo(compareBook) == 0) {
						Book listBook = top_10_books.get(j);
						top_10_books.set(j, compareBook);
						top_10_books.add(j + 1, listBook);
						if (top_10_books.size() > 10) {
							top_10_books.remove(top_10_books.size() - 1);
						}
						break;
					}
				}
				if(top_10_books.size() < 10) {
					top_10_books.add(compareBook);
				}
			}
		}
		return top_10_books;
	}

	public List<Book> list_adults(List<Book> list_book_file) {
		Book compareBook;
		for (int i = 0; i < list_book_file.size(); i++) {
			if (list_book_file.get(i).getGenre().equals("Sci-Fi") || list_book_file.get(i).getGenre().equals("Biography") || list_book_file.get(i).getGenre().equals("Novel")) {
				if (list_adult.isEmpty()) {
					list_adult.add(list_book_file.get(i));
				} else {
					compareBook = list_book_file.get(i);
					for (int j = 0; j < list_adult.size(); j++) {
						if (list_adult.get(j).compareTo(compareBook) == 1 || list_adult.get(j).compareTo(compareBook) == 0) {
							Book listBook = list_adult.get(j);
							list_adult.set(j, compareBook);
							list_adult.add(j + 1, listBook);
							if (list_adult.size() > 3) {
								list_adult.remove(list_adult.size() - 1);
							}
							break;
						}
					}
					if (list_adult.size() < 3) {
						list_adult.add(compareBook);
					}
				}
				
			}
		}
		return list_adult;
	}

	public List<Book> list_children(List<Book> list_book_file) {
		Book compareBook;
		for (int i = 0; i < list_book_file.size(); i++) {
			if (list_book_file.get(i).getGenre().equals("Children")) {
				if (list_children.isEmpty()) {
					list_children.add(list_book_file.get(i));
				} else {
					compareBook = list_book_file.get(i);
					for (int j = 0; j < list_children.size(); j++) {
						if (list_children.get(j).compareTo(compareBook) == 1 || list_children.get(j).compareTo(compareBook) == 0) {
							Book listBook = list_children.get(j);
							list_children.set(j, compareBook);
							list_children.add(j + 1, listBook);
							if (list_children.size() > 3) {
								list_children.remove(list_children.size() - 1);
							}
							break;
						}
					}
					if (list_children.size() < 3) {
						list_children.add(compareBook);
					}
				}
				
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