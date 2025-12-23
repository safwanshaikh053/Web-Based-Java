package example.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan
@Configuration
@EnableAspectJAutoProxy        //Enables proxy generation support
public class SpringAopConfig {
	// @Bean declarations if any
}
