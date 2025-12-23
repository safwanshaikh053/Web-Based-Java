package config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PureAnnotationExampleMain {

	public static void main(String[] args) {
		
		ApplicationContext  context = new AnnotationConfigApplicationContext(SpringAppConfig.class);
		
//		ManagedComponent managedComp = context.getBean(ManagedComponent.class);
//		 managedComp.doManage();
	}

}