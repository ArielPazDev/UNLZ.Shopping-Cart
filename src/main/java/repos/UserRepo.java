package repos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import models.User;

public class UserRepo {
	private static UserRepo singleton;
	
	private List<User> list;
	private int id;

	private UserRepo() {
		this.list = new ArrayList<User>();
		this.id = 0;
	}
	
	public static UserRepo getInstance() {
		if (singleton == null )
			singleton = new UserRepo();

		return singleton;
	}

	public void add(User user) {
		boolean userExists = list
				.stream()
				.anyMatch(u -> u.getUsername() == user.getUsername());

		if (userExists)
			return;

		user.setIdUser(++id);

		list.add(user);
	}

	public void delete(int idUser) {
		list.stream().filter(u -> u.getIdUser() == idUser).forEach(u -> u.setActive(false));
	}

	public void viewList() {
		System.out.println("List of Users");
		System.out.println("-------------");

		IntStream.range(0, list.size())
				.forEach(i -> System.out.println("(" + i + ") -> " + "ID User: " + list.get(i).getIdUser() + " | "
						+ "Active: " + list.get(i).isActive() + " | " + "Username: " + list.get(i).getUsername() + " | "
						+ "Password: " + list.get(i).getPassword() + " | " + "Rol: " + list.get(i).getRol() + " | "
						+ "Money: " + String.format("%.2f", list.get(i).getMoney())));

		System.out.println("");
	}

	@Override
	public String toString() {
		return "UserRepo [list=" + list + ", toString()=" + super.toString() + "]";
	}
}