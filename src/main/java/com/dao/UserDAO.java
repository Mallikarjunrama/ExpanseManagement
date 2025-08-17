package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.connections.Utility;
import com.model.AnotherUser;
import com.model.Expanses;

public class UserDAO {

	Utility utility = new Utility();

	public AnotherUser checkCreds(String username, String password) {
		SessionFactory connection = Utility.createConnection();
		try (Session session = connection.openSession()) {
			String hql = "from AnotherUser where email = :email";
			Query<AnotherUser> query = session.createQuery(hql, AnotherUser.class);
			query.setParameter("email", username);
			AnotherUser anotheruser = query.uniqueResult();

			if (anotheruser != null && anotheruser.getPassword().equals(password)) {
				return anotheruser;
			}
			return null;
		}
	}
	public void addUser(AnotherUser user) {
		SessionFactory connection = Utility.createConnection();
		Session session = connection.openSession();
		session.beginTransaction();
		AnotherUser user1 = new AnotherUser(user.getFullName(), user.getEmail(), user.getPassword());
		session.persist(user1);
		session.getTransaction().commit();
	}
	public List<Expanses> getAllExpanses(int id) {
		SessionFactory connection = Utility.createConnection();
		Session session = connection.openSession();
		AnotherUser user = session.find(AnotherUser.class, id);
		List<Expanses> expanses = user.getExpanses();
		return expanses;
	}
	public AnotherUser getUsers(Session session) {
		AnotherUser user = session.find(AnotherUser.class, 2);
		List<Expanses> expanses = user.getExpanses();
		return user;
	}
	public AnotherUser getUserById(int id) {
		SessionFactory connection = Utility.createConnection();
		Session session = connection.openSession();
		AnotherUser user = session.find(AnotherUser.class, id);
		return user;
		
	}
}
