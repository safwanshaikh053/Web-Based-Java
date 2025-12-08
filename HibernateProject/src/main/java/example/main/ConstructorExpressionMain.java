package example.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import example.bean.ExamNameAndDuration;
import example.entity.Department;
import example.entity.Employee;
import example.utils.HibernateUtils;

public class ConstructorExpressionMain {

	public static void main(String[] args) {
		

		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionObj = factory.openSession()
				){
						String hqlQuery = "select new example.bean.ExamNameAndDuration(ex.name, ex.duration) from Exam ex";
						Query<ExamNameAndDuration> queryRef = sessionObj.createQuery(hqlQuery, ExamNameAndDuration.class);
						List<ExamNameAndDuration> dataList = queryRef.getResultList();
						
						for(ExamNameAndDuration data : dataList) {
							String examName = data.getExamName();
							int examDur = data.getExamDuration();
							System.out.println("Name : " + examName + "," + " Duration : " + examDur);
						}
		   }
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
