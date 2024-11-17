package tests;

import models.Article;
import repos.ArticleRepo;

public class ArticleTest {
	public static void main(String[] args) {
		// ArticleRepo (instance)
		ArticleRepo articleRepo = ArticleRepo.getInstance();


		// ArticleRepo (add)
		articleRepo.add(new Article("LNJMM", "Teclado Mecánico", "Teclado mecánico RGB para gaming", 70f, 20));
		articleRepo.add(new Article("OTXGM", "Disco SSD", "Disco de estado sólido de 1TB", 90f, 60));
		articleRepo.add(new Article("5TW1L", "Laptop", "Laptop ligera con procesador Intel i7", 800f, 30));

		// ArticleRepo (view list)
		articleRepo.viewList("add articles");


		// ArticleRepo (add)
		articleRepo.add(new Article("LNJMM", "Teclado Mecánico 2", "Teclado mecánico RGB para gaming 2", 80f, 30));

		// ArticleRepo (view list)
		articleRepo.viewList("add article / discarded for duplicate codeArticle LNJMM");


		// ArticleRepo (edit)
		articleRepo.edit(new Article("LNJMM", "Teclado Mecánico X", "Teclado mecánico RGB para gaming X", 80f, 30));

		// ArticleRepo (view list)
		articleRepo.viewList("edit article LNJMM");


		// ArticleRepo (delete)
		articleRepo.delete("LNJMM");

		// ArticleRepo (view list)
		articleRepo.viewList("delete article LNJMM");
	}
}