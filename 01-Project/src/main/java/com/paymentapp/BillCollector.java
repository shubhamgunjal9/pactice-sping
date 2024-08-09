package com.paymentapp;

public class BillCollector {
	
	private Payment payment;

	public BillCollector(Payment payment) {
		super();
		this.payment = payment;
	}

	public BillCollector() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BillCollector [payment=" + payment + "]";
	}
	
	public void getPaymentMsg(Double ammount) {
		String pay = payment.pay(ammount);
		System.out.println(pay);
	}
}
