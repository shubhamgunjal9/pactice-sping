package com.project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("com/project/spring-bean.xml");
		Employee bean = ac.getBean("emp2",Employee.class);
		System.out.println(bean);
		
	}

}
