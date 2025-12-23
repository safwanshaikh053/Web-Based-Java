package example.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration     //Marks this class as a configuration Unit.
public class SpringConfig {
	//This class is meant for declaring beans or configuring beans.
	
	// Defining a bean of type GreetingService
	@Bean
	public GreetingService doWelcome() {
		GreetingService ws = new WelcomeService();
		return ws;
	}
	
	@Bean("helloBean") //Overriding the default ID and making it as helloBean.
	public GreetingService doHello() {
		GreetingService ws = new HelloService();
		return ws;
	}
	
}