package example.jdbc;

import java.util.Collection;

public class DataRetrievalMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoInterface<Student, Integer> daoRef = 
				new StudentDao();
		daoRef.getAll();
		Collection<Student> allStudents = daoRef.getAll();
		
		//for(Student st : allStudents) {
			//System.out.println(st);
    //	}
		allStudents.stream().forEach(student -> System.out.println(student));
		
		System.out.println("==============================================");
		
		Student std = daoRef.getOne(4);          //Pass Student Id Here
		if(std != null) {
			System.out.println(std);
		}
		else {
			System.out.println("Student Does not Exist with the given Student_Id");
		}
	}

}

