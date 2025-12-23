package example.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class Singer {
	public void perform() {
		System.out.println("Singing a Song.....");
	}
}
