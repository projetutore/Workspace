package Objets;

import jobs.Degree;

public class Bouclier extends Arme{

	private Degree resistanceBouclier;
	public final static int PORTEE_BOUCLIER= 1;
	
	public Bouclier(String nomBouclier, Degree impactBouclier, Degree maniabiliteArme, Degree resistanceBouclier, String description){
		super(nomBouclier, impactBouclier, maniabiliteArme, UNEMAIN, description );
		this.resistanceBouclier = resistanceBouclier; 
	}

	public Degree getResistanceBouclier() {
		return resistanceBouclier;
	}

	public void setResistanceBouclier(Degree resistanceBouclier) {
		this.resistanceBouclier = resistanceBouclier;
	}
	
	public String toString(){
		return this.getNomObjet() + ", impactArme=" + getImpactArme() +	", maniabilite="+ getManiabilite() + ", nombreMain=" + getNombreMain();
	}

}
