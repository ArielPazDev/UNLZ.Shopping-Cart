package models;

public class Cart {
	private int idUser;
	private String codeArticle;
	private int quantity;
	private double price;
	private double subTotal;

	public Cart(int idUser, String codeArticle, int quantity, double price) {
		super();

		this.idUser = idUser;
		this.codeArticle = codeArticle;
		this.quantity = quantity;
		this.price = price;
		this.subTotal = quantity * price;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double moneySubTotal) {
		this.subTotal = moneySubTotal;
	}

	public void setCart(Cart cart) {
		this.idUser = cart.getIdUser();
		this.codeArticle = cart.getCodeArticle();
		this.quantity = cart.getQuantity();
		this.price = cart.getPrice();
		this.subTotal = cart.getQuantity() * cart.getPrice();
	}
}