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
		UserRepo userRepo = new UserRepo();
		
		userRepo.add(new User("1", "1", "Employee", 0.0f));    	
    }

    public void contextDestroyed(ServletContextEvent sce)  {
    	System.out.println("App Shutdown...");
    }
}