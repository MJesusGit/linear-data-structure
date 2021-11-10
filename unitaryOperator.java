package lists;

import java.util.*;
import java.util.function.UnaryOperator;

class Uo implements UnaryOperator<Book> {
	
	/**********************************************************************
	* Method name: apply 										 
	*																	 
	* Name of the original author: Andrés González Varela, Maria Jesus   
	* Dueñas Recuero, Juan Gigante Rios.								 
	*																	 
	* Description of the Method: In this class we access the Ratings of 
	* the books so we can modify them when we need with the replaceAll() 
	* method when we call it in the top_ten_promo method for 
	* modify the ratings as is asked, in our case is adding 0.5 points 
	***********************************************************************/
	
   public Book apply(Book book_to_replace) {
      book_to_replace.setRating(book_to_replace.getRating()+0.5);
      return book_to_replace;
   }
}