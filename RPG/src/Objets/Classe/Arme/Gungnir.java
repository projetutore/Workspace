package Objets.Classe.Arme;

import jobs.Degree;
import jobs.Heros;
import jobs.Monstre;
import CalculEtCombat.Calcul;
import Objets.Interface.Arme;

public class Gungnir implements Arme{
 
	public static final Degree bonusD = new Degree(7);
	public static final Degree impactM = new Degree(7);
	public static final Degree maniab = new Degree(11);
	public static final Degree impactD = new Degree(13);

	
	public Degree getImpactArme() {
		// TODO Auto-generated method stub
		return impactD;
	}

	@Override
	public Degree getManiabilite() {
		// TODO Auto-generated method stub
		return impactM;
	}

	@Override
	public Degree getImpactMagique() {
		// TODO Auto-generated method stub
		return impactM;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "La lance ayant appartenu au Dieu Odin. "
				+ "Elle est tombée dans les abysses à sa mort.\n"
				+ "Augmente de 1D la defense.";
	}

	@Override
	public int getNombreMain() {
		// TODO Auto-generated method stub
		return DEUXMAINS;
	}

	@Override
	public int getPortee() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String getNomObjet() {
		// TODO Auto-generated method stub
		return "Gungnir";
	}

	@Override
	public String affichageCaracteristique() {
		// TODO Auto-generated method stub
		return this.getNomObjet() + "\nImpactArme: "+ this.getImpactArme() + "; Maniabilite: " + this.getManiabilite() +
				"\nPortee = " + this.getPortee() + "; NombreMain = " + DEUXMAINS ;
				}

	@Override
	public String emplacementEquipement() {
		// TODO Auto-generated method stub
		return "Main";
	}

	@Override
	public Arme equiper(Heros h) {
		// TODO Auto-generated method stub
		h.setDegats(Degree.somme(h.getDegats(), this.getImpactArme()));
		h.setAttaque(Degree.somme(h.getAttaque(), this.getManiabilite()));
		try{
			h.setDegatsM(Degree.somme(h.getDegatsM(), this.getImpactMagique()));
			}catch (NullPointerException e){
				h.setDegatsM(Degree.somme(h.getdIntelligence(), this.getImpactMagique()));
			}
		h.setDefense(Degree.somme(h.getDefense(), bonusD));
		return this;
	}

	@Override
	public Arme desequiper(Heros h) {
		h.setMainDroite(Heros.DEFAULT_MAINDROITE);
		h.setMainGauche(Heros.DEFAULT_MAINGAUCHE);
		h.setDegats(Degree.soustraction((h.getDegats()), this.getImpactArme()));
		h.setAttaque(Degree.soustraction((h.getAttaque()),  this.getManiabilite()));	
		h.setDefense(Degree.soustraction(h.getDefense(), bonusD));
		h.setDegatsM(Degree.soustraction((h.getDegatsM()), impactM));
		return this;

	}

	@Override
	public Arme desequiper(Heros h, int numMain) {
		return null;
		
	}

	@Override
	public void attaquer(Heros h, Monstre m) {
		int regen = Calcul.calculDegats(h, m)/2;
		h.regainDeVie(regen);
		System.out.println("En outre, Gungnir vous permet de récuperer " + regen + " de vie."
				+ "\nVotre vie est à présent de " + h.getVie());
	}

	public void utiliser(Heros h) {
		h.equiper(this);;
	}
}
