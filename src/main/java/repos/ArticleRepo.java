package repos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import models.Article;

public class ArticleRepo {
	private static ArticleRepo singleton;
	
	private List<Article> list;

	private ArticleRepo() {
		this.list = new ArrayList<Article>();
	}

	public static ArticleRepo getInstance() {
		if (singleton == null ) {
			singleton = new ArticleRepo();
		}
		
		return singleton;
	}

	public boolean add(Article article) {
		boolean articleExists = list.stream().anyMatch(a -> a.getCodeArticle() == article.getCodeArticle());

		if (articleExists)
			return false;

		list.add(article);

		return true;
	}

	public void edit(Article article) {
		list.stream().filter(a -> a.getCodeArticle() == article.getCodeArticle()).forEach(a -> a.setArticle(article));
	}

	public boolean delete(String code) {
		final boolean[] result = { false };

		Optional<Article> articleFind = list.stream().filter(a -> a.getCodeArticle() == code).findFirst();

		articleFind.ifPresent(a -> {
			list.remove(a);

			result[0] = true;
		});

		return result[0];
	}

	public void print() {
		System.out.println("List of Articles");
		System.out.println("----------------");

		IntStream.range(0, list.size())
				.forEach(i -> System.out.println("(" + i + ") -> " + "Code Article: " + list.get(i).getCodeArticle()
						+ " | " + "Name: " + list.get(i).getName() + " | " + "Description: "
						+ list.get(i).getDescription() + " | " + "Price: "
						+ String.format("%.2f", list.get(i).getPrice()) + " | " + "Stock: " + list.get(i).getStock()));

		System.out.println("");
	}
}