package example.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class Musician {
	public void perform() {
		
		System.out.println("Playing Guitar.....");
		// throw new RuntimeException();
	}
}
