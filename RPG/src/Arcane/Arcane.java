package Arcane;

import java.io.Serializable;

import carte.Carte;
import jobs.Personnage;



public interface Arcane extends Serializable {
  
	public String getNomArcane();
	public int getCoutMana(Personnage p);
	public int getCoutPa();
	public int niveauAcquision();
	public int getDegatsArcane();
	public int getPorteeArcane();
	public String getRatio();
	public String getDescription();
	public void utilisationArcane(Carte carte, Personnage p);

}
