package com.assignment3.modelsDAO;


import java.util.List;

import com.assignment3.miscellaneous.JPALogic;
import com.assignment3.models.User;

public class UserDAO {

	public static User find(int id) {
		
			JPALogic logJPA = new JPALogic();
			
			List<User> user = logJPA.jpaRead("select t from users where username  " + "t").getResultList(); 
			return user.get(0);
			/*Session session = null;
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate/hibernate.cfg.xml").build();

			Metadata metadata = new MetadataSources(standardRegistry).addAnnotatedClass(User.class)
					.addResource("hibernate/Mapping.hbm.xml").getMetadataBuilder()
					.applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build();

			SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
			session = sessionFactory.openSession();
			
			try {
				return (User) session.get(User.class, 1);
			} catch (Exception exception) {
				exception.printStackTrace();
				return null;
			}*/
	}
}
