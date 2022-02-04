package root;


import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import repository.UserCRepo;

@Path("/auth")
public class AuthentificationService {
	  @POST
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 
		@Transactional
		
		@Path("authenticate")
	    public Response authenticateUser(@FormParam("name") String name, 
	                                     @FormParam("password") String password) {

	        try {

	            UserCRepo repo = new UserCRepo();
	            UserC u =repo.validateCredentials(name, password);
	            if (u != null) {
	            	 // Issue a token for the user
		            String token = issueToken(name);

		            // Return the token on the response
		            return Response.ok(token).build();


	            }
	            return null;
	           	        } catch (Exception e) {
	            return Response.status(Response.Status.FORBIDDEN).build();
	        }      
	    }

	
	    private String issueToken(String username)  {
	        
	    	
	    		   Algorithm algorithm = Algorithm.HMAC256("secret");
	               String token = JWT.create()
	                       .withIssuer("auth0")
	                       .sign(algorithm);

	   	    	return token;
	           
	    	 
	    }
	    
	
}

