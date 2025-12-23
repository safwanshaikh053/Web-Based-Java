package config;

import org.springframework.stereotype.Component;

@Component
public class ManagedComponent {
	public void doManage() {
		System.out.println("Managing the Component");
	}
}
