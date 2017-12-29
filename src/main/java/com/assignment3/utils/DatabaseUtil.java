package com.assignment3.utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/*
 * Use a singleton connection for manage database connection
 * DatabaseUtils is used when performing action to database
 */
public class DatabaseUtil {
	
	private static final String db_name = "assignment3";
	
	private static DatabaseUtil instance;
	
	private static EntityManagerFactory emf;
    private static EntityManager em;  
    private CriteriaBuilder cb;
	
	public DatabaseUtil() {
		try {
			emf = Persistence.createEntityManagerFactory(db_name);
			em = emf.createEntityManager();
			cb = em.getCriteriaBuilder();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DatabaseUtil getInstance() {
		if(instance == null) {
			instance = new DatabaseUtil();
		}
		
		return instance;
	}
	
	/*
	 * Get all model. Use generic to re-use the same method for each model
	 * Override this method in model if need specific implementation
	 */
	public <T> List<T> getAll(Class<T> clazz) {		 
		CriteriaQuery<T> q = cb.createQuery(clazz);
		Root<T> c = q.from(clazz);
		q.select(c);
		TypedQuery<T> query = em.createQuery(q);
		return  query.getResultList();
	}
	
	//Find a model by id
	public <T> T find(Class<T> clazz, Object id) {
		return em.find(clazz, id);
	}
	
	//Find a model using a specific field instead of Id. Usefull for unique field, eg username
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
        try {
        		em.persist(obj);
        } catch(Exception e) {
        		e.printStackTrace();
        }
        em.getTransaction().commit();   
        em.detach(obj);
        return obj;
	}
	
	public void remove(Object obj) {
		em.getTransaction().begin();
        em.remove(obj); 
        em.getTransaction().commit();
        em.detach(obj);
	}
	
	public void update(Object obj) {
		em.getTransaction().begin();
        em.merge(obj);  
        em.getTransaction().commit();
        em.detach(obj);
	}
}
