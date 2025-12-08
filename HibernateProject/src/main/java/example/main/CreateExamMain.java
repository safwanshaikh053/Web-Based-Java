package example.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.entity.Exam;
import example.utils.HibernateUtils;
//import hibernate.transaction.Transaction;

public class CreateExamMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionObj = factory.openSession()
				){
			Exam examObj = new Exam("E02", "Python", "Practical", 90);
			Transaction tx = sessionObj.beginTransaction();
			sessionObj.persist(examObj);
			tx.commit();
			System.out.println("Exam Created Successfully");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

	}

}
