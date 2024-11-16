package models;

public class Article {
	private String codeArticle;
	private String name;
	private String description;
	private double price;
	private int stock;

	public Article(String codeArticle, String name, String description, double price, int stock) {
		super();

		this.codeArticle = codeArticle;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setArticle(Article article) {
		this.codeArticle = article.getCodeArticle();
		this.name = article.getName();
		this.description = article.getDescription();
		this.price = article.getPrice();
		this.stock = article.getStock();
	}
}
