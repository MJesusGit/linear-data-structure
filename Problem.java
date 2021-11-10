package lists;

import java.util.LinkedList;
import java.util.List;

public class Problem {

	List<Book> problem_List = new LinkedList<Book>();

	/*********************************************************************
	 * Method name: top_10_books * * Name of the original author: Andrés González
	 * Vareña, Maria Jesus * Dueñas Recuero, Juan Gigante Rios. * * Description of
	 * the Method: This method is the one that we will be * using to fill the Top 10
	 * books list. In case that the top_10_books * list is empty the book that is
	 * readed will be introduced directly. * In the case that the list has at least
	 * one element we will send it * to compare it to the compareTo method so we can
	 * place it correctly * in the list * * Calling arguments: In this method the
	 * argument is the list that * has all the books from the file stored * * Return
	 * value: This method will return a list with Book type * objects
	 *********************************************************************/
	
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
	
	
	public List<Book> top_ten_promo(List<Book> top_ten_list) {

		List<Book> ten_promo_list = new LinkedList<Book>();
		for(int i = 0; i<top_ten_list.size();i++) {
			Book bk = new Book(top_ten_list.get(i).getTittle(), top_ten_list.get(i).getAuthor(), top_ten_list.get(i).getGenre(), top_ten_list.get(i).getRating());
			ten_promo_list.add(bk);
		}
		
		//SUBIR ULTIMO AL PRIMER PUESTO Y PONERLE 5 ESTRELLAS
		int last_book = top_ten_list.size()-1;
		Book aux_last_book = new Book(top_ten_list.get(last_book).getTittle(), top_ten_list.get(last_book).getAuthor(), top_ten_list.get(last_book).getGenre(), top_ten_list.get(last_book).getRating());
		ten_promo_list.remove(ten_promo_list.size()-1);
		ten_promo_list.add(0, aux_last_book);
		ten_promo_list.get(0).setRating(5);
		
		//HACER EL REPLACEALL()
		ten_promo_list.replaceAll(new Uo());
		
		return ten_promo_list;
	}
	

	public Problem(List<Book> problem_List) {
		this.problem_List = problem_List;
	}

}