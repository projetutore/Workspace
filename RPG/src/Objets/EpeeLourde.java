package Objets;

import jobs.Degree;

public class EpeeLourde extends Arme {

	public static final int PORTEE_EPEE_LOURDE = 1;
	
	public EpeeLourde(String nomArme, Degree impactArme, Degree maniabilite, String description) throws ExceptionArme {
		super(nomArme, impactArme, maniabilite, description);
		this.setPortee(PORTEE_EPEE_LOURDE);
		this.setNombreMain(DEUXMAINS);
	}

}
