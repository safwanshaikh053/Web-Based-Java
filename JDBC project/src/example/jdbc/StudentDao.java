package example.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class StudentDao implements DaoInterface<Student, Integer> {
	@Override
	public Collection<Student> getAll(){
		// This method retrieves all the records from students 
		//table, converts them into java objects of students class
		//and returns all those objects and returns in the 
		//form of Collection.
		
		
		// Declaring an empty collection meant for holding objects of type: Student
		Collection<Student> allStudents = new ArrayList<>();
		
		String sqlQuery = 
				"select student_name, student_city, student_id from students";
		try(
				Connection dbConnection = JdbcUtils.getConnection();
				Statement stmt = dbConnection.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery);
				){
					while(rs.next()) {
						String name = rs.getString(1);  // Name
						String city = rs.getString(2);  // City
						int id = rs.getInt(3);  // id
						
						
					    // Creating an object of Student class based upon ID, Name and City.
						Student studentObj = 
								new Student(id, name, city);
						//Adding the Student object onto Students collection: allStudents
						allStudents.add(studentObj);
				    }
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		return allStudents;
	}

	@Override
	public Student getOne(Integer studentId) {
		// This method accepts an integer value indicating Student ID and 
		// returns the student object matching with that ID.
		// If the id is non-existing it returns null.
		Student foundStudent = null;    // default value of this is set to null if the where condition does not satisfied then it vill return null on line 76.
		String sqlQuery = 
				"select student_name, student_city, student_id from students where student_id = ?";
		try(
				Connection dbConnection = JdbcUtils.getConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
				){
			        // Substituting studentId in place of '?' .
					pstmt.setInt(1, studentId);
					ResultSet rs = pstmt.executeQuery();
					
					while(rs.next()) {
						String name = rs.getString(1);  // Name
						String city = rs.getString(2);  // City
						int id = rs.getInt(3);  // id
						foundStudent = new Student(id, name, city);
					}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return foundStudent;
	}

	@Override
	public void create(Student studentObj) {
		// This Method accepts a student object and stores it as a record into 
		//students table 
		
		String sqlQuery = "Insert into students values (?,?,?)";
		try(
				Connection dbConnection = JdbcUtils.getConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
				){
					//Fetching the values from the Student Object
				    int id =  studentObj.getStudentId();
				    String name =  studentObj.getName();
				    String city = studentObj.getCity();
				    
				    //Substituting these values in place of '?'
				    pstmt.setInt(1,  id);
				    pstmt.setString(3, city);
				    pstmt.setString(2, name);
				    
				    int count = pstmt.executeUpdate();
				    
				    System.out.println(count + "Record Inserted." );
				    
				}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void update(Student modifiedStudentObj) {
		// This method receives modified state of the student object and reflects 
		// that state back to DB to complete the update operation
		
		String sqlQuery = 
				"update students set student_name = ?, student_city = ? where student_id = ?";
		
		try(
				Connection dbConnection = JdbcUtils.getConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
				){
					//Fetching the values from the Student Object
				    int id =  modifiedStudentObj.getStudentId();
				    String name =  modifiedStudentObj.getName();
				    String city = modifiedStudentObj.getCity();
				    
				    //Substituting these values in place of '?'
				    pstmt.setInt(3,  id);
				    pstmt.setString(2, city);
				    pstmt.setString(1, name);
				    
				    int count = pstmt.executeUpdate();
				    System.out.println(count + "Record Updated");
				 } 
		catch (Exception e) {
			e.printStackTrace();
		}
				    
	}

	@Override
	public void deleteOne(Integer studentId) {
		
		// This method accepts ID of the students and deleted the relevant records.
		
		String sqlQuery = 
				"Delete from students where student_id = ?";
		
		try(
				Connection dbConnection = JdbcUtils.getConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
				){
					pstmt.setInt(1, studentId);
					int count = pstmt.executeUpdate();
					if(count != 0) {
						System.out.println(count + "record deleted");
					}
					else {
						System.out.println("Student With given ID does not Exist");
					}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

