package com.connections;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.AnotherUser;
import com.Expanses;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import java.io.File;

public class Utility {
	private static SessionFactory sessionFactory = null;

	public static SessionFactory createConnection() {
		ServletContextEvent sce = null;
		if (sessionFactory == null) {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(Expanses.class);
			cfg.addAnnotatedClass(AnotherUser.class);
			sessionFactory = cfg.buildSessionFactory();
			return sessionFactory;
		}
		return sessionFactory;
	}

}
