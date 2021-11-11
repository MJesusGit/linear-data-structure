package queues;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {

	/******************************************************************************
	 * Method name: main
	 * 
	 * Name of the original author: Andrés González Varela, Maria Jesus Dueñas
	 * Recuero, Juan Gigante Rios.
	 * 
	 * Description of the Method: In the main method first of all we ask for the
	 * direction of the file for then fill the queue named generalqueue. Then we
	 * also fill the peoplequeue so we can finally fill the coliseum,roarofthesea
	 * and sirensong queues. After all that we calculate the time they expend to
	 * enter.
	 ******************************************************************************/
	
	public static void main(String[] args) throws FileNotFoundException {

		// We type the file's route to read it up
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Introduce the route of the file you want to read");
		String file = keyboard.nextLine();
		Readfiles readfile = new Readfiles(file);

		// We create a general queue of string information
		Queue<String> generalqueue = readfile.readfile(file);

		// We create a people objects' queue with the info of the previous queue
		Queue<Person> peoplequeue = Problem.peoplequeue(generalqueue);
		
		// With the previous queue, we distribute people in stages' queues
		Queue<Person>[] array=Problem.distributepeople(peoplequeue);
		Queue<Person> coliseumqueue = array[0];
		Queue<Person> roaroftheseaqueue = array[1];
		Queue<Person> sirensongqueue = array[2];
		
		//people who enter
		System.out.println("They have entered " +coliseumqueue.size() + " people in Main Stage 'Coliseum'.");
		int timeColosseum=Problem.calculatetime(coliseumqueue);
		System.out.println("They have last " + timeColosseum + " minutes");
		System.out.println("They have entered " + roaroftheseaqueue.size()+ " people in Secondary Scenario 'Roar of the Sea'.");
		int timeRoar=Problem.calculatetime(roaroftheseaqueue);
		System.out.println("They have last " + timeRoar + " minutes");
		System.out.println("They have entered " + sirensongqueue.size() + " people in Secondary Stage 'Siren Song'.");
		int timeSiren=Problem.calculatetime(sirensongqueue);
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