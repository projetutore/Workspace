package Objets.Classe.Protection;

import jobs.Degree;
import jobs.Heros;
import Objets.Interface.Armure;

public class Bottes implements Armure {

	public Degree agile;
	

	@Override
	public Degree getEncombrement() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Degree getSolidite() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Degree getResistanceMagique() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getNomObjet() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String affichageCaracteristique() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String emplacementEquipement() {
		// TODO Auto-generated method stub
		return "Pieds";
	}


	@Override
	public void utiliser(Heros h) {
		h.equiper(this);
	}


	@Override
	public String typeArmure() {
		// TODO Auto-generated method stub
		return "Bottes";
	}


	@Override
	public Armure equiper(Heros h) {
		// TODO Auto-generated method stub
		h.retirerObjet(this);
		return this;
	}


	@Override
	public Armure desequiper(Heros h) {
		// TODO Auto-generated method stub
		h.ajoutObjet(this);
		return this;
	}

	public String toString(){
		return "O";
	}
	
}
