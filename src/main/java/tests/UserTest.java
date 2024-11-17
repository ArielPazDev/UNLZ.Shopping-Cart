package tests;

import models.User;
import repos.UserRepo;

public class UserTest {

	public static void main(String[] args) {
		// UserRepo (instance)
		UserRepo userRepo = UserRepo.getInstance();


		// UserRepo (add users)
		userRepo.add(new User("A", "B", "Empleado", 5.25f));
		userRepo.add(new User("C", "B", "Cliente", 100.0f));
		userRepo.add(new User("C", "D", "Cliente", 2.0f));

		// UserRepo (view list)
		userRepo.viewList();
	}
}