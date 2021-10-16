package stacks;

import java.io.*;
import java.util.*;

public class Stacks {

	public Stack fill_Stacks(readfiles file) throws FileNotFoundException {
		int[] array = file.read_File();
		Stack<Integer> first_Stack = new Stack<Integer>();
		Stack<Integer> second_Stack = new Stack<Integer>();

		for (int i = 0; i < array.length; i++) {
			if (first_Stack.isEmpty()) {
				first_Stack.push(array[i]);
			} else {
				if (first_Stack.peek() + array[i] == 9) {
					for (int j = 0; j < 2; i++) {
						if (first_Stack.peek() <= array[i]) {
							second_Stack.push(first_Stack.pop());
						} else {
							second_Stack.push(array[i]);
							first_Stack.pop();
						}
					}
				} else if (first_Stack.peek() + array[i] != 9) {
					first_Stack.push(array[i]);
				}
			}
		}
		return second_Stack;
	}

	public int nine_counter(Stack<Integer> second_Stack) {
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
}
