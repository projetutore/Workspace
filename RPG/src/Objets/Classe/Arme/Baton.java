package Objets.Classe.Arme;

import CalculEtCombat.Calcul;
import Objets.Interface.Arme;
import jobs.Degree;
import jobs.Heros;
import jobs.Monstre;

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

	@Override
	public Arme equiper(Heros h) {
		h.setDegats(Degree.somme(h.getDegats(), this.getImpactArme()));
		h.setAttaque(Degree.somme(h.getAttaque(), this.getManiabilite()));
		try{
		h.setDegatsM(Degree.somme(h.getDegatsM(), this.getImpactMagique()));
		}catch (NullPointerException e){
			h.setDegatsM(Degree.somme(h.getdIntelligence(), this.getImpactMagique()));
		}
		h.retirerObjet(this);
		return this;
		}



	@Override
	public Arme desequiper(Heros h) {
		h.setMainDroite(Heros.DEFAULT_MAINDROITE);
		h.setMainGauche(Heros.DEFAULT_MAINGAUCHE);
		h.setDegats(Degree.soustraction((h.getDegats()), this.getImpactArme()));
		h.setAttaque(Degree.soustraction((h.getAttaque()),  this.getManiabilite()));
		h.setDegatsM(Degree.soustraction((h.getDegatsM()), this.getImpactMagique()));
		h.ajoutObjet(this);

		return this;
	}

	@Override
	public Arme desequiper(Heros h, int numMain) {
		return null;
		
	}

	@Override
	public void attaquer(Heros h, Monstre m) {
		Calcul.calculDegats(h, m);		
		
	}
	
	public void utiliser(Heros h) {
		h.equiper(this);;
	}

	@Override
	public String typeArme() {
		// TODO Auto-generated method stub
		return "Baton";
	}
}
