package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.SelectionQuery;

import com.connections.Utility;

public class Test {
	public static void main(String[] args) {
	Utility conn = new Utility();
	SessionFactory connection = conn.createConnection();
	Session session = connection.openSession();
		System.out.println("Tables Created");
		
		//extracted(session);
		
		insert(session);
		
	}

	private static void insert(Session session) {
		session.beginTransaction();
		MutationQuery mutationQuery = session.createMutationQuery("insert into AnotherUser(email,fullName,password) values(?1,?2,?3)");
		mutationQuery.setParameter(1, "arjun@fmail.com");
		mutationQuery.setParameter(2, "Arjun");
		mutationQuery.setParameter(3, "Arjun2311");
		mutationQuery.executeUpdate();
		session.getTransaction().commit();
	}
	
	private static void extracted(Session session) {
		SelectionQuery<AnotherUser> users = session.createSelectionQuery("select s from AnotherUser s",AnotherUser.class);
		List<AnotherUser> list = users.list();
		for(AnotherUser t : list) {
	  System.out.println(t);
		}
	}

}
