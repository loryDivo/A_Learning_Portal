package com.assignment3.miscellaneous;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

// TODO: check if you're going to use JPA or that file
public class HibernateDB {
	
	private static HibernateDB instance;
	
	private SessionFactory sessionFactory; 
	
	public static HibernateDB getInstance() {
		if(instance == null) {
			instance = new HibernateDB();
			instance.setUp();
		}
		
		return instance;
	}
	
	private void setUp() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure("hibernate/hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
