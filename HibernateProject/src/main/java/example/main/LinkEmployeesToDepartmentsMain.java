package example.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.entity.Department;
import example.entity.Employee;
import example.utils.HibernateUtils;

public class LinkEmployeesToDepartmentsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// This Class Loads All the Employees, Department And links them...
		
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionObj = factory.openSession()
				){
						// Loading All the Employees
			
					Employee emp1 = sessionObj.find(Employee.class,101);
					Employee emp2 = sessionObj.find(Employee.class,102);
					Employee emp3 = sessionObj.find(Employee.class,103);
					Employee emp4 = sessionObj.find(Employee.class,104);
					
					// Loading allt the departments to which employees are to be linked
					
					Department dept1 = sessionObj.find(Department.class,11);
					Department dept2 = sessionObj.find(Department.class,12);
					
					Transaction tx = sessionObj.beginTransaction();
					
					//Populating a list of Employees : emp1, emp2
					List<Employee> empList = List.of(emp1,emp2);
					//Adding these employees in the form of list to 1st department
					dept1.setEmployeeList(empList);
					//Adding these employees in the form of list to 2nd department
					dept2.addEmployee(emp3);
					dept2.addEmployee(emp4);
					
					tx.commit();
					System.out.println("Employees are Linked to departments successfully");
				}
		catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}

}
