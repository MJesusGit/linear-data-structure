package lists;

import java.util.*;
import java.util.function.UnaryOperator;

class Uo implements UnaryOperator<Book> {
   public Book apply(Book book_to_replace) {
      book_to_replace.setRating(book_to_replace.getRating()+0.5);
      return book_to_replace;
   }
}