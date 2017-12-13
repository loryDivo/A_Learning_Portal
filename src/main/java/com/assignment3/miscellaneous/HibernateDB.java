package com.assignment3.miscellaneous;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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
	
	public <T> T find(Class<T> clazz, Integer id) {
		try {
			Session session = getSessionFactory().openSession();
			T ret = (T) session.get(clazz, id);
			session.close();
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public <T> T findByField(Class<T> clazz, String field, Object value) {
		try {
			Session session = getSessionFactory().openSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<T> query = builder.createQuery(clazz);
			Root<T> entity = query.from(clazz);
			Predicate p = builder.and(builder.equal(entity.get(field), value));
			query.where(p);
			T ret = null;
			try {
				ret = session.createQuery(query).getSingleResult();
			} catch (NoResultException e) {
				//
			}
			session.close();
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Object save(Object obj) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.persist(obj);
		tx.commit();
		session.close();
		return obj;
	}

}
