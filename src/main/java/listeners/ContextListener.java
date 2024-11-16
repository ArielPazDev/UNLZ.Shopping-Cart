package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import models.User;
import repos.UserRepo;

@WebListener
public class ContextListener implements ServletContextListener {

    public ContextListener() {
    }
    
    public void contextInitialized(ServletContextEvent sce)  {
    	System.out.println("App Starting...");
    	
		// User (repo)
		UserRepo userRepo = UserRepo.getInstance();
		
		userRepo.add(new User("1", "1", "Employee", 0.0f));
		userRepo.add(new User("2", "2", "Employee", 0.0f));

		userRepo.viewList();    	
    }

    public void contextDestroyed(ServletContextEvent sce)  {
    	System.out.println("App Shutdown...");
    }
}