package Objets.Classe.Arme;

import CalculEtCombat.Calcul;
import Objets.ExceptionArme;
import Objets.Interface.Arme;
import jobs.Degree;
import jobs.Heros;
import jobs.Monstre;

public class EpeeLegere implements Arme {
	private String nomEpeeLegere; 
	private Degree impactEpeeLegere;
	private Degree maniabilite;
	private String description;
	private int portee = 1 ; 
	private int nombreMain = UNEMAIN ;

	
	public EpeeLegere(String nomEpeeLegere, Degree impactEpeeLegere, Degree maniabilite, String description) throws ExceptionArme {
		this.nomEpeeLegere = nomEpeeLegere;
		this.impactEpeeLegere = impactEpeeLegere; 
		this.maniabilite = maniabilite;
	}

	@Override
	public String getNomObjet() {
		return nomEpeeLegere;
	}

	@Override
	public Degree getImpactArme() {
		// TODO Auto-generated method stub
		return impactEpeeLegere;
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
		return nombreMain;
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
		return  nomEpeeLegere +"\nImpactArme: "+ impactEpeeLegere + "; Maniabilite:"+ maniabilite +"\nPortee = " + portee
				+ "; NombreMain = " + nombreMain;
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

	@Override
	public void attaquer(Heros h, Monstre m) {
		Calcul.calculDegats(h, m);
	}
		
/*		
		try{
			
			for(int i=1; i<= this.getJequip().getMain1().getRange() ; i++  ){
				
				if(jeu.getGrille()[this.x - i][this.y] instanceof Mob){
				((Mob) jeu.getGrille()[this.x - i][this.y]).damage(this,jeu);
				return true;
					}
				}
			}
				catch(ArrayIndexOutOfBoundsException e){
					
				}
				
			
			
				return false;
		}
		
		
	}

*/
}
