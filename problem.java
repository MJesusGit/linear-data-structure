package queues;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class problem {

	Queue<String> queue = new LinkedBlockingQueue<String>();

	// to create a general people queue
	public static Queue<person> peoplequeue(Queue<String> file) {

		Queue<person> personqueue = new LinkedBlockingQueue<person>();

		for (int i = 0; i < file.size(); i++) {
			String line=file.poll();
			StringTokenizer st=new StringTokenizer(line,",");
			String stagename=st.nextToken();
			String ticket=st.nextToken();
			person person = new person(stagename, ticket);
			personqueue.offer(person);
		}
		return personqueue;
	}

	// distribution of people in the different queues
	public static Queue<person>[] distributepeople(Queue<person> peoplequeue) {
		Queue<person> [] array=new Queue[3];
		for (int i=0; i<array.length; i++)
			array[i]=new LinkedBlockingQueue<person>();
		//posiciones 0-coliseo 1-roar of the sea 2-siren's song

		final int maxColosseum = 25;
		final int maxRoaroftheSea=20;
		final int maxSirenSong=15;
		
		int counterColosseum=0;
		int counterRoar=0;
		int counterSirenSong=0;

		for (int i = 0; i < peoplequeue.size(); i++) {
			person p=peoplequeue.poll();
			String stagename=p.getstagename();
			String ticket=p.getticket();

			switch (stagename) {
			case "Colosseum":
				if (counterColosseum < maxColosseum) {
					if (stagename.equals("Colosseum")) {
						if (ticket.equals( " Platinum")) {
							array[0].add(p);
							counterColosseum++;
						} 
					}
				}
				break;
			case "Roar of the Sea":
				if (counterRoar < maxRoaroftheSea) {
					if (stagename.equals("Roar of the Sea")) {
						if (ticket.equals( " Platinum") || ticket.equals(" Gold") || ticket.equals(" Silver Sea")) {
							array[1].add(p);
							counterRoar++;
						}
					}
				}
				break;
			case "Siren's Song":
				if (counterSirenSong < maxSirenSong) {
					if (stagename.equals("Siren's Song")) {
						if (ticket.equals(" Platinum") || ticket.equals(" Gold") || ticket.equals(" Silver Siren")) {
							array[2].add(p);
							counterSirenSong++;
						}
					}
				}
				break;
			}
		}
		return array;
	}

	// calculation of queues' time
	public static int calculatetime(Queue<person> peoplequeue) {

		int minutes = 0;

		for (int i = 0; i < peoplequeue.size(); i++) {
			switch (peoplequeue.poll().ticket) {
			case " Platinum":
				minutes = minutes + 2;
				break;
			case " Gold":
				minutes = minutes + 3;
				break;
			case " Silver Sea":
				minutes = minutes + 4;
				break;
			case " Silver Siren":
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
