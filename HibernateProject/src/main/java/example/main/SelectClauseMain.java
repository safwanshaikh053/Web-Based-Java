package example.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import example.entity.Department;
import example.entity.Employee;
import example.utils.HibernateUtils;

public class SelectClauseMain {

	public static void main(String[] args) {
		

		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionObj = factory.openSession()
				){
						String hqlQuery = "select ex.name, ex.duration from Exam ex";
						Query<Object[]> queryRef = sessionObj.createQuery(hqlQuery, Object[].class);
						List<Object[]> dataList = queryRef.getResultList();
						
						for(Object[] data : dataList) {
							Object examName = data[0];
							Object examDur = data[1];
							System.out.println("Name" + examName + "Duration" + examDur);
						}
		   }
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
