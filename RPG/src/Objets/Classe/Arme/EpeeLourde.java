package Objets.Classe.Arme;

import Objets.ExceptionArme;
import Objets.Interface.Arme;
import jobs.Degree;
import jobs.Heros;

public class EpeeLourde implements Arme {
	private String nomEpeeLourde; 
	private Degree impactEpeeLourde;
	private Degree maniabilite;
	private String description;
	private int portee = 1 ; 

	
	public EpeeLourde(String nomEpeeLourde, Degree impactEpeeLourde, Degree maniabilite, String description) throws ExceptionArme {
		this.nomEpeeLourde = nomEpeeLourde;
		this.impactEpeeLourde = impactEpeeLourde; 
		this.maniabilite = maniabilite;
	}

	@Override
	public String getNomObjet() {
		return nomEpeeLourde;
	}

	@Override
	public Degree getImpactArme() {
		// TODO Auto-generated method stub
		return impactEpeeLourde;
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
		return  nomEpeeLourde +"\nImpactArme: "+ impactEpeeLourde + "; Maniabilite:"+ maniabilite +"\nPortee = " + portee
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
		
		return this;
	}

	@Override
	public void desequiper(Heros h) {
		h.setMainDroite(Heros.DEFAULT_MAINDROITE);
		h.setMainGauche(Heros.DEFAULT_MAINGAUCHE);
		h.setDegats(Degree.soustraction((h.getDegats()), this.getImpactArme()));
		h.setAttaque(Degree.soustraction((h.getAttaque()),  this.getManiabilite()));
	}

	@Override
	public void desequiper(Heros h, int numMain) {
		// TODO Auto-generated method stub
		
	}

}
