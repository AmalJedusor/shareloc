package root;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table
public class Colocation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 	   
	private long id;
	private String name;
	private long master;
	ArrayList<UserC> users = new ArrayList<>();
	ArrayList<Service> services  = new ArrayList<>();
	ArrayList<AchievedService> achievedServices = new ArrayList<>();
	
	public Colocation() {
		
	}
	public Colocation(String name, long userid) {
		
		this.name = name;
		this.master = userid;
		
		/*
		User example = new User();
		this.users.add(example);
		this.services.add(new Service());
		this.achievedServices.add(new AchievedService());
		*/
		}
	
	public ArrayList<UserC> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<UserC> users) {
		this.users = users;
	}
	public ArrayList<Service> getServices() {
		return services;
	}
	public void setServices(ArrayList<Service> services) {
		this.services = services;
	}
	public ArrayList<AchievedService> getAchievedServices() {
		return achievedServices;
	}
	public void setAchievedServices(ArrayList<AchievedService> achievedServices) {
		this.achievedServices = achievedServices;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMaster() {
		return master;
	}

	public void setMaster(long master) {
		this.master = master;
	}


}


