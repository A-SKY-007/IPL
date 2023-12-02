package IPL.Helper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //here by using this annotation we will do the configuration of a project.
//@ComponentScan("IPL.Controller") //here we can add base packages using this annotation.
//@ComponentScan("IPL.Dao")
//@ComponentScan("IPL.Dto")
//@ComponentScan("IPL.Helper")
@ComponentScan("IPL")
public class Myconfig 
{
	@Bean //It will help to create reference variable of interface type
	public EntityManagerFactory getEntityManagerFactory() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("developer");
		
		return entityManagerFactory;
	}
}
