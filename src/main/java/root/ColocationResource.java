package root;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.ws.rs.*;

@Path("/colocations")
public class ColocationResource {

	ArrayList<Colocation> colocations = new ArrayList<Colocation>();
	
	@PersistenceContext
	UserTransaction ut;
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
	@PersistenceContext
    EntityManager em = emfactory.createEntityManager( );     
	@GET
	@Path("users/{id}")
	public ArrayList<User> getColocationUsers(@PathParam("id") int id) {
		for (Colocation c : colocations) {
		
			if ( c.getId() == id) {
				System.out.println("match");
				return c.getUsers();
			}
		}
		return null;
	}
	@GET
	@Path("{id}")
	
	public Colocation getColocationInfo(@PathParam("id") int id) {
		
		for (Colocation c : colocations) {
		
			if ( c.getId() == id) {
				return c;
			}
		}
		return null;
	}
	@GET
	@Path("all")
	public ArrayList<Colocation> getColocations() {
		
		return colocations;
	}
	
	
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Path("createfromform")
	
	public String createColocation(@FormParam("name") String name, @FormParam("userid") int userid) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		

		Colocation c = new Colocation("hey", 123);
		
		try {
			em.persist( new Colocation("hey",11) );
			//em.flush();
			em.close();
			
		}
		catch (Exception e ) {
			return e.toString();
		}
		
		System.out.println("ColocationResource.createColocation()");

		return  c.getName();
		
		
	}
	
	
}
