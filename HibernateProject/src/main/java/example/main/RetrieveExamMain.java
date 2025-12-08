package example.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import example.entity.Exam;
import example.utils.HibernateUtils;

public class RetrieveExamMain {

	public static void main(String[] args) {
		// This class is used to fetch single exam record based upon its 
		
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionObj = factory.openSession();
				) {
			
			//Class<Exam> examClassType=Exam.class;
			//Object examCode ="E01";
					
			//Exam foundExam = sessionObj.find(examClassType, examCode);
			Exam foundExam = sessionObj.find(Exam.class, "E04");
					
					if(foundExam != null) {
						System.out.println(foundExam);
					}
					else {
						System.out.println("Exam With given id doesnt exist");
					}
							
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		

	}

}