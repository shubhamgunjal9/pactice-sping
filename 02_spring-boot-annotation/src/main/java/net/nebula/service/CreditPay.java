package net.nebula.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


public class CreditPay implements Payment {
	public CreditPay() {
		System.out.println("hello :: object");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("destoy :: method");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("init :: method");
	}

	@Override
	public String pay() {
		return "credit pay";
	}

}