package stack;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws FileNotFoundException {
		@SuppressWarnings("resource")
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
