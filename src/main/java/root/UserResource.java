package root;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/users")
public class UserResource {
	/*
	 Map<String, User> users = new HashMap<>();
	 */
	 @Resource(lookup = "jpadb")
	 private DataSource dataSource;
		@Resource
		UserTransaction ut;
		@PersistenceUnit(unitName = "Eclipselink_JPA")
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA");
		@PersistenceContext(unitName = "Eclipselink_JPA")
	    EntityManager 
		em = emfactory.createEntityManager( );
		
	
		@POST
		@Transactional
		@Consumes("application/x-www-form-urlencoded")
		@Path("create")
	 public String createProfile(@FormParam("email") String email, @FormParam("name") String name, @FormParam("lastname") String lastname, @FormParam("password") String password) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NamingException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
			
			UserC c = new UserC(email,name,lastname,password);
			// lookup the usertransaction
			InitialContext co = new InitialContext();
	       
			UserTransaction ut = (UserTransaction)co.lookup ("java:comp/UserTransaction");
			ut.begin ();
			em.joinTransaction();
			em.clear();
			em.persist(c);
			em.flush();
			ut.commit();
			return  "User created";
			
			
		}
	 
	 private void modifyProfile() {
		 
	 }
	 private void inviteUser() {
		 
	 }
	 
	 private void addService() {
		
	 }
	 private void voteAddService() {
		 
	 }
	 private void deleteService() {
		 
	 }
	 private void voteDeleteService() {
		 
	 }
	 private void declareServiceDone() {
		 
	 }
	 private void serviceDoneValidation() {
		 
	 }
	 
	
}
