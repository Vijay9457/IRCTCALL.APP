package in.vijay.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vijay.Entity.Ticket;
import in.vijay.Request.Passenger;
import in.vijay.Service.TicketServiceImpl;

@RestController
public class TicketRestController {
    
	@Autowired
	private TicketServiceImpl service;

	@PostMapping(value = "/ticket", consumes = "application/json", produces = "application/json")

	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger) {

		Ticket bookTicket = service.bookTicket(passenger);

		return new ResponseEntity<>(bookTicket, HttpStatus.CREATED);

	}

	@GetMapping(value = "/ticket/{ticketNum}", produces = "application/json")
	public ResponseEntity<Ticket> getTicket(@PathVariable("ticketNum") Integer ticket) {

		Ticket ticket2 = service.getTicket(ticket);
        
		return new ResponseEntity<>(ticket2, HttpStatus.OK);

	}
	@GetMapping(value = "/tickets" , produces = "application/json")
	public ResponseEntity<List<Ticket>>getTickets(){
		
		List<Ticket> allTickets = service.getAllTickets();
		
		return new ResponseEntity<>(allTickets , HttpStatus.OK);
		
		 
		}


}
