package list;

public class Book {
	private String author;
	private String tittle;
	private double rating;
	
		
	public Book(String author, String tittle, double rating) {
		this.author = author;
		this.tittle = tittle;
		this.rating = rating;
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
	
	
	
}
