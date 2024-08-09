package com.paymentapp;

public class DebitPay implements Payment{

	@Override
	public String pay(Double ammount) {
		// TODO Auto-generated method stub
		return "debit payment success"+ammount;
	}

}
