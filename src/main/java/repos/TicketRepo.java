package repos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import models.Ticket;

public class TicketRepo {
	private static TicketRepo singleton;

	private List<Ticket> list;

	private TicketRepo() {
		this.list = new ArrayList<Ticket>();
	}

	public static TicketRepo getInstance() {
		if (singleton == null)
			singleton = new TicketRepo();

		return singleton;
	}	

	public void add(Ticket ticket) {
		list.add(ticket);
	}

	public void filterIdTicket(int idTicket) {
		List<Ticket> l = list
				.stream()
				.filter(t -> t.getIdTicket() == idTicket)
				.collect(Collectors.toList());
		
		IntStream.range(0, l.size())
		.forEach(
				i -> System.out.println(
						"(" + i + ") -> " + 
						"ID Ticket: " + l.get(i).getIdTicket() + " | " + 
						"ID User: " + l.get(i).getIdUser() + " | " + 
						"Code Article: " + l.get(i).getCodeArticle() + " | " + 
						"Quantity: " + l.get(i).getQuantity() + " | " +
						"Price: " + String.format("%.2f", l.get(i).getPrice()) + " | " +
						"SubTotal: " + String.format("%.2f", l.get(i).getSubTotal())
				)
		);

System.out.println("");		
		
	}
	
	public void view(String message) {
		String title = "List of Tickets" + " (" + message + ")";

		System.out.println(title);
		System.out.println("-".repeat(title.length()));

		IntStream.range(0, list.size())
				.forEach(
						i -> System.out.println(
								"(" + i + ") -> " + 
								"ID Ticket: " + list.get(i).getIdTicket() + " | " + 
								"ID User: " + list.get(i).getIdUser() + " | " + 
								"Code Article: " + list.get(i).getCodeArticle() + " | " + 
								"Quantity: " + list.get(i).getQuantity() + " | " +
								"Price: " + String.format("%.2f", list.get(i).getPrice()) + " | " +
								"SubTotal: " + String.format("%.2f", list.get(i).getSubTotal())
						)
				);

		System.out.println("");
	}	
}