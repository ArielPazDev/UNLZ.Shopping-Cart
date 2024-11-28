package models;

public class User {
    private int idUser;
    private boolean active;
    private String name;
    private String username;
    private String password;
    private String rol;
    private double money;

    public User(String name, String username, String password, String rol) {
	super();

	this.idUser = 0;
	this.active = true;
	this.name = name;
	this.username = username;
	this.password = password;
	this.rol = rol;
	this.money = 0;
    }

    public User(int idUser, String name, String username, String password) {
	super();

	this.idUser = idUser;
	this.active = true;
	this.name = name;
	this.username = username;
	this.password = password;
	this.rol = "";
	this.money = 0;
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

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
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
	this.name = user.getName();
	this.username = user.getUsername();
	this.password = user.getPassword();
    }
}