package example.jdbc;

public class DataUpdateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoInterface<Student, Integer> daoRef = new StudentDao();
		Student foundStudent = daoRef.getOne(4);
		if(foundStudent != null) {
			foundStudent.setName("Aabhas Tripathi");
		//	foundStudent.setCity("Madhya Pradesh");"
	
			daoRef.update(foundStudent);		
		}
		else {
			System.out.println("Student with the Given ID Does not Exist");
		}
	}

}

