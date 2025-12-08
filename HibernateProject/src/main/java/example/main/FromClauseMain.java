package example.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import example.entity.Exam;
import example.utils.HibernateUtils;

public class FromClauseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//This class loads all the records from Exam_Master table and displays them
		
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionObj = factory.openSession()
				){
					String hqlQuery = "from Exam ex";
					Query<Exam> queryRef = sessionObj.createQuery(hqlQuery, Exam.class);
					List<Exam> examList = queryRef.getResultList();
					for(Exam currentExam : examList) {
						System.out.println(currentExam);
					}
					
		}
		catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}

}