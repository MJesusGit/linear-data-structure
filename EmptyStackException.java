public class EmptyStackException extends Exception {
	/****************************************************************************
	 * Method name: EmptyStackException
	 * 
	 * Name of the original author: Andr�s Gonz�lez Varela, Maria Jesus Due�as
	 * Recuero, Juan Gigante Rios.
	 * 
	 * Description of the Method: This is an exception that we have created to
	 * prevent an error when a stack
	 * 
	 * Calling arguments: This method receives a String with a message
	 ****************************************************************************/
	public EmptyStackException(String message) {
		super("ERROR: the stack is empty");
	}
}