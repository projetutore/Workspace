package Objets;

import jobs.Degree;

public class Main implements Arme {

	private String nomMain;
	public static final String MainDroite = "Main Droite";
	public static final String MainGauche = "Main Gauche";
	
	public Main(String nomMain){
		this.nomMain = nomMain;
	}
	public String getNomObjet() {
		return nomMain;
	}

	@Override
	public Degree getImpactArme() {
		// TODO Auto-generated method stub
		return new Degree();
	}

	@Override
	public Degree getManiabilite() {
		// TODO Auto-generated method stub
		return new Degree();
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Votre main, quoi de plus?";
	}

	@Override
	public int getNombreMain() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getPortee() {
		// TODO Auto-generated method stub
		return 1;
	}

	public String toString(){
		return nomMain +" " +this.getDescription();
	}
	public static void main (String args[]){
		System.out.println(new Main("Main Droite"));
	}
	@Override
	public Degree getImpactMagique() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String affichageCaracteristique() {
		// TODO Auto-generated method stub
		return nomMain;
	}
	
	public String typeEquipement() {
		// TODO Auto-generated method stub
		return "Main";
	}
}
