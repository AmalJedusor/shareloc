package root;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;

@Path("/colocations")
public class ColocationResource {

	ArrayList<Colocation> colocations = new ArrayList<Colocation>();
	 EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );   
     EntityManager entitymanager = emfactory.createEntityManager( );     
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
	public Colocation createColocation(@FormParam("name") String name, @FormParam("userid") int userid) {
		
	    emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );

		Colocation c = new Colocation(name, userid);
		entitymanager.getTransaction().begin();
		entitymanager.persist( c );
	    entitymanager.getTransaction( ).commit( );
	    entitymanager.close( );
	    emfactory.close( );
		colocations.add(c);
		System.out.println("ColocationResource.createColocation()");
		return c;
		
		
	}
	
	
}
