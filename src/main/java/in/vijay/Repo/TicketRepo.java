package in.vijay.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vijay.Entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {

}
