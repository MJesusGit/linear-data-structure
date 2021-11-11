package queues;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class Readfiles {
	final static Scanner sc = new Scanner(System.in);
	private String filename = "C\\:people.txt";
	
	/**************************************************************************
	* Method name: readfile										 
	*																	 
	* Name of the original author: Andrés González Varela, Maria Jesus   
	* Dueñas Recuero, Juan Gigante Rios.								 
	*																	 
	* Description of the Method: This method will read the file that is 
	* located in the root that it is given. The method will read the file 
	* line by line and add all to the queue.
	* 					 
	* Calling arguments: This method receives a String with the direction
	* of the file
	* 																     
	* Return value: This method will return a queue named filequeue.
	****************************************************************************/
	
	public Queue<String> readfile(String file) {
		Queue<String> filequeue = new LinkedBlockingQueue<String>();
		boolean lecturaCorrecta = false;
		Scanner reader = null;
		do {
			try {
				File f = new File(file);
				reader = new Scanner(f);
				lecturaCorrecta = true;
			} catch (FileNotFoundException e) {
				System.out.print("The file " + file + " does no exist. Try it again: ");
				file = sc.nextLine();
			}
		} while (lecturaCorrecta);

		while (reader.hasNext()) {
			String row = reader.nextLine();
			filequeue.add(row);
		}

		return filequeue;

	}

	/***************************************************************************************************************
	 * This method is the constructor of this class																   *
	 ***************************************************************************************************************/
	
	public Readfiles(String filename) {
		this.filename = filename;
	}
}