package queues;

public class Person {

	String stagename;
	String ticket;
	
	public Person(String stagename, String ticket) {
		this.stagename = stagename;
		this.ticket = ticket;
	}
	
	public void setstagename(String stagename) {
		this.stagename = stagename;
	}
	
	public void setticket(String ticket) {
		this.ticket = ticket;
	}
	
	public String getstagename() {
		return stagename;
	}
	
	public String getticket() {
		return ticket;
	}
	
	
}