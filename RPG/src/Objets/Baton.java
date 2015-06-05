package Objets;

import jobs.Degree;

public class Baton implements Arme {

	private String nomBaton; 
	private Degree impactBaton;
	private Degree maniabilite;
	private Degree impactMagique;
	private String description;
	private int portee = 1 ; 
	private int nombreMain = DEUXMAINS ;


/*	public afficherInventaire(){
		int i = 0;
		for(Objet c : Inventaire){
			System.out.println(i + Inventaire[0]);
			
		}
	}*/
	
	public Baton(String nomBaton, Degree impactBaton, Degree impactMagique,  Degree maniabilite, String description) throws ExceptionArme{
		this.nomBaton = nomBaton;
		this.impactBaton = impactBaton; 
		this.impactMagique = impactMagique;
		this.maniabilite = maniabilite;
		this.description = description;
	}
	
	public Degree getImpactMagique() {
		return impactMagique;
	}

	public String getNomObjet() {
		return nomBaton;
	}

	public Degree getImpactArme() {
		return impactBaton;
	}

	public Degree getManiabilite() {
		return maniabilite;
	}

	public String getDescription() {
		return description;
	}

	public int getNombreMain() {
		return nombreMain;
	}

	public int getPortee() {
		return portee;
	}
	
	public String toString(){
		return "O";
	}
	
	public String affichageCaracteristique(){
		return  nomBaton + "\nImpactArme: "+ impactBaton + "; Maniabilite: " + maniabilite + "; ImpactMagique" + impactMagique +
				"\nPortee = " + portee + "; NombreMain " + nombreMain;
	}

	@Override
	public String emplacementEquipement() {
		// TODO Auto-generated method stub
		return "Main";
	}
}
