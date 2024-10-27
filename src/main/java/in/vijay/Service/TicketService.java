package in.vijay.Service;

import java.util.List;

import in.vijay.Entity.Ticket;
import in.vijay.Request.Passenger;

public interface TicketService { 
	
	public Ticket bookTicket(Passenger passenger);
	
	
	public Ticket getTicket(Integer ticketNum);
	
	public List<Ticket> getAllTickets ();

}
