package com.paymentapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PaymentApplication {
	
	public static void main(String[] args) {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("com/paymentapp/spring-beans.xml");
		BillCollector bean = context.getBean("billcollect1",BillCollector.class);
		bean.getPaymentMsg(100.00);
	}

}
