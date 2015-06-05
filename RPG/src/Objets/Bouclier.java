package Objets;

import jobs.Degree;

public class Bouclier implements Arme{

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

	@Override
	public String getNomObjet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Degree getImpactArme() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Degree getManiabilite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNombreMain() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPortee() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String affichageCaracteristique() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String emplacementEquipement() {
		// TODO Auto-generated method stub
		return "Main";
	}

	@Override
	public Degree getImpactMagique() {
		// TODO Auto-generated method stub
		return null;
	}

}
