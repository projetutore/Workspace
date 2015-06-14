package Objets.Classe.Arme;

import jobs.Degree;
import jobs.Heros;
import jobs.Monstre;
import CalculEtCombat.Calcul;
import Objets.Interface.Arme;
import Objets.Interface.Objet;

public class Arc implements Arme{
	private String nomArc; 
	private Degree impactArc;
	private Degree maniabilite;
	private String description;
	private int portee;

	
	public Arc(String nomArc, Degree impactArc, Degree maniabilite, int portee, String description) throws ExceptionArme {
		this.nomArc = nomArc;
		this.impactArc = impactArc; 
		this.maniabilite = maniabilite;
		this.portee = portee;
	}

	@Override
	public String getNomObjet() {
		return nomArc;
	}

	@Override
	public Degree getImpactArme() {
		// TODO Auto-generated method stub
		return impactArc;
	}

	@Override
	public Degree getManiabilite() {
		// TODO Auto-generated method stub
		return maniabilite;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	@Override
	public int getNombreMain() {
		// TODO Auto-generated method stub
		return DEUXMAINS;
	}

	@Override
	public int getPortee() {
		// TODO Auto-generated method stub
		return portee;
	}

	public String toString(){
		return "O";
	}
	
	@Override
	public String affichageCaracteristique() {
		// TODO Auto-generated method stub
		return  nomArc +"\nImpactArme: "+ impactArc + "; Maniabilite:"+ maniabilite +"\nPortee = " + portee
				+ "; NombreMain = " + DEUXMAINS;
	}

	@Override
	public Degree getImpactMagique() {
		// TODO Auto-generated method stub
		return null;
	}

	public String emplacementEquipement() {
		// TODO Auto-generated method stub
		return "Main";
	}

	@Override
	public Arme equiper(Heros h) {
		h.setDegats(Degree.somme(h.getDegats(), this.getImpactArme()));
		h.setAttaque(Degree.somme(h.getAttaque(), this.getManiabilite()));
		h.retirerObjet(this);
		return this;
	}

	@Override
	public Arme desequiper(Heros h) {
		h.setMainDroite(Heros.DEFAULT_MAINDROITE);
		h.setMainGauche(Heros.DEFAULT_MAINGAUCHE);
		h.setDegats(Degree.soustraction((h.getDegats()), this.getImpactArme()));
		h.setAttaque(Degree.soustraction((h.getAttaque()),  this.getManiabilite()));	
		h.ajoutObjet(this);
		return this;
	}

	@Override
	public Arme desequiper(Heros h, int numMain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void attaquer(Heros h, Monstre m) {
		Calcul.calculDegats(h, m);		
	}

	@Override
	public void utiliser(Heros h) {
		h.equiper(this);
	}

	@Override
	public String typeArme() {
		// TODO Auto-generated method stub
		return "Arc";
	}
}
