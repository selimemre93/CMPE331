
public class Ticket {
	
	private int TicketID;
	private String Schedule;
	private String Route;
	private String Status;
	private int SeatNumber;
	
	private Customer customer = new Customer();
	
	public Ticket(){
		
	}
	
	public Ticket(Customer customer, int TicketID, String Schedule, String Route, String Status, int SeatNumber){
		this.customer = customer;
		this.TicketID = TicketID;
		this.Schedule = Schedule;
		this.Route = Route;
		this.Status = Status ;
		this.SeatNumber = SeatNumber;
	}

	
	public void ticketSelling()	{
		
	}
	
	public void ticketReservation(){
		
	}
	
	public void ticketCancellation(){
		
	}
	
	
	
	
	
	
	public int getSeatNumber() {
		return SeatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		SeatNumber = seatNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getTicketID() {
		return TicketID;
	}

	public void setTicketID(int ticketID) {
		TicketID = ticketID;
	}

	public String getSchedule() {
		return Schedule;
	}

	public void setSchedule(String schedule) {
		Schedule = schedule;
	}

	public String getRoute() {
		return Route;
	}

	public void setRoute(String route) {
		Route = route;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	
	
	
	
	
	
	
}
