package tests;

import models.Article;
import repos.ArticleRepo;

public class ArticleTest {
	public static void main(String[] args) {
		// ArticleRepo (instance)
		ArticleRepo articleRepo = ArticleRepo.getInstance();


		// ArticleRepo (add articles)
		articleRepo.add(new Article("1", "A", "B", 1.0f, 1));
		articleRepo.add(new Article("1", "A", "B", 1.0f, 1));
		articleRepo.add(new Article("2", "C", "D", 2.0f, 2));
		articleRepo.add(new Article("3", "D", "E", 3.0f, 3));

		// ArticleRepo (view list)
		articleRepo.viewList();


		// ArticleRepo (edit article)
		articleRepo.edit(new Article("1", "A1", "B1", 1.2f, 3));

		// ArticleRepo (view list)
		articleRepo.viewList();


		// ArticleRepo (delete article)
		articleRepo.delete("2");

		// ArticleRepo (view list)
		articleRepo.viewList();
	}
}