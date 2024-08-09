package com.nebula.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nebula.dao.UserDao;
import com.nebula.entity.User;

@Service
public class UserService {

	

	private UserDao dao;
	
	@Autowired
	public UserService(UserDao dao) {
		this.dao=dao;
		
	}
	
	public UserService() {}
	
	public void save(User user) {
		
		Session session = dao.getConnection();
		Transaction transaction=session.beginTransaction();
		
		session.save(user);
		
		transaction.commit();
		session.close();
	}
	
	public List<User> getAll() {
		
		Session session = dao.getConnection();
		Transaction transaction=session.beginTransaction();
		
		List<User> resultList = 
				session.createQuery("from User",User.class).getResultList();
		transaction.commit();
		session.close();
		
		return resultList;
	}
	public User getById(Integer id) {
		Session session = dao.getConnection();
		Transaction transaction=session.beginTransaction();
		User user = session.get(User.class, id);
		transaction.commit();
		session.close();
		return user;
	}
	public void deleteById(Integer id) {
		Session session = dao.getConnection();
		Transaction transaction=session.beginTransaction();
		User byId = getById(id);
		session.delete(byId);
		transaction.commit();
		session.close();
	}
	
	public void update(User user) {
		Session session = dao.getConnection();
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(user);
		
		transaction.commit();
		session.close();
		
	}
	
	
	
	
}
