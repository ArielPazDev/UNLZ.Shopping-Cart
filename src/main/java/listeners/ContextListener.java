package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import models.Article;
import models.User;
import repos.ArticleRepo;
import repos.UserRepo;

@WebListener
public class ContextListener implements ServletContextListener {

    public ContextListener() {
    }
    
    public void contextInitialized(ServletContextEvent sce)  {
    	// Starting
    	System.out.println("App Starting...");

    	
    	// UserRepo (instance)
		UserRepo userRepo = UserRepo.getInstance();
		
		// UserRepo (add users)
		userRepo.add(new User("1", "1", "Employee", 0.0f));
		userRepo.add(new User("2", "2", "Client", 1000.0f));

		// UserRepo (view list)
		userRepo.viewList();

		
		// ArticleRepo (instance)
		ArticleRepo articleRepo = ArticleRepo.getInstance();

		// ArticleRepo (add articles)
		articleRepo.add(new Article("R0MJW", "Auriculares Bluetooth", "Auriculares inalámbricos con cancelación de ruido", 100f, 30));
		articleRepo.add(new Article("VX59I", "Smartwatch", "Reloj inteligente con monitoreo de salud", 150f, 10));
		articleRepo.add(new Article("JR65F", "Tablet", "Tablet de 10 pulgadas con pantalla HD", 200f, 50));
		articleRepo.add(new Article("Y8CGX", "Cámara de Seguridad", "Cámara Wi-Fi con visión nocturna", 90f, 70));
		articleRepo.add(new Article("LNJMM", "Teclado Mecánico", "Teclado mecánico RGB para gaming", 70f, 20));
		articleRepo.add(new Article("OTXGM", "Disco SSD", "Disco de estado sólido de 1TB", 90f, 60));
		articleRepo.add(new Article("5TW1L", "Laptop", "Laptop ligera con procesador Intel i7", 800f, 30));
		articleRepo.add(new Article("L5BX5", "Dron", "Dron con cámara 4K y estabilizador", 300f, 10));
		articleRepo.add(new Article("NSPVQ", "Monitor", "Monitor 4K UHD de 27 pulgadas", 250f, 30));
		articleRepo.add(new Article("6PWFF", "Cargador Portátil", "Batería externa de 20000mAh", 30f, 20));
		
		// ArticleRepo (view list)
		articleRepo.viewList("add articles");
    }

    public void contextDestroyed(ServletContextEvent sce)  {
    	// Shutdown
    	System.out.println("App Shutdown...");
    }
}