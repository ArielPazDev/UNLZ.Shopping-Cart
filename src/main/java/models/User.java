package models;

public class User {
	private int idUser;
	private boolean active;
	private String username;
	private String password;
	private String name;
	private String rol;
	private double money;

	public User(String username, String password, String name, String rol, double money) {
		super();

		this.active = true;
		this.username = username;
		this.password = password;
		this.name = name;
		this.rol = rol;
		this.money = money;
	}
	
	public User(int idUser, boolean active, String username, String password, String name, String rol, double money) {
		super();

		this.idUser = idUser;
		this.active = active;
		this.username = username;
		this.password = password;
		this.name = name;
		this.rol = rol;
		this.money = money;
	}	

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	public void setUser(User user) {
		this.idUser = user.getIdUser();
		this.active = user.getActive();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.name = user.getName();
		this.rol = user.getRol();
		this.money = user.getMoney();		
	}
}