package net.nebula.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import net.nebula.service.CashPay;
import net.nebula.service.CreditPay;
import net.nebula.service.Payment;

@Configuration
public class BeanConfig {
	
//	@Bean
//	public Payment getCashPay() {
//		return new CashPay();
//	}
	
	
	@Bean
	public Payment getCreditPay() {
		return new CreditPay();
	}

}
