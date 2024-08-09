package com.paymentapp;

public class UpiPay implements Payment{
	@Override
	public String pay(Double ammount) {
		// TODO Auto-generated method stub
		return "UPI payment success"+ammount;
	}
}
