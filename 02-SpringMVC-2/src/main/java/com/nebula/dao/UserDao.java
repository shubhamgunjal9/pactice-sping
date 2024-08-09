package com.nebula.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

	public Session getConnection() {
		Configuration configuration = 
				new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		
		return factory.openSession();
		
		//return openSession;
	}
}
