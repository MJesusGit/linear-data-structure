import java.io.*;
import java.util.*;

public class ReadFile {

	private String fileName = "";

	Stack<Integer> auxiliar_Stack = new Stack<Integer>();
	Stack<Integer> file_Stack = new Stack<Integer>();
		
	/**************************************************************************
	* Method name: read_File											 
	*																	 
	* Name of the original author: Andrés González Varela, Maria Jesus   
	* Dueñas Recuero, Juan Gigante Rios.								 
	*																	 
	* Description of the Method: This method will read the file that is 
	* located in the root that it is given. First of all the method will 
	* check if the file has more numbers to read. After this the method 
	* will fill a first stack and then when it is filled we will introduce
	* all the numbers again in another stack so we have them all in the 
	* correct order.
	* 									 
	* Calling arguments: This method receives a String with the direction
	* of the file
	* 																     
	* Return value: This method will return a stack called number_Stack_File
	****************************************************************************/

	public Stack<Integer> read_File(String fileRoute) throws FileNotFoundException {
		File file = new File(fileRoute);
		Scanner reader_File = null;
		Stack<Integer> aux_number_stack_file = new Stack<Integer>();
		Stack<Integer> number_Stack_File = new Stack<Integer>();

		try {
			reader_File = new Scanner(file);
			while (reader_File.hasNext()) {
				int number_File = reader_File.nextInt();
				aux_number_stack_file.push(number_File);
			}

			while (!aux_number_stack_file.isEmpty()) {

				number_Stack_File.push(aux_number_stack_file.pop());

			}

		} catch (Exception ex) {
			System.out.println("Message: " + ex.getMessage());

		}
		return number_Stack_File;
	}

	/***************************************************************************************************************
	 * This method is the constructor of this class																   *
	 ***************************************************************************************************************/
	
	public ReadFile(String fileName) {
		this.fileName = fileName;
	}
}