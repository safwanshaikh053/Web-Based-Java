package example.spring.core;

public class UserService implements GreetingService {

	private String name;
	private int age;
	
	
	
	public UserService() {
		super();
	}



	public UserService(String name, int age) {
		super();
		System.out.println("in user(name, age)");
		this.name = name;
		this.age = age;
	}
	
	public UserService( int age, String name) {
		super();
		System.out.println("in user(age, name)");
		this.age = age;
		this.name = name;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String sayGreeting() {
		String greeting = "Hi " + name + ", your age is " + age + "." ;
		return greeting;
	}

}
