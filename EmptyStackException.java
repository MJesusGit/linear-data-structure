public class EmptyStackException extends Exception {
	/****************************************************************************
	 * Method name: EmptyStackException
	 * 
	 * Name of the original author: Andrés González Vareña, Maria Jesus Dueñas
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