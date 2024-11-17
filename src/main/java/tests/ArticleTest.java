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

		// ArticleRepo (view)
		articleRepo.view("add articles");


		// ArticleRepo (add)
		articleRepo.add(new Article("LNJMM", "Teclado Mecánico", "Teclado mecánico RGB para gaming", 80f, 30));

		// ArticleRepo (view)
		articleRepo.view("add article / 'Code Article: LNJMM' discarded as existing");


		// ArticleRepo (edit)
		articleRepo.edit(new Article("LNJMM", "Teclado Mecánico", "Teclado mecánico RGB para gaming", 80f, 30));

		// ArticleRepo (view)
		articleRepo.view("edit 'Price: 80' and 'Stock: 30' in 'Code Article: LNJMM'");


		// ArticleRepo (delete)
		articleRepo.delete("LNJMM");

		// ArticleRepo (view)
		articleRepo.view("delete 'Code Article: LNJMM'");
	}
}