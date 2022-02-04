package root;


import java.util.ArrayList;
import java.util.List;

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
import javax.ws.rs.*;

import io.swagger.annotations.Api;

@Path("/colocations")
@Api(value = "/colocations", consumes="application/json")
public class ColocationResource {

	ArrayList<Colocation> colocations = new ArrayList<Colocation>();
	 @Resource(lookup = "jpadb")
	 private DataSource dataSource;
		@Resource
		UserTransaction ut;
		@PersistenceUnit(unitName = "Eclipselink_JPA")
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA");
		@PersistenceContext(unitName = "Eclipselink_JPA")
	    EntityManager 
		em = emfactory.createEntityManager( );
		
		

  
	@GET
	@Path("users/{id}")
	public ArrayList<UserC> getColocationUsers(@PathParam("id") int id) {
		for (Colocation c : colocations) {
		
			if ( c.getId() == id) {
				System.out.println("match");
				return null;
			}
		}
		return null;
	}
	@GET
	@Path("{id}")
	
	public Colocation getColocationInfo(@PathParam("id") long id) {
		
		return em.createQuery(
			    "SELECT c FROM Colocation c WHERE c.id = :id", Colocation.class).setParameter("id", id).getSingleResult();
	}
	
	@GET
	@Path("all")
	public List<Colocation> getColocations() {
		
		return em.createQuery(
			    "SELECT c FROM Colocation c", Colocation.class)
			    .getResultList();
			
	}
	
	

	
	@POST
	@Transactional
	@Consumes("application/x-www-form-urlencoded")
	@Path("createfromform")

	public String createColocation(@FormParam("name") String name, @FormParam("userid") long userid) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NamingException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
	
		Colocation c = new Colocation(name,userid);



		// lookup the usertransaction
		InitialContext co = new InitialContext();
       
		UserTransaction ut = (UserTransaction)co.lookup ("java:comp/UserTransaction");
		ut.begin ();
		em.joinTransaction();
		em.clear();
		em.persist(c);
		em.flush();
		ut.commit();
		return  "done";
		
		
	}
	
	
}
