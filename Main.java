package lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Main {
	
	/*****************************************************************************
	* Method name: main											 
	*																	 
	* Name of the original author: Andrés González Varela, Maria Jesus   
	* Dueñas Recuero, Juan Gigante Rios.								 
	*																	 
	* Description of the Method: This is the main of the program where we
	* execute the whole problem. First we create some lists that we will need
	* throught the whole problem, then we create a file and ask for the 
	* direction of the file. After this we creathe two objects, one from 
	* ReadFile class and another from the Problem class and after this we 
	* fill the list of books calling for the corresponding method. Next we fill 
	* each genre list as it is asked in the problem, then we make the same with
	* the top ten list and after this we use the method to change the list to 
	* the promo list. After we fullfil all the tasks we have a menu so the 
	* user can access to the list that he wants by pressing the corresponding 
	* number or pressing 7 to end the program. 
	****************************************************************************/
	
	public static void main(String [] args)throws FileNotFoundException {
		
		boolean exit = false;
		int option;
		int result = 0;
		List<Book> problem_List = new LinkedList<Book>();
		List<Book> list_book_file = new LinkedList<Book>();
		List<Book> novel_List = new LinkedList<Book>();
		List<Book> scifi_List = new LinkedList<Book>();
		List<Book> biographies_List = new LinkedList<Book>();
		List<Book> children_List = new LinkedList<Book>();
		List<Book> top_ten_list = new LinkedList<Book>();
		List<Book> top_ten_list_promo = new LinkedList<Book>();
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Introduce the route of the file you want to read");
		String file = reader.next();
		ReadFile read = new ReadFile(file);
		Problem lists = new Problem(problem_List);
		list_book_file = read.fill_list(file);
			
		novel_List = lists.fill_lists(list_book_file, "Novel");
		scifi_List = lists.fill_lists(list_book_file, "Sci-Fi");
		biographies_List = lists.fill_lists(list_book_file, "Biography");
		children_List = lists.fill_lists(list_book_file, "Children");
		top_ten_list = lists.top_ten(novel_List, scifi_List, biographies_List, children_List);
		top_ten_list_promo = lists.top_ten_promo(top_ten_list);
		
		while (!exit) {
			System.out.print(
					"Welcome to our library \n 1. Novel books \n 2. Sci-fi books \n 3. Biography books \n 4. Children books \n 5. Top 10 books \n 6. Top 10 books in promo \n 7. Exit");
			System.out.print("\nSelect an option: ");
			option = reader.nextInt();

			switch (option) {
			case 1:
				System.out.println("-----------------------------------------------");
				System.out.println("\n This is our Novel list");
				
				for (int i = 0; i < novel_List.size(); i++) {
					System.out.println(novel_List.get(i).toString());
				}
				break;
				
			case 2:
				System.out.println("-----------------------------------------------");
				System.out.println("\n This is our Sci-Fi list");
				
				for (int i = 0; i < scifi_List.size(); i++) {
					System.out.println(scifi_List.get(i).toString());
				}
				break;
				
			case 3:
				System.out.println("-----------------------------------------------");
				System.out.println("\n This is our Biographies list");
				
				for (int i = 0; i < biographies_List.size(); i++) {
					System.out.println(biographies_List.get(i).toString());
				}
				break;
				
			case 4:
				System.out.println("-----------------------------------------------");
				System.out.println("\n This is our Children list");
				
				for (int i = 0; i < children_List.size(); i++) {
					System.out.println(children_List.get(i).toString());
				}
				break;
				
			case 5:
				System.out.println("-----------------------------------------------");
				System.out.println("\n This is our top ten list");
				
				for(int i = 0; i < top_ten_list.size(); i++) {
					System.out.println(top_ten_list.get(i).toString());
				}
				break;
				
			case 6:
				System.out.println("-----------------------------------------------");
				System.out.println("\n This is our top ten list with promo");
				
				for(int i = 0; i < top_ten_list_promo.size(); i++) {
					System.out.println(top_ten_list_promo.get(i).toString());
				}				
				break;
				
			case 7:
				System.out.print("Goodbye!");
				System.exit(0);
				break;
				
			default:
				System.out.print("Incorrect option, try again");
			}
		}
	}

}