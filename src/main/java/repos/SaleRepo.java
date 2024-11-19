package repos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import models.Sale;

public class SaleRepo {
	private static SaleRepo singleton;

	private List<Sale> list;

	private SaleRepo() {
		this.list = new ArrayList<Sale>();
	}

	public static SaleRepo getInstance() {
		if (singleton == null)
			singleton = new SaleRepo();

		return singleton;
	}
	
	public void add(Sale sale) {
		list.add(sale);
	}
	
	public List<Sale> filterIdSale(int idSale) {
		List<Sale> filter = list
				.stream()
				.filter(t -> t.getIdSale() == idSale)
				.collect(Collectors.toList());

		return filter;	
	}

	public List<Sale> filterIdUser(int idUser) {
		List<Sale> filter = list
				.stream()
				.filter(t -> t.getIdUser() == idUser)
				.collect(Collectors.toList());

		return filter;	
	}
	
	public void view(String message) {
		view(list, message);
	}
	
	public void view(List<Sale> list, String message) {
		String title = "List of Sales" + " (" + message + ")";

		System.out.println(title);
		System.out.println("-".repeat(title.length()));

		IntStream.range(0, list.size())
				.forEach(
						i -> System.out.println(
								"(" + i + ") -> " + 
								"ID Sale: " + list.get(i).getIdSale() + " | " + 
								"ID User: " + list.get(i).getIdUser() + " | " + 
								"Time: " + list.get(i).getTime() + " | " + 
								"Quantity: " + list.get(i).getQuantity() + " | " +
								"Total: " + String.format("%.2f", list.get(i).getTotal())
						)
				);

		System.out.println("");
	}	
}
