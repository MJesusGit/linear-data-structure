package lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Main {
	
	public static void main(String [] args)throws FileNotFoundException {
		
		boolean exit = false;
		int option;
		int result = 0;
		List<Book> list_book_file = new LinkedList<Book>();
		List<Book> top_10_books = new LinkedList<Book>();
		List<Book> list_adult = new LinkedList<Book>();
		List<Book> list_children = new LinkedList<Book>();
		Scanner reader = new Scanner(System.in);
		System.out.println("Introduce the route of the file you want to read");
		String file = reader.next();
		ReadFile read = new ReadFile(file);
		Problem lists = new Problem(list_adult, list_children, top_10_books);
		list_book_file = read.fill_list(file);
		for (int i = 0; i < list_book_file.size(); i++) {
			System.out.println(list_book_file.get(i).toString());
		}
		
		while (!exit) {
			System.out.print(
					"Welcome to our library \n 1. Top 10 books 1 \n 2. Top 3 adult books 2 \n 3. Top children book \n 4. Top adult and children books\n 5. Top algo\n 6. Exit");
			System.out.print("\nSelect an option: ");
			option = reader.nextInt();

			switch (option) {
			case 1:
				top_10_books = lists.top_10_book(list_book_file);
				for (int j = 0; j < top_10_books.size();j++) {
					System.out.println(top_10_books.get(j).toString());
				}
				break;
			case 2:

				break;
			case 3:

				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				System.out.print("Good bye!");
				System.exit(0);
				break;
			default:
				System.out.print("Incorrect option, try again");
			}
		}
	}

}