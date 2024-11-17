package tests;

import models.Cart;
import repos.CartRepo;

public class CartTest {

	public static void main(String[] args) {
		// CartRepo (instance)
		CartRepo cartRepo = CartRepo.getInstance();


		// CartRepo (add articles to users)
		cartRepo.add(new Cart(1, "LNJMM", 2, 69.99f));
		cartRepo.add(new Cart(1, "OTXGM", 3, 89.49f));
		cartRepo.add(new Cart(2, "L5BX5", 2, 299.99f));

		// CartRepo (view list)
		cartRepo.viewList();


		// CartRepo (add articles to users)
		cartRepo.add(new Cart(1, "OTXGM", 1, 89.49f));
		cartRepo.add(new Cart(2, "OTXGM", 1, 89.49f));

		// CartRepo (view list)
		cartRepo.viewList();


		// CartRepo (empty user)
		cartRepo.empty(1);

		// CartRepo (view list)
		cartRepo.viewList();
	}
}