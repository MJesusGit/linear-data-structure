package stacks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\naturales.dat.txt");
		Scanner reader = new Scanner(file);
		int counter = 0;

		try {
			// we will read the file
			System.out.println("...Reading the file...");

			// we read number a number
			while (reader.hasNext()) {
				int number = reader.nextInt();
				counter += 1;
				System.out.print(" " + number);

				int[] auxiliar_Number = new int[counter];
				for(int i=0; i<counter; i++) {
					auxiliar_Number[i]=number;
					
				}
			}
			System.out.println("\n"+counter);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}