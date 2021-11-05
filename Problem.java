package list;

import java.util.LinkedList;
import java.util.List;

public class Problem {

	
	public List<Book> top_10_book(List<Book> list_book_file){
		List<Book> top_10_book = new LinkedList<Book>();
		for(int i=0; i<list_book_file.size();i++) {
			if(list_book_file.get(i).getRating()>list_book_file.get(i+1).getRating()) {
				top_10_book.add(list_book_file.get(i));
				
				
			}
		}
		
		return list_book_file;
		
	}
	
	
	
	
}
