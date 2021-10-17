package stacks;

import java.util.*;
import java.io.*;

public class Problem {	
	Stack<Integer> first_Stack = new Stack<Integer>();
	
	
	
	/*************************************************************************************************************
	 * * * Method name: fill_Stacks * * Author/s name: Andrés González Varela, María Jesús Dueñas Recuero, 		 *
	 * Juan Gigante Ríos.																		 *
	 * 																											 *
	 * * * Description of the Method: This method will fill the stacks one by one checking if the addition of 	 *
	 * the number in the array and the number on the top of the first stack is 9 or not, depending on the result *
	 * we will increase the first or the second stack. In case the first stack is empty the number of the array  *
	 * will be pushed on this stack. On the end we will return the second_Stack that we will have to use later   *																		 *
	 *************************************************************************************************************/
	
	public Stack fill_Stacks(int[] numbers_File) throws FileNotFoundException {
		Stack<Integer> second_Stack = new Stack<Integer>();
		int repeated = 0;
		for (int i = 0; i < numbers_File.length; i++) {
			if (first_Stack.isEmpty()) {
				first_Stack.push(numbers_File[i]);
			}else if ((i+1)==numbers_File.length){ 
				break;
			}else if (first_Stack.peek() + numbers_File[i+1] == 9 && first_Stack.peek() < numbers_File[i]) {
					repeated = second_Stack.push(first_Stack.pop());
					second_Stack.push(repeated);

				} else if (first_Stack.peek() > numbers_File[i]) {
					repeated = second_Stack.push(numbers_File[i]);
					second_Stack.push(repeated);
					first_Stack.pop();

				} else if (first_Stack.peek() + numbers_File[i+1] != 9) {
					first_Stack.push(numbers_File[i]);
				} 
			}
		return second_Stack;
		}
	
	public int nine_counter(Stack<Integer>second_Stack) {
		Stack<Integer> third_Stack = new Stack<Integer>();
		int number = 0;
		for (int i = 0; i < second_Stack.size(); i++) {
			number = number + second_Stack.peek();
			if (number >= 9) {
				third_Stack.push(9);
				number = 0;
			}
			second_Stack.pop();
		}
		return third_Stack.size();
	}

	public Problem(Stack<Integer> first_Stack) {
		this.first_Stack = first_Stack;
	}
}

