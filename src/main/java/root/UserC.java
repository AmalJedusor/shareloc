package root;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;

@Entity
@Table(name="userc")
public class UserC {
	private String email;
	private String name;
	private String lastname;
	private String password;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ArrayList<Colocation> getColocations() {
		return colocations;
	}
	public void setColocations(ArrayList<Colocation> colocations) {
		this.colocations = colocations;
	}

	private ArrayList<Colocation> colocations;
	
	public UserC() {
		
	}
	public UserC(String email, String name, String lastname, String password) {
		
		this.email =email ;
		this.name = name;
		this.lastname = lastname;
		this.password = password;
		
	}
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}


