package queues;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class problem {

	Queue<String> queue = new LinkedBlockingQueue<String>();

	// to create a general people queue
	public Queue<person> peoplequeue(Queue<String> file) {

		Queue<person> personqueue = new LinkedBlockingQueue<person>();

		for (int i = 0; i < file.size(); i++) {
			person person = new person(file.poll(), file.poll());
			personqueue.offer(person);
		}
		return personqueue;
	}

	// distribution of people in the different queues
	public Queue<person> distributepeople(String queue, Queue<person> peoplequeue) {

		Queue<person> finalqueue = new LinkedBlockingQueue<person>();

		for (int i = 0; i < peoplequeue.size(); i++) {

			switch (queue) {
			case "coliseum E1":
				if (peoplequeue.element().stagename == "coliseum E1") {
					finalqueue.offer(peoplequeue.poll());
				}
				break;
			case "roar of the sea":
				if (peoplequeue.element().stagename == "roar of the sea") {
					finalqueue.offer(peoplequeue.poll());
				}
				break;
			case "siren song":
				if (peoplequeue.element().stagename == "siren song") {
					finalqueue.offer(peoplequeue.poll());
				}
				break;
			}
		}
		return finalqueue;
	}

	//calculation of queues' time
	public int calculatetime(Queue<person> peoplequeue) {
		
		int minutes = 0;
		
		for (int i = 0; i < peoplequeue.size(); i++) {
			switch (peoplequeue.poll().ticket) {
			case "Platinum":
				minutes = minutes + 2;
				break;
			case "Gold":
				minutes = minutes + 3;
				break;
			case "Silversea":
				minutes = minutes + 4;
				break;
			case "Silversiren":
				minutes = minutes + 4;
				break;
			}
		}
		return minutes;
	}

	public problem(Queue<String> queue) {
		this.queue = queue;
	}

}
