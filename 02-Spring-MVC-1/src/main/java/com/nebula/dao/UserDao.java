package com.nebula.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
	
	@Bean
	public Session getConnection() {
		// TODO Auto-generated method stub
		Configuration configuration =
				new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = configuration.buildSessionFactory();
		Session session=sf.openSession();
		return session;
	}

}
