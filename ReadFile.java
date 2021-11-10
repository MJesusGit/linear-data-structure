package lists;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReadFile {
	private String fileName;

	/**************************************************************************
	* Method name: Readfile											 
	*																	 
	* Name of the original author: Andrés González Varela, Maria Jesus   
	* Dueñas Recuero, Juan Gigante Rios.								 
	*																	 
	* Description of the Method: This method will read the file that is 
	* located in the root that it is given. The method will read books 
	* one by one and we use the StingTokenizer to strip each by words. 
	* Then the book will be add to a list with all of its variables (Tittle,
	* Author, Genre and Rating). 
	* 					 
	* Calling arguments: This method receives a String with the direction
	* of the file
	* 																     
	* Return value: This method will return a list named list_book_file
	****************************************************************************/
	
	public List<Book> fill_list(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		List<Book> list_book_file = new LinkedList<Book>();
		Scanner reader = new Scanner(file);
		String author, tittle, genre, aux_rating;
		Book each_Book;
		String each_line_Book;
		double rating;

		do {
			each_line_Book = reader.nextLine();
			StringTokenizer category_Separator = new StringTokenizer(each_line_Book, ";");
			do {
				tittle = category_Separator.nextToken();
				author = category_Separator.nextToken();
				genre = category_Separator.nextToken();
				aux_rating = category_Separator.nextToken();
				rating = Double.parseDouble(aux_rating);
				each_Book = new Book(tittle, author, genre, rating);
				list_book_file.add(each_Book);

			} while (category_Separator.hasMoreTokens());
		} while (reader.hasNext());
		reader.close();
		return list_book_file;

	}

	/***************************************************************************************************************
	 * This method is the constructor of this class																   *
	 ***************************************************************************************************************/
	
	public ReadFile(String fileName) {
		this.fileName = fileName;
	}

}