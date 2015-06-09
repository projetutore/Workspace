package Objets.Classe.Arme;

import CalculEtCombat.Calcul;
import Objets.ExceptionArme;
import Objets.Interface.Arme;
import jobs.Degree;
import jobs.Heros;
import jobs.Monstre;

public class BaguetteMagique implements Arme{

	private String nomBaguette; 
	private Degree impactArme;
	private Degree maniabilite;
	private Degree impactMagique;
	private String description;
	private int portee = 3 ; 
	private int nombreMain = UNEMAIN ;


/*	public afficherInventaire(){
		int i = 0;
		for(Objet c : Inventaire){
			System.out.println(i + Inventaire[0]);
			
		}
	}*/
	
	public BaguetteMagique(String nomBaguetteMagique, Degree impactArme, Degree impactMagique,  Degree maniabilite, String description) throws ExceptionArme{
		this.nomBaguette = nomBaguetteMagique;
		this.impactArme = impactArme; 
		this.impactMagique = impactMagique;
		this.maniabilite = maniabilite;
		this.description = description;
	}
	
	public Degree getImpactMagique() {
		return impactMagique;
	}

	public String getNomObjet() {
		return nomBaguette;
	}

	public Degree getImpactArme() {
		return impactArme;
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
		return  nomBaguette + "\nImpactArme: "+ impactArme + "; Maniabilite: " + maniabilite + "; ImpactMagique: " + impactMagique +
				"\nPortee = " + portee + "; NombreMain = " + nombreMain;
	}
	public static void main(String args[]) throws ExceptionArme{
		Arme x = new BaguetteMagique("Baguette de Luxe", new Degree(3), new Degree(3), new Degree(3), "");
		System.out.println(x.affichageCaracteristique());
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
		h.setDegatsM(Degree.somme(h.getDegatsM(), this.getManiabilite()));
		
		return this;
		
	}


	public Arme desequiper(Heros h, int numMain) {
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
		h.setDegatsM(Degree.soustraction((h.getDegatsM()), this.getImpactMagique()));
		return this;

	}

	@Override
	public Arme desequiper(Heros h) {
		return null;
	}

	@Override
	public void attaquer(Heros h, Monstre m) {
		Calcul.calculDegats(h, m);		
		
	}

	@Override
	public void utiliser(Heros h) {
		h.equiper(this);;
	}
}
