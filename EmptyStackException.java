package stack;
public class EmptyStackException extends Exception {
	/*************************************************************************************************************
     * * * Method name: read_File * * Author/s name: Andrés González Varela, María Jesús Dueñas Recuero,         *
     * Juan Gigante Ríos.                                                                                    	 *
     *                                                                                                           *
     * * * Description of the Method: This is an exception that we have created to prevent an error when a stack *
     *************************************************************************************************************/
	public EmptyStackException (String message) {
		super("ERROR: the stack is empty");
	}
}