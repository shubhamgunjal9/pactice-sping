package net.nebula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import net.nebula.config.BeanConfig;
import net.nebula.controller.PaymentController;
import net.nebula.service.Payment;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = 
				SpringApplication.run(Application.class, args);
		PaymentController bean = applicationContext.getBean(PaymentController.class);
		System.out.println(bean.payment());

	}

}