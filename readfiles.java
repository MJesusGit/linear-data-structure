package queues;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class readfiles {
	final static Scanner sc = new Scanner(System.in);

	private String filename = "C\\:people.txt";

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

	public readfiles(String filename) {
		this.filename = filename;
	}
}
