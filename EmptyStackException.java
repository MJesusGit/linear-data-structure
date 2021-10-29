package stack;

@SuppressWarnings("serial")
public class EmptyStackException extends Exception {
	public EmptyStackException (String message) {
		super("ERROR: the stack is empty");
	}
	
	

}
