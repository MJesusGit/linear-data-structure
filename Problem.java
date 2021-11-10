import java.util.*;
import java.util.EmptyStackException;
import java.io.*;

public class Problem {
	Stack<Integer> first_Stack = new Stack<Integer>();

	/****************************************************************************
	* Method name: fill_Stacks											 
	*																	 
	* Name of the original author: Andrés González Varela, Maria Jesus   
	* Dueñas Recuero, Juan Gigante Rios.								 
	*																	 
	* Description of the Method: First of all it will check if 
	* the received stack is empty. Then this method will fill the stacks 
	* one by one checking if the addition of the number in the array 
	* and the number on the top of the first stack is 9 or not, 
	* depending on the result we will increase the first or the second 
	* stack. In case the first stack is empty the number of the received stack   
	* will be pushed on this stack. On the end we will return the 
	* second_Stack that we will have to use later.
	*																	 
	* Calling arguments: In this method we introduce a stack which will have 
	* all the numbers from the file in the correct order.  
	* 																     
	* Return value: This method will return a stack with numbers, called
	* second_Stack 
	******************************************************************************/

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

	/************************************************************************
	* Method name: nine_counter										 
	*																	 
	* Name of the original author: Andrés González Varela, Maria Jesus   
	* Dueñas Recuero, Juan Gigante Rios.								 
	*																	 
	* Description of the Method: This method will receive the second 
	* stack and it will start adding numbers until the result of the 
	* add its nine or higher. Each time this happends the problem will 
	* introduce a 9 in a third stack.
	*																	 
	* Calling arguments: This method receives a stack of integers called
	* second_Stack.   
	* 																     
	* Return value: This method will return the size of the stack that 
	* has all the nines stored (third_Stack)
	*********************************************************************/


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

	/***************************************************************************************************************
	 * This method is the constructor of this class																   *
	 ***************************************************************************************************************/
	
	public Problem(Stack<Integer> first_Stack) {
		this.first_Stack = first_Stack;
	}
}