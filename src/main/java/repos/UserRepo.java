package repos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
	if (singleton == null)
	    singleton = new UserRepo();

	return singleton;
    }

    public List<User> array() {
	return list
		.stream()
		.filter(a -> a.getActive() == true)
		.collect(Collectors.toList());
    }
    
    public void add(User user) {
	boolean exists = list
		.stream()
		.anyMatch(u -> u.getUsername().equals(user.getUsername()));

	if (exists)
	    return;

	user.setIdUser(++id);

	list.add(user);
    }
    
    public User find(int idUser) {
	return list
		.stream()
		.filter(u -> u.getIdUser() == idUser)
		.findFirst()
		.orElse(null);
    }

    public void update(User user) {
	list
	.stream()
	.filter(u -> u.getIdUser() == user.getIdUser())
	.forEach(u -> u.setUser(user));
    }

    public void delete(int idUser) {
	list
	.stream()
	.filter(u -> u.getIdUser() == idUser)
	.forEach(u -> u.setActive(false));
    }
    
    public User signin(String username, String password) {
	return list
		.stream()
		.filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
		.findFirst()
		.orElse(null);
    }

    public void deposit(int idUser, double money) {
	if (money < 0f)
	    return;

	list
	.stream()
	.filter(u -> u.getIdUser() == idUser)
	.forEach(u -> u.setMoney(u.getMoney() + money));	
    }
    
    public void transfer(int idUserSender, int idUserReceptor, double money) {
	if (idUserSender == idUserReceptor)
	    return;

	if (money < 0f)
	    return;

	User userSender = find(idUserSender);

	if (userSender == null)
	    return;

	if (userSender.getMoney() < money)
	    return;

	User userReceptor = find(idUserReceptor);

	if (userReceptor == null)
	    return;

	list
	.stream()
	.filter(u -> u.getIdUser() == idUserSender)
	.forEach(u -> u.setMoney(u.getMoney() - money));
	
	list
	.stream()
	.filter(u -> u.getIdUser() == idUserReceptor)
	.forEach(u -> u.setMoney(u.getMoney() + money));	
    }
    
    public void list(String message) {
	String title = "List of Users" + " (" + message + ")";

	System.out.println(title);
	System.out.println("-".repeat(title.length()));

	IntStream.range(0, list.size())
	.forEach(
		i -> System.out.println(
			"(" + i + ") -> " + 
			"ID User: " + list.get(i).getIdUser() + " | " + 
			"Active: " + list.get(i).getActive() + " | " + 
			"Name: " + list.get(i).getName() + " | " + 
			"Username: " + list.get(i).getUsername() + " | " + 
			"Password: " + list.get(i).getPassword() + " | " + 
			"Rol: " + list.get(i).getRol() + " | " + 
			"Money: " + String.format("%.2f", list.get(i).getMoney())
		)
	);

	System.out.println("");
    }

    @Override
    public String toString() {
	return "UserRepo [list=" + list + "]";
    }
}