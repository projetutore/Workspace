package Objets;

import jobs.Degree;

public class BaguetteMagique extends Arme{

	public final static int PORTEE_BAGUETTE = 3;
	
	
	public BaguetteMagique(String baguetteMagique, Degree impactArme, Degree impactMagique,  Degree maniabilite, String description) throws ExceptionArme{
		super(baguetteMagique, impactArme, impactMagique, maniabilite,  description);
		this.setPortee(PORTEE_BAGUETTE);
		this.setNombreMain(UNEMAIN);
	}
	
}
