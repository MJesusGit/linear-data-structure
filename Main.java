import java.io.FileNotFoundException;
import java.util.*;

public class Main {

	/************************************************************************
	* Method name: main											 
	*																	 
	* Name of the original author: Andrés González Vareña, Maria Jesus   
	* Dueñas Recuero, Juan Gigante Rios.								 
	*																	 
	* Description of the Method: This is the main of the program where we
	* execute the whole problem. First we create a Scanner and three stacks 
	* that we will be using for the problem. Then we create a Problem object 
	* and we ask for the the route of the file that should be introduced by 
	* terminal. After this we create a ReadFile object and when this is done 
	* we call the methods read_File and the method fill_Stacks to fill the 
	* stacks that we need to the end of the program. After this we will call 
	* the method nine_counter and print the number of nines that we count
	**************************************************************************/
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner keyboard = new Scanner(System.in);
		Stack<Integer> main_First_Stack = new Stack<Integer>();
		Stack<Integer> main_Second_Stack = new Stack<Integer>();
		Stack<Integer> file_Stack = new Stack<Integer>();

		Problem stacks = new Problem(main_First_Stack);

		System.out.println("Introduce the route of the file you want to read");
		String file = keyboard.next();
		ReadFile read = new ReadFile(file);
		file_Stack = read.read_File(file);
		main_Second_Stack = stacks.fill_Stacks(file_Stack);
		System.out.println(stacks.nine_counter(main_Second_Stack));

	}
}