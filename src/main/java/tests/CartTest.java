package tests;

import models.Cart;
import repos.CartRepo;

public class CartTest {

	public static void main(String[] args) {
		// CartRepo (instance)
		CartRepo cartRepo = CartRepo.getInstance();


		// CartRepo (add articles to users)
		cartRepo.add(new Cart(1, "LNJMM", 2, 70f));
		cartRepo.add(new Cart(1, "OTXGM", 3, 90f));
		cartRepo.add(new Cart(2, "L5BX5", 2, 300f));

		// CartRepo (view list)
		cartRepo.viewList("add articles to users");


		// CartRepo (add articles to users)
		cartRepo.add(new Cart(1, "OTXGM", 1, 90f));
		cartRepo.add(new Cart(2, "OTXGM", 1, 90f));

		// CartRepo (view list)
		cartRepo.viewList("add articles to users");


		// CartRepo (edit article)
		cartRepo.edit(new Cart(1, "LNJMM", 5, 71f));

		// CartRepo (view list)
		cartRepo.viewList("edit article LNJMM in user 1, Quantity: 5 and Price: 71");


		// CartRepo (delete article)
		cartRepo.delete(1, "LNJMM");

		// CartRepo (view list)
		cartRepo.viewList("delete article LNJMM in user 1");


		// CartRepo (empty user)
		cartRepo.empty(2);

		// CartRepo (view list)
		cartRepo.viewList("empty user 2");
	}
}