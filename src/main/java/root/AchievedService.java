package root;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class AchievedService extends Service {
		UserC from ;
		UserC to ;// utilisateur(s) ayant bénéficié du service
		String date ; // date à laquelle a été rendu le service
		String picture; // photo accompagnant éventuellement la déclaration
		Boolean valid ; // indique si la déclaration de service fait a été validée ou non

	
}
