package stacks;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner keyboard = new Scanner(System.in);
		Stack<Integer> main_First_Stack = new Stack<Integer>();
		Stack<Integer> main_Second_Stack = new Stack<Integer>();
		Problem stacks = new Problem(main_First_Stack);
		
		System.out.println("Introduce the route of the file you want to read");
		String file = keyboard.next();
		ReadFile read = new ReadFile(file);
		int[] numbers_File = read.read_File(file);
		
		main_Second_Stack = stacks.fill_Stacks(numbers_File);
		System.out.println(stacks.nine_counter(main_Second_Stack));
	}

}
