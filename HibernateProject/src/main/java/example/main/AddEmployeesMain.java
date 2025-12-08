package example.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.entity.Employee;
import example.utils.HibernateUtils;


//This class adds several employees into Employee_Master table
public class AddEmployeesMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionObj = factory.openSession()
				){
			Employee e1 = new Employee(101, "Naveen", 20000);
			Employee e2 = new Employee(102, "Rakesh", 28000);
			Employee e3 = new Employee(103, "Kirti", 19000);
			Employee e4 = new Employee(104, "Neha", 25000);
			
			Transaction tx = sessionObj.beginTransaction();
			sessionObj.persist(e1);
			sessionObj.persist(e2);
			sessionObj.persist(e3);
			sessionObj.persist(e4);
		tx.commit();
		}
		catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}

	}

}
