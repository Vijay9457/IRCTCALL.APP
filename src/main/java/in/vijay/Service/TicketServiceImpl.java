package in.vijay.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.vijay.Entity.Ticket;
import in.vijay.Repo.TicketRepo;
import in.vijay.Request.Passenger;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepo repo;

	@Override
	public Ticket bookTicket(Passenger passenger) {

		Ticket ticket = new Ticket();
		BeanUtils.copyProperties(passenger, ticket);

		ticket.setPrice(1500.00);
		ticket.setTicketStatus("Confirmed");

		ticket = repo.save(ticket);
		return ticket;

	}

	@Override
	public Ticket getTicket(Integer ticketNum) {

		Optional<Ticket> id = repo.findById(ticketNum);
		if (id.isPresent()) {

			return id.get();
		}  
		return null;

	}

	@Override
	public List<Ticket> getAllTickets() {
		return repo.findAll();

	}

}
