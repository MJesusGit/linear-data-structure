import java.io.*;
import java.util.*;

public class ReadFile {

	private String fileName = "";

	Stack<Integer> auxiliar_Stack = new Stack<Integer>();
	Stack<Integer> file_Stack = new Stack<Integer>();
		
		/*************************************************************************************************************
	     * * * Method name: read_File * * Author/s name: Andrés González Varela, María Jesús Dueñas Recuero,         *
	     * Juan Gigante Ríos.                                                                                    	 *
	     *                                                                                                           *
	     * * * Description of the Method: This method will read the file that is located in the root that it is      *
	     * given. First of all the method will count how many numbers there is on the file and then it creates an    *
	     * array of that lengh. After this the method reads number by number, introducing the number in the file     *
	     * in the array. If the file is not found it will be indicated by terminal.                                  *
	     *************************************************************************************************************/

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

	public ReadFile(String fileName) {
		this.fileName = fileName;
	}
}