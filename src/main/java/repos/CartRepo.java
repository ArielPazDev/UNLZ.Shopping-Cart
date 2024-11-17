package repos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import models.Cart;

public class CartRepo {
	private static CartRepo singleton;
	
	private List<Cart> list;

	private CartRepo() {
		this.list = new ArrayList<Cart>();
	}

	public static CartRepo getInstance() {
		if (singleton == null)
			singleton = new CartRepo();
		
		return singleton;
	}
	
	public void add(Cart cart) {
		Optional<Cart> cartFind = list
				.stream()
				.filter(c -> c.getIdUser() == cart.getIdUser() && c.getCodeArticle() == cart.getCodeArticle())
				.findFirst();

		cartFind.ifPresentOrElse(
				c -> {
					c.setQuantity(c.getQuantity() + cart.getQuantity());
					c.setPrice(cart.getPrice());
					c.setMoneySubTotal(c.getQuantity() * cart.getPrice());
					},
				() -> list.add(cart)
				);
	}

	public void edit(Cart cart) {
		list
		.stream()
		.filter(c -> c.getIdUser() == cart.getIdUser() && c.getCodeArticle() == cart.getCodeArticle())
		.forEach(c -> c.setCart(cart));
	}

	public void delete(int idUser, String codeArticle) {
		list
		.removeIf(c -> c.getIdUser() == idUser && c.getCodeArticle() == codeArticle);
	}

	public void empty(int idUser) {
		list
		.removeIf(c -> c.getIdUser() == idUser);
	}
	
	public void view(String message) {
		String title = "List of Carts" + " (" + message + ")";
		
		System.out.println(title);
		System.out.println("-".repeat(title.length()));

		IntStream.range(0, list.size())
				.forEach(
						i -> System.out.println(
								"(" + i + ") -> " + 
								"ID User: " + list.get(i).getIdUser() + " | " + 
								"Code Article: " + list.get(i).getCodeArticle() + " | " + 
								"Quantity: " + list.get(i).getQuantity() + " | " +
								"Price: " + String.format("%.2f", list.get(i).getPrice()) + " | " +
								"Money SubTotal: " + String.format("%.2f", list.get(i).getMoneySubTotal())
						)
				);

		System.out.println("");
	}
}