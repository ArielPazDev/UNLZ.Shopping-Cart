package repos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import models.Article;

public class ArticleRepo {
	private static ArticleRepo singleton;
	
	private List<Article> list;

	private ArticleRepo() {
		this.list = new ArrayList<Article>();
	}

	public static ArticleRepo getInstance() {
		if (singleton == null )
			singleton = new ArticleRepo();
		
		return singleton;
	}

	public void add(Article article) {
		boolean articleExists = list
				.stream()
				.anyMatch(a -> a.getCodeArticle() == article.getCodeArticle());

		if (articleExists)
			return;

		list.add(article);
	}

	public void edit(Article article) {
		list
		.stream()
		.filter(a -> a.getCodeArticle() == article.getCodeArticle())
		.forEach(a -> a.setArticle(article));
	}

	public void delete(String codeArticle) {
		list
		.removeIf(a -> a.getCodeArticle() == codeArticle);
	}

	public void view(String message) {
		String title = "List of Articles" + " (" + message + ")";
		
		System.out.println(title);
		System.out.println("-".repeat(title.length()));

		IntStream.range(0, list.size())
				.forEach(
						i -> System.out.println(
								"(" + i + ") -> " +
								"Code Article: " + list.get(i).getCodeArticle() + " | " +
								"Name: " + list.get(i).getName() + " | " +
								"Description: " + list.get(i).getDescription() + " | " +
								"Price: " + String.format("%.2f", list.get(i).getPrice()) + " | " +
								"Stock: " + list.get(i).getStock()
						)
				);

		System.out.println("");
	}
}