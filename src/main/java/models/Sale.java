package models;

import java.time.LocalDateTime;

public class Sale {
	private int idSale;
	private int idUser;
	private LocalDateTime time;
	private int quantity;
	private double total;

	public Sale(int idSale, int idUser, LocalDateTime time, int quantity, double total) {
		super();

		this.idSale = idSale;
		this.idUser = idUser;
		this.time = time;
		this.quantity = quantity;
		this.total = total;
	}

	public int getIdSale() {
		return idSale;
	}

	public void setIdSale(int idSale) {
		this.idSale = idSale;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}