package list;

import java.util.Scanner;

public class Main {
	
	public static void main(String [] args) {
		
		 boolean exit = false;
	        int option;
	        

	        Scanner reader = new Scanner(System.in);
	        
	        while (!exit) {
	            System.out.print("Welcome to our library \n 1. Top 10 books 1 \n 2. Top 3 adult books 2 \n 3. Top children book \n 4. Top adult and children books\n 5. Top algo\n 6. Exit");
	            System.out.print("\nSelect an option: ");
	            option = reader.nextInt();
	           
	            switch (option) {
	                case 1:
	                  
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
