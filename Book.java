package lists;

import java.util.Arrays;

public class Book implements Comparable<Book>{
	private String author;
	private String tittle;
	private String genre;
	private double rating;

	/***************************************************************************************************************
	 * This method is the constructor of this class																   *
	 ***************************************************************************************************************/
	
	public Book(String tittle, String author, String genre, double rating) {
		this.author = author;
		this.tittle = tittle;
		this.genre = genre;
		this.rating = rating;
	}
	
	/*********************************************************************
	* Method name: compareTo											 
	*																	 
	* Name of the original author: Andrés González Varela, Maria Jesus  
	* Dueñas Recuero, Juan Gigante Rios.								 
	*																	 
	* Description of the Method: This method is the one that we will be  
	* using for compare the rating of each book to position it in the 	 
	* Top 10 list if it is necessary. In case that the rating is the 	 
	* same we will be comparing the titles in alphabetical order. 		 
	*																	 
	* Calling arguments: In this method we introduce an argument of the  
	* type Book an in the case of this method is going to be the Book    
	* that will be compared with the other ones in the list.			 
	* 																     
	* Return value: This method will return a value of int type that is  
	* going to be 1 or -1 depending on the result of the comparations.  
	*********************************************************************/
	
	public int compareTo(Book b) {
		int result = 0;
		if (rating > b.getRating()) {
			result = -1;
		} else if (rating < b.getRating()) {
			result = 1;
		} else if (rating == b.getRating()) {
			String [] titulos = new String[] {tittle, b.getTittle()};
			Arrays.sort(titulos);
			if (titulos[0].equals(tittle)) {
				result = -1;
			} else if (titulos[0].equals(b.getTittle())) {
				result = 1;
			}
		}
		return result;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {

		return "Author=" + author + "\nTittle=" + tittle + "\nGenre=" + genre + "\nrating=" + rating +"\n";
	}
}