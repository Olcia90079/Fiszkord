package pl.ug.edu.fiszkord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import pl.ug.edu.fiszkord.repository.CustomerRepository;
import pl.ug.edu.fiszkord.service.CustomerService;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(JpaApplication.class, args);
		//ctx.getBean(CustomerService.class).test();
	}
}
