package queues;

public class person {

	String stagename;
	String ticket;
	
	public person(String stagename, String ticket) {
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
