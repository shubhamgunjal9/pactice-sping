package com.paymentapp;

public class CreditPay implements Payment{

	@Override
	public String pay(Double ammount) {
		
		return "credit card payment success"+ammount;
	}

	
}
