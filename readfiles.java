package queues;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class readfiles {

	private String filename = "C\\:people.txt";

	public Queue<String> readfile(String file) throws FileNotFoundException {

		File f = new File(filename);
		Scanner reader = new Scanner(f);

		Queue<String> filequeue = new LinkedBlockingQueue<String>();

		try {

			System.out.println("Reading the file...");
			while (reader.hasNext()) {
				String data = reader.next();
				filequeue.offer(data);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		reader.close();

		return filequeue;
	}
	
	public readfiles(String filename) {
		this.filename = filename;
	}
}
