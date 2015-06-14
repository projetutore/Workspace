package Objets.Classe.Protection;

import jobs.Degree;
import jobs.Heros;
import Objets.Interface.Armure;

public class Robe implements Armure {

	String nomRobe;
	private Degree soliditeRobe;
	private Degree resistanceMagRobe;
	private Degree poids;
	private String description;
	
	@Override
	public Degree getEncombrement() {
		// TODO Auto-generated method stub
		return poids;
	}

	@Override
	public Degree getSolidite() {
		// TODO Auto-generated method stub
		return soliditeRobe;
	}

	@Override
	public Degree getResistanceMagique() {
		// TODO Auto-generated method stub
		return resistanceMagRobe;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	@Override
	public String getNomObjet() {
		// TODO Auto-generated method stub
		return nomRobe;
	}

	@Override
	public String affichageCaracteristique() {
		// TODO Auto-generated method stub
		return   nomRobe + "\nResistance Robe: " + soliditeRobe + "; +  ResistanceMag :" +resistanceMagRobe + " PoidsRobe: " + poids
				+ "\nEmplacement : " + this.emplacementEquipement();
	}

	@Override
	public String emplacementEquipement() {
		// TODO Auto-generated method stub
		return "Torse";
	}

	@Override
	public void utiliser(Heros h) {
		// TODO Auto-generated method stub
		h.equiper(this);
	}

	@Override
	public String typeArmure() {
		// TODO Auto-generated method stub
		return "Robe";
	}

	@Override
	public Armure equiper(Heros h) {
		h.setDefense(Degree.somme(h.getDefense(), this.getSolidite()));
		h.setInitiative(Degree.soustraction(h.getInitiative(), this.getEncombrement()));
		h.setEsquive(Degree.soustraction(h.getEsquive(),this.getEncombrement()));
		h.setDefenseM(Degree.somme(h.getDefenseM(), this.getResistanceMagique()));
		h.retirerObjet(this);
		return this;
	}

	@Override
	public Armure desequiper(Heros h) {
		h.setDefense(Degree.soustraction(h.getDefense(), this.getSolidite()));
		h.setInitiative(Degree.somme(h.getInitiative(), this.getEncombrement()));
		h.setEsquive(Degree.somme(h.getEsquive(),this.getEncombrement()));
		h.setDefenseM(Degree.soustraction(h.getDefenseM(), this.getResistanceMagique()));
		h.ajoutObjet(this);
		return this;
	}

	public String toString(){
		return "O";
	}

}
