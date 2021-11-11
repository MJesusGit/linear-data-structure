package queues;

import java.io.FileNotFoundException;
import java.util.*;

public class main {

	public static void main(String[] args) throws FileNotFoundException {

		// We type the file's route to read it up
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Introduce the route of the file you want to read");
		String file = keyboard.nextLine();
		readfiles readfile = new readfiles(file);

		// We create a general queue of string information
		Queue<String> generalqueue = readfile.readfile(file);

		// We create a people objects' queue with the info of the previous queue
		Queue<person> peoplequeue = problem.peoplequeue(generalqueue);
		
		// With the previous queue, we distribute people in stages' queues
		Queue<person>[] array=problem.distributepeople(peoplequeue);
		Queue<person> coliseumqueue = array[0];
		Queue<person> roaroftheseaqueue = array[1];
		Queue<person> sirensongqueue = array[2];
		
		//people who enter
		System.out.println("They have entered " +coliseumqueue.size() + " people in Main Stage 'Coliseum'.");
		int timeColosseum=problem.calculatetime(coliseumqueue);
		System.out.println("They have last " + timeColosseum + " minutes");
		System.out.println("They have entered " + roaroftheseaqueue.size()+ " people in Secondary Scenario 'Roar of the Sea'.");
		int timeRoar=problem.calculatetime(roaroftheseaqueue);
		System.out.println("They have last " + timeRoar + " minutes");
		System.out.println("They have entered " + sirensongqueue.size() + " people in Secondary Stage 'Siren Song'.");
		int timeSiren=problem.calculatetime(sirensongqueue);
		System.out.println("They have last " + timeSiren + " minutes");

		// We calculate the total time all people have last to access all the stages
		int maxtime = timeColosseum;
		if (maxtime < timeRoar) {
			maxtime = timeRoar;
		}
		if (maxtime < timeSiren) {
			maxtime = timeSiren;
		}

		System.out.println("The total time they have last to entered is " + maxtime + " minutes.");
	}

}
