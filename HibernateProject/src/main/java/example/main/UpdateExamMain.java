package example.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.entity.Exam;
import example.utils.HibernateUtils;

public class UpdateExamMain {

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
						Transaction tx = sessionObj.beginTransaction();
						foundExam.setName("Jakarta EE");
						foundExam.setType("Lab");
						
						tx.commit();
						System.out.println("Exam record updated successfully");
						
						
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