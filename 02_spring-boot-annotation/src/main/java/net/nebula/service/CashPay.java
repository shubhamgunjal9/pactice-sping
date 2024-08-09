package net.nebula.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class CashPay implements Payment {
	@Override
	public String pay() {
		return "cash payment success";
	}

}
