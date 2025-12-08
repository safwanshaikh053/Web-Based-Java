package example.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import example.entity.Project;

public class CreateProjectMain {

	public static void main(String[] args) {
		
		//Configure Hibernate 
		
		Configuration cfg = new Configuration();
		cfg = cfg.configure();
		
		//Session Factory
		
		SessionFactory factory = null;
		Session sessionObj = null;
		try {
			factory = cfg.buildSessionFactory();
			
			//Obtain Session
			
			sessionObj = factory.openSession();
			
			//Instantiate Entity Class ( Create an Object of Entity Class)
			
			Project myProject = new Project(102, "Hotel Management System", "Python", 25);
			
			//Obtain Transaction and start the same
			
			Transaction tx = sessionObj.beginTransaction();
			
			//Store data into DB
			
			sessionObj.persist(myProject);
			
			//Commit the Transaction to save Changes 
			
			tx.commit();
			
			//Close the Session
			
			sessionObj.close();
			
			//Close the Session Factory
			
			factory.close();
			
			System.out.println("Project Created successfully");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}

}

