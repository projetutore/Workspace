package Objets;

import jobs.Degree;

public class Baton extends Arme {

	public final static int PORTEE_BATON = 1;
	
	
	public Baton(String nomBaton, Degree impactArme,Degree impactMagique, Degree maniabilite,   String description) throws ExceptionArme{
		super(nomBaton, impactArme, impactMagique, maniabilite, description);
		this.setPortee(PORTEE_BATON);
		this.setNombreMain(DEUXMAINS);
	}
	
}
