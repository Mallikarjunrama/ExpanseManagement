package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.SelectionQuery;

import com.connections.Utility;
import com.model.AnotherUser;
import com.model.Expanses;

public class ExpanseDAO {
	
	Utility utility = new Utility();
	
	public void insertExpanse(Expanses exp, int userId) {
		List<Expanses> expanses = new ArrayList<Expanses>();
		SessionFactory connection = Utility.createConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		UserDAO dao = new UserDAO();
		AnotherUser user = dao.getUserById(userId);
		Expanses expanse = new Expanses(exp.getDescription(),exp.getAmount(),exp.getSpenton(),user);
		expanses.add(expanse);
		user.setExpanses(expanses);
		expanse.setUser(user);
		session.persist(expanse);
		session.getTransaction().commit();
		
	}
	public List<Expanses> getExpanses(int id) {
		SessionFactory connection = Utility.createConnection();
		Session openSession = connection.openSession();
		String hql = "from Expanses where user =:userId";
		SelectionQuery<Expanses> selectionQuery = openSession.createSelectionQuery(hql, Expanses.class);
		selectionQuery.setParameter("userId", id);
		return selectionQuery.getResultList();
	}
	public void deleteExpanse(int expid) {
		List<Expanses> expanses = new ArrayList<Expanses>();
		SessionFactory connection = Utility.createConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		Expanses expanses2 = session.find(Expanses.class, expid);
		session.remove(expanses2);
		session.getTransaction().commit();
		
	}
	public Expanses getExpanse(int id) {
		SessionFactory connection = Utility.createConnection();
		Session session = connection.openSession();
		Expanses expanses = session.find(Expanses.class, id);
		return expanses;
	}

	public void updateExpanse(int expid, String desc, int amount) {
		SessionFactory connection = Utility.createConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		Expanses expanse = session.find(Expanses.class, expid);
		expanse.setDescription(desc);
		expanse.setAmount(amount);
		session.getTransaction().commit();
	}
	
}
