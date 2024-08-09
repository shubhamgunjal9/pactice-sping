package com.nebula.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nebula.dao.UserDao;
import com.nebula.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
	
	
	public void registerUser(User user) {
		Session connection = dao.getConnection();
		Transaction beginTransaction = connection.beginTransaction();
		connection.save(user);
		beginTransaction.commit();
		connection.close();
	}

}
