package Objets.Interface;

import Objets.Objet;
import jobs.Degree;

public interface Offensif extends Objet{
	

	public static final int UNEMAIN = 1;
	public static final int DEUXMAINS = 2;

	public Degree getImpactArme();

	public Degree getManiabilite();

	public Degree getImpactMagique();
	
	public String getDescription();
	
	public int getNombreMain();

	public int getPortee();
	
	
	
}
