package repos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import models.Article;

public class ArticleRepo {
    private static ArticleRepo singleton;

    private List<Article> list;

    private ArticleRepo() {
	this.list = new ArrayList<Article>();
    }

    public static ArticleRepo getInstance() {
	if (singleton == null)
	    singleton = new ArticleRepo();

	return singleton;
    }

    public List<Article> array() {
	return list
		.stream()
		.filter(a -> a.getActive() == true)
		.collect(Collectors.toList());
    }

    public Article find(String idArticle) {
	return list
		.stream()
		.filter(a -> a.getIdArticle().equals(idArticle))
		.findFirst()
		.orElse(null);
    }
    
    public void add(Article article) {
	boolean exists = list
		.stream()
		.anyMatch(a -> a.getIdArticle().equals(article.getIdArticle()));

	if (exists)
	    return;

	list.add(article);
    }

    public void update(Article article) {
	list
	.stream()
	.filter(a -> a.getIdArticle().equals(article.getIdArticle()))
	.forEach(a -> a.setArticle(article));
    }

    public void delete(String idArticle) {
	list
	.stream()
	.filter(a -> a.getIdArticle().equals(idArticle))
	.forEach(a -> a.setActive(false));	
    }

    public void list(String message) {
	String title = "List of Articles" + " (" + message + ")";

	System.out.println(title);
	System.out.println("-".repeat(title.length()));

	IntStream.range(0, list.size())
	.forEach(
		i -> System.out.println(
			"(" + i + ") -> " +
			"ID Article: " + list.get(i).getIdArticle() + " | " + 
			"Active: " + list.get(i).getActive() + " | " + 
			"Name: " + list.get(i).getName() + " | " + 
			"Description: " + list.get(i).getDescription() + " | " + 
			"Price: " + String.format("%.2f", list.get(i).getPrice()) + " | " + 
			"Stock: " + list.get(i).getStock()
		)
	);

	System.out.println("");
    }

    @Override
    public String toString() {
	return "ArticleRepo [list=" + list + "]";
    }
}