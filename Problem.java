package stack;
import java.util.*;
import java.util.EmptyStackException;
import java.io.*;

public class Problem {
	Stack<Integer> first_Stack = new Stack<Integer>();

	/*************************************************************************************************************
	 * * * Method name: fill_Stacks * * Author/s name: Andrés González Varela, María				
	 * Jesús Dueñas Recuero, * Juan Gigante Ríos. * * * * Description of the Method:
	 * This method will fill the stacks one by one checking if the addition of * the
	 * number in the array and the number on the top of the first stack is 9 or not,
	 * depending on the result * we will increase the first or the second stack. In
	 * case the first stack is empty the number of the array * will be pushed on
	 * this stack. On the end we will return the second_Stack that we will have to
	 * use later * *
	 *************************************************************************************************************/

	public Stack<Integer> fill_Stacks(Stack<Integer> file_Stack) throws FileNotFoundException, EmptyStackException {
		Stack<Integer> second_Stack = new Stack<Integer>();
		int lower_Number = 0;
		int i = 0;

		try {
			while (!file_Stack.isEmpty()) {
				if (i == 0) {
					first_Stack.push(file_Stack.pop());
				}
				if ((first_Stack.peek() + file_Stack.peek() == 9) && first_Stack.peek() < file_Stack.peek()) {
					lower_Number = first_Stack.pop();
					second_Stack.push(lower_Number);
					second_Stack.push(lower_Number);
					file_Stack.pop();
				} else if ((first_Stack.peek() + file_Stack.peek() == 9) && first_Stack.peek() > file_Stack.peek()) {
					lower_Number = file_Stack.pop();
					second_Stack.push(lower_Number);
					second_Stack.push(lower_Number);
					first_Stack.pop();
				} else if (first_Stack.peek() + file_Stack.peek() != 9) {
					first_Stack.push(file_Stack.pop());

				}

				i++;
			}

		} catch (EmptyStackException e) {
			System.out.println("Message: " + e.getMessage());
		}

		return second_Stack;
	}

	/*************************************************************************************************************
     * * * Method name: read_File * * Author/s name: Andrés González Varela, María Jesús Dueñas Recuero,         *
     * Juan Gigante Ríos.                  	                                                                	 *                                                                                           *
     * * * Description of the Method: This method will take the Second Stack and will be making additions		 *
     * of the numbers that are stored in it, popping number by number, when the addition of 2 or more numbers 	 *
     * add up to 9 or more we will store a 9 in a third stack and after finishing we will print the number of 9's*
     * stored.																									 *
     *************************************************************************************************************/


	public int nine_counter(Stack<Integer> second_Stack) {
		Stack<Integer> third_Stack = new Stack<Integer>();
		int addition = 0;
		while (!second_Stack.isEmpty()) {
			addition = addition + second_Stack.pop();
			if (addition >= 9) {
				third_Stack.push(9);
				addition = 0;
			}
		}

		return third_Stack.size();

	}

	public Problem(Stack<Integer> first_Stack) {
		this.first_Stack = first_Stack;
	}
}