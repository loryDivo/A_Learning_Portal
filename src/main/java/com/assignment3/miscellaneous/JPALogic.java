package com.assignment3.miscellaneous;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPALogic {
	
	public static JPALogic instance;
	
	private EntityManagerFactory emf;
    private EntityManager em;   
 
    public JPALogic() {
        emf = Persistence.createEntityManagerFactory("assignment3db");
        em = emf.createEntityManager();
    }
    
    public static JPALogic getInstance() {
    		if(instance == null) {
    			instance = new JPALogic();
    		}
    		
    		return instance;
    }
     
    public void jpaCreate(Object obj) {
        em.getTransaction().begin();
        em.persist(obj);        
        em.getTransaction().commit();   
        em.detach(obj);
    }
    public Query jpaRead(String query) {
        Query q = em.createQuery(query);
        return q;
    }
    public void jpaUpdate(Object obj) {     
        em.getTransaction().begin();
        em.merge(obj);  
        em.getTransaction().commit();
        em.detach(obj);
    }
    public void jpaDelete(Object obj) {
        em.getTransaction().begin();
        Object managed = em.merge(obj);
        em.remove(managed);
        em.getTransaction().commit();
    }
    public void closeLogicaJPA() {
        em.close();
        emf.close();
    }

}
