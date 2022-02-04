package repository;


import javax.annotation.Resource;
import javax.naming.AuthenticationException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;
import javax.transaction.UserTransaction;

import root.UserC;

public class UserCRepo {

	 @Resource(lookup = "jpadb")
	 private DataSource dataSource;
		@Resource
		UserTransaction ut;
		@PersistenceUnit(unitName = "Eclipselink_JPA")
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA");
		@PersistenceContext(unitName = "Eclipselink_JPA")
	    EntityManager 
		em = emfactory.createEntityManager( );
		
	public UserC validateCredentials(String name, String password) throws AuthenticationException {
		   UserC user = em.createQuery("SELECT u FROM UserC u WHERE u.name LIKE :identifier AND u.password LIKE :password", UserC.class)
	                .setParameter("identifier", name)
	                .setParameter("password", password).getSingleResult();
		   
		   
		   if (user == null) {
	            // User cannot be found with the given username/email
	            throw new AuthenticationException("Bad credentials.");
	        }

		   System.out.println("user exists");

	        return user;
	}

}
