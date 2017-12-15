package com.assignment3.miscellaneous;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DatabaseUtil {
	
	private static final String db_name = "assignment3";
	
	public static DatabaseUtil instance;
	
	private static EntityManagerFactory emf;
    private static EntityManager em;  
    private CriteriaBuilder cb;
	
	public DatabaseUtil() {
		emf = Persistence.createEntityManagerFactory(db_name);
        em = emf.createEntityManager();
        cb = em.getCriteriaBuilder();
	}
	
	public static DatabaseUtil getInstance() {
		if(instance ==null ) {
			instance = new DatabaseUtil();
		}
		
		return instance;
	}
	
	public <T> List<T> getAll(Class<T> clazz) {		 
		CriteriaQuery<T> q = cb.createQuery(clazz);
		Root<T> c = q.from(clazz);
		q.select(c);
		TypedQuery<T> query = em.createQuery(q);
		return  query.getResultList();
	}
	
	public <T> T find(Class<T> clazz, Integer id) {
		return em.find(clazz, id);
	}
	
	public <T> T findByField(Class<T> clazz, String field, Object value) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
	    CriteriaQuery<T> criteria = builder.createQuery(clazz);
	    Root<T> from = criteria.from(clazz);
	    criteria.select(from);
	    criteria.where(builder.equal(from.get(field), value));
	    TypedQuery<T> typed = em.createQuery(criteria);
	    try {
	        return typed.getSingleResult();
	    } catch (final NoResultException e) {
	        return null;
	    }
	}
	
	public Object save(Object obj) {
		em.getTransaction().begin();
        em.persist(obj);        
        em.getTransaction().commit();   
        em.detach(obj);
        return obj;
	}
	
	public void update(Object obj) {
		em.getTransaction().begin();
        em.merge(obj);  
        em.getTransaction().commit();
        em.detach(obj);
	}
}
