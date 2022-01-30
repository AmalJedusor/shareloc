package root;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Service {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO) 	   
		private long id;
		String title;
		String description;
		String cost;
	



}
