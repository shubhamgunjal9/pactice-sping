package com.paymentapp;

public class CashPay implements Payment{
	@Override
	public String pay(Double ammount) {
		// TODO Auto-generated method stub
		return "cash payment success"+ammount;
	}
}
