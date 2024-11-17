package tests;

import models.Cart;
import repos.CartRepo;

public class CartTest {

	public static void main(String[] args) {
		// CartRepo (instance)
		CartRepo cartRepo = CartRepo.getInstance();


		// CartRepo (add articles to user)
		cartRepo.add(new Cart(2, "LNJMM", 2, 69.99f));
		cartRepo.add(new Cart(2, "OTXGM", 3, 89.49f));

		// CartRepo (view list)
		cartRepo.viewList();


		// CartRepo (add article to user)
		cartRepo.add(new Cart(2, "OTXGM", 1, 89.49f));

		// CartRepo (view list)
		cartRepo.viewList();
	}
}