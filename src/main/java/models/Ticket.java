package models;

public class Ticket {
	private int idTicket;
	private int idUser;
	private String codeArticle;
	private int quantity;
	private double price;
	private double subTotal;

	public Ticket(int idTicket, int idUser, String codeArticle, int quantity, double price, double subTotal) {
		super();

		this.idTicket = idTicket;
		this.idUser = idUser;
		this.codeArticle = codeArticle;
		this.quantity = quantity;
		this.price = price;
		this.subTotal = subTotal;
	}

	public int getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
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

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
}