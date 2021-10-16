package stacks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

	private String fileName = "";

	/*************************************************************************************************************
	 * * * Method name: read_File * * Author/s name: Andrés González Varela, María Jesús Dueñas Recuero, 		 *
	 * Juan Gigante Ríos.																					 *
	 * 																											 *
	 * * * Description of the Method: This method will read the file that is located in the root that it is 	 *
	 * given. First of all the method will count how many numbers there is on the file and then it creates an 	 *
	 * array of that lenght. After this the method reads number by number, introducing the number in the file 	 *
	 * in the array. If the file is not found it will be indicated by terminal. 								 *
	 *************************************************************************************************************/
	
	public int[] read_File(String fileRoute) throws FileNotFoundException {
		File file = new File(fileRoute);
		Scanner reader = new Scanner(file);
		int counter = 0;
		int[] auxiliar_Number = null;
		try {
			System.out.println("...Reading the file...");
			while (reader.hasNext()) {
				int number = reader.nextInt();
				counter += 1;
				System.out.print(" " + number);

				auxiliar_Number = new int[counter];
				for (int i = 0; i < counter; i++) {
					auxiliar_Number[i] = number;

				}
			}
			System.out.println("\n" + counter);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return auxiliar_Number;
	}

	/***************************************************************************************************************
	 * This method is the constructor of this class																   *
	 ***************************************************************************************************************/

	public ReadFile(String fileName) {
		this.fileName = fileName;
	}
}