package root;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class AchievedService extends Service {
		UserC from ;
		UserC to ;// utilisateur(s) ayant b�n�fici� du service
		String date ; // date � laquelle a �t� rendu le service
		String picture; // photo accompagnant �ventuellement la d�claration
		Boolean valid ; // indique si la d�claration de service fait a �t� valid�e ou non

	
}
