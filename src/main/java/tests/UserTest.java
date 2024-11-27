package tests;

import models.User;
import repos.UserRepo;

public class UserTest {

	public static void main(String[] args) {
		// UserRepo (instance)
		UserRepo userRepo = UserRepo.getInstance();


		// UserRepo (add)
		userRepo.add(new User("Ana", "1", "1", "Empleado"));
		userRepo.add(new User("Jorge", "2", "2", "Cliente"));
		userRepo.add(new User("Luciana", "3", "3", "Cliente"));

		// UserRepo (list)
		userRepo.list("add users");


		// UserRepo (edit)
		userRepo.update(new User(2, "Jorge", "2a", "2b"));

		// UserRepo (list)
		userRepo.list("edit 'Username: 2a' and 'Password: 2b' in 'ID User: 2'");


		// UserRepo (delete)
		userRepo.delete(2);

		// UserRepo (list)
		userRepo.list("delete 'Active: false' in 'ID User: 2'");		
	}
}