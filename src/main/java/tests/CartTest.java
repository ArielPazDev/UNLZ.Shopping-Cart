package tests;

import models.Cart;
import repos.CartRepo;

public class CartTest {

	public static void main(String[] args) {
		// CartRepo (instance)
		CartRepo cartRepo = CartRepo.getInstance();


		// CartRepo (add)
		cartRepo.add(new Cart(1, "LNJMM", 1, 70f));
		cartRepo.add(new Cart(1, "OTXGM", 2, 90f));
		cartRepo.add(new Cart(2, "L5BX5", 3, 300f));
		cartRepo.add(new Cart(2, "NSPVQ", 4, 250f));

		// CartRepo (view)
		cartRepo.view("add articles to users");


		// CartRepo (add)
		cartRepo.add(new Cart(1, "OTXGM", 3, 90f));

		// CartRepo (view)
		cartRepo.view("add 'Quantity: 3' in 'ID User: 1' with 'Code Article: OTXGM'");


		// CartRepo (edit)
		cartRepo.edit(new Cart(1, "LNJMM", 6, 71f));

		// CartRepo (view)
		cartRepo.view("edit 'Quantity: 6' and 'Price: 71' in 'ID User: 1' with 'Code Article: LNJMM'");


		// CartRepo (delete)
		cartRepo.delete(1, "LNJMM");

		// CartRepo (view)
		cartRepo.view("delete 'ID User: 1' with 'Code Article: LNJMM'");


		// CartRepo (empty)
		cartRepo.empty(2);

		// CartRepo (view)
		cartRepo.view("empty 'ID User: 2'");
	}
}