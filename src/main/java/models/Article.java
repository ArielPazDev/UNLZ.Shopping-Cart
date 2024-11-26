package models;

public class Article {
    private String idArticle;
    private String name;
    private String description;
    private double price;
    private int stock;

    public Article(String idArticle, String name, String description, double price, int stock) {
	super();

	this.idArticle = idArticle;
	this.name = name;
	this.description = description;
	this.price = price;
	this.stock = stock;
    }

    public String getIdArticle() {
	return idArticle;
    }

    public void setIdArticle(String idArticle) {
	this.idArticle = idArticle;
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
	this.idArticle = article.getIdArticle();
	this.name = article.getName();
	this.description = article.getDescription();
	this.price = article.getPrice();
	this.stock = article.getStock();
    }
}