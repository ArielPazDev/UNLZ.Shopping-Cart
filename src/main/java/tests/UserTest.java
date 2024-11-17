package tests;

import models.User;
import repos.UserRepo;

public class UserTest {

	public static void main(String[] args) {
		// UserRepo (instance)
		UserRepo userRepo = UserRepo.getInstance();


		// UserRepo (add)
		userRepo.add(new User("1", "1", "Ana", "Empleado", 0f));
		userRepo.add(new User("2", "2", "Jorge", "Cliente", 1000f));
		userRepo.add(new User("3", "3", "Luciana", "Cliente", 2000f));

		// UserRepo (view)
		userRepo.view("add users");


		// UserRepo (edit)
		userRepo.edit(new User(2, true, "2a", "2b", "Jorge", "Cliente", 1000f));

		// UserRepo (view)
		userRepo.view("edit 'Username: 2a' and 'Password: 2b' in 'ID User: 2'");


		// UserRepo (delete)
		userRepo.delete(2);

		// UserRepo (view)
		userRepo.view("delete 'ID User: 2' by setting 'Active: false'");		
	}
}