package queues;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Problem {

	Queue<String> queue = new LinkedBlockingQueue<String>();

	// to create a general people queue
	public static Queue<Person> peoplequeue(Queue<String> file) {

		Queue<Person> personqueue = new LinkedBlockingQueue<Person>();

		for (int i = 0; i < file.size(); i++) {
			String line=file.poll();
			StringTokenizer st=new StringTokenizer(line,",");
			String stagename=st.nextToken();
			String ticket=st.nextToken();
			Person person = new Person(stagename, ticket);
			personqueue.offer(person);
		}
		return personqueue;
	}

	/**************************************************************************
	* Method name: distributepeople											 
	*																	 
	* Name of the original author: Andrés González Varela, Maria Jesus   
	* Dueñas Recuero, Juan Gigante Rios.								 
	*																	 
	* Description of the Method: This method will fill the different queues
	* and executing the entrance and exit of people in every one of them.  
	* 					 
	* Calling arguments: This method receives a Queu with all the people 
	* from the file 
	* 											     
	* Return value: This method will return an array
	****************************************************************************/
	
	public static Queue<Person>[] distributepeople(Queue<Person> peoplequeue) {
		Queue<Person> [] array=new Queue[3];
		for (int i=0; i<array.length; i++)
			array[i]=new LinkedBlockingQueue<Person>();
		//posiciones 0-coliseo 1-roar of the sea 2-siren's song

		final int maxColosseum = 25;
		final int maxRoaroftheSea=20;
		final int maxSirenSong=15;
		
		int counterColosseum=0;
		int counterRoar=0;
		int counterSirenSong=0;

		for (int i = 0; i < peoplequeue.size(); i++) {
			Person p=peoplequeue.poll();
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

	/**************************************************************************
	* Method name: calculatetime										 
	*																	 
	* Name of the original author: Andrés González Varela, Maria Jesus   
	* Dueñas Recuero, Juan Gigante Rios.								 
	*																	 
	* Description of the Method: This method will calculate the time 
	* that they spend in each queue 
	* 					 
	* Calling arguments: This method receives a Queu with all the people 
	* from the file 
	* 											     
	* Return value: This method will return an int with all the minutes
	****************************************************************************/
	
	public static int calculatetime(Queue<Person> peoplequeue) {

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

	public Problem(Queue<String> queue) {
		this.queue = queue;
	}

}