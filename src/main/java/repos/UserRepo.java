package repos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import models.User;

public class UserRepo {
	private List<User> list;
	private int id;

	public UserRepo() {
		this.list = new ArrayList<User>();
		this.id = 0;
	}

	public boolean add(User user) {
		boolean userExists = list.stream().anyMatch(u -> u.getUsername() == user.getUsername());

		if (userExists)
			return false;

		user.setIdUser(++id);
		user.setActive(true);

		list.add(user);

		return true;
	}

	public void delete(int idUser) {
		list.stream().filter(u -> u.getIdUser() == idUser).forEach(u -> u.setActive(false));
	}

	public void print() {
		System.out.println("List of Users");
		System.out.println("-------------");

		IntStream.range(0, list.size())
				.forEach(i -> System.out.println("(" + i + ") -> " + "ID User: " + list.get(i).getIdUser() + " | "
						+ "Active: " + list.get(i).isActive() + " | " + "Username: " + list.get(i).getUsername() + " | "
						+ "Password: " + list.get(i).getPassword() + " | " + "Rol: " + list.get(i).getRol() + " | "
						+ "Money: " + String.format("%.2f", list.get(i).getMoney())));

		System.out.println("");
	}
}