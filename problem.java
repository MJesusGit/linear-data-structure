package queues;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class problem {

	Queue<String> queue = new LinkedBlockingQueue<String>();

	// to create a general people queue
	public static Queue<person> peoplequeue(Queue<String> file) {

		Queue<person> personqueue = new LinkedBlockingQueue<person>();

		for (int i = 0; i < file.size(); i++) {
			person person = new person(file.poll(), file.poll());
			personqueue.offer(person);
		}
		return personqueue;
	}

	// distribution of people in the different queues
	public static Queue<person> distributepeople(String queue, Queue<person> peoplequeue) {

		Queue<person> finalqueue = new LinkedBlockingQueue<person>();

		int max = 0;
		switch (queue) {
		case "coliseum E1":
			max = 25;
			break;
		case "roar of the sea":
			max = 20;
			break;
		case "siren song":
			max = 15;
			break;
		}

		for (int i = 0; i < peoplequeue.size(); i++) {

			switch (queue) {
			case "coliseum E1":
				if (i < max) {
					if (peoplequeue.element().stagename == "coliseum E1") {
						finalqueue.offer(peoplequeue.poll());
					} else {
						peoplequeue.remove();
					}
				}else {
					peoplequeue.remove();
				}
				break;
			case "roar of the sea":
				if (i < max) {
					if (peoplequeue.element().stagename == "roar of the sea") {
						finalqueue.offer(peoplequeue.poll());
					} else {
						peoplequeue.remove();
					}
				}else {
					peoplequeue.remove();
				}
				break;
			case "siren song":
				if (i < max) {
					if (peoplequeue.element().stagename == "siren song") {
						finalqueue.offer(peoplequeue.poll());
					} else {
						peoplequeue.remove();
					}
				}else {
					peoplequeue.remove();
				}
				break;
			}
		}
		return finalqueue;
	}

	// counter of people that entered to each stage
	public static int counter(Queue<person> peoplequeue) {
		int counter = 0;
		for (int i = 0; i < peoplequeue.size(); i++) {
			peoplequeue.remove();
			counter = counter + 1;
		}
		return counter;
	}

	// calculation of queues' time
	public static int calculatetime(Queue<person> peoplequeue) {

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