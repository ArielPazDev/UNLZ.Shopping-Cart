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
    	System.out.println("App Starting...");
    	
		// UserRepo (add users)
		UserRepo userRepo = UserRepo.getInstance();
		
		userRepo.add(new User("1", "1", "Employee", 0.0f));
		userRepo.add(new User("2", "2", "Client", 1000.0f));

		userRepo.viewList();
		
		// ArticleRepo (add articles)
		ArticleRepo articleRepo = ArticleRepo.getInstance();

		//articleRepo.add(new Article("1", "A", "B", 1.0f, 1));
		
		articleRepo.add(new Article("R0MJW", "Auriculares Bluetooth", "Auriculares inalámbricos con cancelación de ruido", 99.99f, 30));
		articleRepo.add(new Article("VX59I", "Smartwatch", "Reloj inteligente con monitoreo de salud", 149.49f, 10));
		articleRepo.add(new Article("JR65F", "Tablet", "Tablet de 10 pulgadas con pantalla HD", 199.99f, 50));
		articleRepo.add(new Article("Y8CGX", "Cámara de Seguridad", "Cámara Wi-Fi con visión nocturna", 89.99f, 70));
		articleRepo.add(new Article("LNJMM", "Teclado Mecánico", "Teclado mecánico RGB para gaming", 69.99f, 20));
		articleRepo.add(new Article("OTXGM", "Disco SSD", "Disco de estado sólido de 1TB", 89.49f, 60));
		articleRepo.add(new Article("5TW1L", "Laptop", "Laptop ligera con procesador Intel i7", 799.99f, 30));
		articleRepo.add(new Article("L5BX5", "Dron", "Dron con cámara 4K y estabilizador", 299.99f, 10));
		articleRepo.add(new Article("NSPVQ", "Monitor", "Monitor 4K UHD de 27 pulgadas", 249.99f, 30));
		articleRepo.add(new Article("6PWFF", "Cargador Portátil", "Batería externa de 20000mAh", 29.99f, 20));
		
		articleRepo.viewList();
    }

    public void contextDestroyed(ServletContextEvent sce)  {
    	System.out.println("App Shutdown...");
    }
}