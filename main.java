package queues;

import java.io.FileNotFoundException;
import java.util.*;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		
		//We type the file's route to read it up
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Introduce the route of the file you want to read");
		String file = keyboard.next();
		readfiles readfile = new readfiles(file);
		
		//We create a general queue of string information
		Queue<String> generalqueue = readfile.readfile(file);
		
		//We create a people objects' queue with the info of the previous queue
		Queue<person> peoplequeue = problem.peoplequeue(generalqueue);
		
		//With the previous queue, we distribute people in stages' queues
		Queue<person> coliseumqueue = problem.distributepeople("coliseum E1", peoplequeue);
		Queue<person> roaroftheseaqueue = problem.distributepeople("roar of the sea", peoplequeue);
		Queue<person> sirensongqueue = problem.distributepeople("siren song", peoplequeue);
		
		//We print in the console the result
		System.out.println("They have entered " + problem.counter(coliseumqueue) + " people in Main Stage 'Coliseum'.");

		System.out.println("It tooks " + problem.calculatetime(coliseumqueue) + " minutes.");

		System.out.println("They have entered " + problem.counter(roaroftheseaqueue) + " people in Secondary Scenario 'Roar of the Sea'.");

		System.out.println("It tooks " + problem.calculatetime(roaroftheseaqueue) + " minutes.");

		System.out.println("They have entered " + problem.counter(sirensongqueue) + " people in Secondary Stage 'Siren Song'.");

		System.out.println("It tooks " + problem.calculatetime(sirensongqueue) + " minutes.");
	}

}
