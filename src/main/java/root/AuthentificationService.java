package root;


import java.io.UnsupportedEncodingException;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import repository.UserCRepo;

@Path("/auth")
public class AuthentificationService {
	
	@POST
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Transactional	
		@Path("authenticate")
	    public String authenticateUser(@FormParam("name") String name, 
	                                     @FormParam("password") String password) {

	        try {

	            UserCRepo repo = new UserCRepo();
	            UserC u =repo.validateCredentials(name, password);
	            System.out.println(u.getLastname());
	            if (u != null) {
	            	 // Issue a token for the user
		            String token = issueToken(name);

		            // Return the token on the response
		            return token;

	            }
	        }
	           
	           	     catch (Exception e) {
	           	        	
	            return e.toString();
	        }
			return null;      
	    }

	
	    private String issueToken(String username) throws IllegalArgumentException, UnsupportedEncodingException  {
	        
	    	
	        Algorithm algorithm = Algorithm.HMAC256("secret");
	        String token = JWT.create()
	            .withIssuer("auth0")
	            .sign(algorithm);

	   	    	return token;
	           
	    	 
	    }
	    
	
}

