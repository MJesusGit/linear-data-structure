package lists;

import java.util.LinkedList;
import java.util.List;

public class Problem {

	List<Book> problem_List = new LinkedList<Book>();

	/********************************************************************************
	 * Method name: fill_lists
	 * 
	 * Name of the original author: Andrés González Varela, Maria Jesus 
	 * Dueñas Recuero, Juan Gigante Rios. 
	 * 
	 * Description of the Method: This method is the one that we will be
	 * using to fill the lists that corresponds to each genre (Novel, Sci-fi,
	 * Biography and Children books). First of all the method checks if the list is 
	 * empty, if its not the method will start comparing the book that we want to 
	 * introduce so all the books are stored in the correct order, by rating and 
	 * alphabetical order.
	 * 
	 * Calling arguments: In this method the argument is the list that has all the 
	 * books from the file stored and a String with the genre we want to store. 
	 *
	 * Return value: This method will return a list with Book type objects ordered
	 ********************************************************************************/
	
	public List<Book> fill_lists(List<Book> list_book_file, String genre) {
		Book compareBook;
		List<Book> genre_List = new LinkedList<Book>();
		for (int i = 0; i < list_book_file.size(); i++) {
			if (list_book_file.get(i).getGenre().equals(genre)) {
				if (genre_List.isEmpty()) {
					genre_List.add(list_book_file.get(i));
				} else {
					boolean is_inside = false;
					compareBook = list_book_file.get(i);
					for (int j = 0; j < genre_List.size(); j++) {
						if (genre_List.get(j).compareTo(compareBook) == 1) {
							Book listBook = genre_List.get(j);
							genre_List.set(j, compareBook);
							genre_List.add(j + 1, listBook);
							is_inside = true;
							break;
						}
					}
					if (is_inside == false) {
						genre_List.add(compareBook);
					}
				}
			}
		}
		return genre_List;
	}

	/**********************************************************************************
	* Method name: top_ten
	* 
	* Name of the original author: Andrés González Varela, Maria Jesus 
	* Dueñas Recuero, Juan Gigante Rios. 
	* 
	* Description of the Method: This method will create a top ten with the 
	* three best books from the adult lists (Novel, Biography and Sci-Fi) and
	* the best book from the children list. First we add the books in an auxiliar 
	* list and after we have this we will order the books by Rating and alphabetically
	* using the same method that we used to create the genre lists. 
	* 
	* Calling arguments: In this method the arguments are the four list with the books
	* of each genre.  
	*
	* Return value: This method will return the list with the top 10 books made.
	***********************************************************************************/
	
	public List<Book> top_ten(List<Book> novel_list, List<Book> scifi_list, List<Book> biography_list, List<Book> children_list) {

		List<Book> aux_ten_list = new LinkedList<Book>();
		for (int i = 0; i < 3; i++) {
			aux_ten_list.add(novel_list.get(i));
			aux_ten_list.add(scifi_list.get(i));
			aux_ten_list.add(biography_list.get(i));
			if (i == 0) {
				aux_ten_list.add(children_list.get(i));
			}
		}

		Book compareBook;
		List<Book> top_ten_list = new LinkedList<Book>();
		for (int i = 0; i < aux_ten_list.size(); i++) {
			if (top_ten_list.isEmpty()) {
				top_ten_list.add(aux_ten_list.get(i));
			} else {
				boolean is_inside = false;
				compareBook = aux_ten_list.get(i);
				for (int j = 0; j < top_ten_list.size(); j++) {
					if (top_ten_list.get(j).compareTo(compareBook) == 1) {
						Book listBook = top_ten_list.get(j);
						top_ten_list.set(j, compareBook);
						top_ten_list.add(j + 1, listBook);
						is_inside = true;
						break;
					}
				}
				if (is_inside == false) {
					top_ten_list.add(compareBook);
				}
			}
		}

		return top_ten_list;
	}
	
	/**********************************************************************************
	* Method name: top_ten_promo
	* 
	* Name of the original author: Andrés González Varela, Maria Jesus 
	* Dueñas Recuero, Juan Gigante Rios. 
	* 
	* Description of the Method: This method will fill a list with all the books that 
	* we had in the top_ten method so we moved them to a new list to work wuith them.
	* After we get our list we rise the last book in the list to the first position
	* and set his Rating in the maximum which is 5. After this we use the replaceAll()
	* method and we add 0.5 points to each Rating. 
	* 
	* Calling arguments: In this method the arguments is the top_ten_list.
	*
	* Return value: This method will return the new list named ten_promo_list
	***********************************************************************************/
	
	public List<Book> top_ten_promo(List<Book> top_ten_list) {

		List<Book> ten_promo_list = new LinkedList<Book>();
		for(int i = 0; i<top_ten_list.size();i++) {
			Book bk = new Book(top_ten_list.get(i).getTittle(), top_ten_list.get(i).getAuthor(), top_ten_list.get(i).getGenre(), top_ten_list.get(i).getRating());
			ten_promo_list.add(bk);
		}
		
		//RISE THE BOOK TO THE FIRST POSITION AND SET HIS RATING IN 5
		Book aux_last_book = ten_promo_list.get(ten_promo_list.size()-1);
		ten_promo_list.remove(ten_promo_list.size()-1);
		ten_promo_list.add(0, aux_last_book);
		ten_promo_list.get(0).setRating(5);
		
		//USE REPLACEALL()
		ten_promo_list.replaceAll(new Uo());
		
		return ten_promo_list;
	}
	
	/***************************************************************************************************************
	 * This method is the constructor of this class																   *
	 ***************************************************************************************************************/
	
	public Problem(List<Book> problem_List) {
		this.problem_List = problem_List;
	}

}