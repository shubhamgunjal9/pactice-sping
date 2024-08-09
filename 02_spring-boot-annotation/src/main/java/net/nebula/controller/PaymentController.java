package net.nebula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import net.nebula.service.CreditPay;
import net.nebula.service.Payment;

@org.springframework.web.bind.annotation.RestController
public class PaymentController {
	
	
	private Payment payment;
	
	public PaymentController(Payment payment) {
		this.payment=payment;
	}
	
	public String payment() {
		return payment.pay();
	}
	
	
}
