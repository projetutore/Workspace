package Objets.Classe.Arme;

import Objets.Interface.Arme;
import jobs.Degree;
import jobs.Heros;

public class HacheUneMain implements Arme {
	private String nomHacheUneMain; 
	private Degree impactHacheUneMain;
	private Degree maniabilite;
	private String description;
	private int portee = 1 ; 
	
	public String getNomObjet() {
		return nomHacheUneMain;
	}

	public String affichageCaracteristique() {
		return  nomHacheUneMain + "\nImpactArme: "+ impactHacheUneMain + "; Maniabilite: " + maniabilite +
				"\nPortee = " + portee + "; NombreMain = " + UNEMAIN;
	}

	public String emplacementEquipement() {
		return "Main";
	}

	public Degree getImpactArme() {
		return impactHacheUneMain;
	}

	public Degree getManiabilite() {
		return maniabilite;
	}

	public Degree getImpactMagique() {
		return null;
	}

	public String getDescription() {
		return null;
	}

	public int getNombreMain() {
		return UNEMAIN;
	}
	
	public int getPortee() {
		return portee;
	}

	@Override
	public Arme equiper(Heros h) {
		h.setDegats(Degree.somme(h.getDegats(), this.getImpactArme()));
		h.setAttaque(Degree.somme(h.getAttaque(), this.getManiabilite()));
		
		return this;
		
	}

	@Override
	public void desequiper(Heros h, int numMain) {
		switch(numMain){
		case 1: 
			h.setMainDroite(Heros.DEFAULT_MAINDROITE);
			break;
		case 2:
			h.setMainGauche(Heros.DEFAULT_MAINGAUCHE);
			break;
		}
		h.setDegats(Degree.soustraction((h.getDegats()), this.getImpactArme()));
		h.setAttaque(Degree.soustraction((h.getAttaque()),  this.getManiabilite()));	
	}

	@Override
	public void desequiper(Heros h) {
		// TODO Auto-generated method stub
		
	}
	
}
