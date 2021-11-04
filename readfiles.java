package queues;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class readfiles {
	
	private String filename = "C\\:people.txt";
	
	public String[] readfile(String file) throws FileNotFoundException {

		File f = new File(filename);
		Scanner reader = new Scanner(f);
		String[] ifile = null;
		Queue<String> filequeue = new LinkedBlockingQueue<String>();
		Queue<String> auxfilequeue = new LinkedBlockingQueue<String>();

		try {

			System.out.println("Reading the file...");
			while (reader.hasNext()) {
				String data = reader.next();
				auxfilequeue.offer(data);
			}
		//	for(int i = 0; i < auxfilequeue.size()) {
		//		filequeue.offer(auxfilequeue.rear())
		//		ifile(i) = auxfilequeue.
		//	}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		reader.close();

		return ifile;
	}
}
