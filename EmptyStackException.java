public class EmptyStackException extends Exception {
	/*************************************************************************************************************
     * * * Method name: read_File * * Author/s name: Andr�s Gonz�lez Varela, Mar�a Jes�s Due�as Recuero,         *
     * Juan Gigante R�os.                                                                                    	 *
     *                                                                                                           *
     * * * Description of the Method: This is an exception that we have created to prevent an error when a stack *
     *************************************************************************************************************/
	public EmptyStackException (String message) {
		super("ERROR: the stack is empty");
	}
}