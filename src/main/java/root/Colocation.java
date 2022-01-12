package root;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table
public class Colocation {
	private String name;
	ArrayList<User> users;
	private int master;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 	   
	private int id;
	ArrayList<Service> services;
	ArrayList<AchievedService> achievedServices;
	
public Colocation() {
	
}
	public Colocation(String name, int master) {
		
		this.name = name;
		this.master = master;

		
		this.id = 0;
	}
	


	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
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



	private class Service {
		String title;
		String description;
		String cost;
	}
	private class AchievedService extends Service {
		User from ;
		User to ;// utilisateur(s) ayant b�n�fici� du service
		String date ; // date � laquelle a �t� rendu le service
		String picture; // photo accompagnant �ventuellement la d�claration
		Boolean valid ; // indique si la d�claration de service fait a �t� valid�e ou non

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaster() {
		return master;
	}

	public void setMaster(int master) {
		this.master = master;
	}


}


