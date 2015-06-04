package Objets;

import jobs.Degree;

public class EpeeLegere extends Arme {
	public static final int PORTEE_EPEE_LEGERE = 1;
	
	public EpeeLegere(String nomArme, Degree impactArme, Degree maniabilite, String description) throws ExceptionArme {
		super(nomArme, impactArme, maniabilite, description);
		this.setPortee(PORTEE_EPEE_LEGERE);
		this.setNombreMain(UNEMAIN);
	}

}
