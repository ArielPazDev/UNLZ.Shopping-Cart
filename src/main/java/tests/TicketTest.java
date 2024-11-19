package tests;

import models.Ticket;
import repos.TicketRepo;

public class TicketTest {

	public static void main(String[] args) {
		// TicketRepo (instance)
		TicketRepo ticketRepo = TicketRepo.getInstance();


		// TicketRepo (add)
		ticketRepo.add(new Ticket(1, 1, "LNJMM", 1, 70f));
		ticketRepo.add(new Ticket(1, 1, "OTXGM", 2, 90f));
		ticketRepo.add(new Ticket(2, 2, "L5BX5", 3, 300f));
		ticketRepo.add(new Ticket(3, 2, "NSPVQ", 4, 250f));

		// TicketRepo (view)
		ticketRepo.view("add ticket to users");
		
		
		// TicketRepo (filterIdTicket)
		ticketRepo.filterIdTicket(1);
	}
}