package Objets.Classe.Protection;

import jobs.Degree;
import jobs.Heros;
import Objets.Interface.Armure;

public class Tete implements Armure {

	public Tete() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Degree getEncombrement() {
		// TODO Auto-generated method stub
		return new Degree();
	}

	@Override
	public Degree getSolidite() {
		// TODO Auto-generated method stub
		return new Degree();
	}

	@Override
	public Degree getResistanceMagique() {
		// TODO Auto-generated method stub
		return new Degree();
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNomObjet() {
		// TODO Auto-generated method stub
		return "Tete";
	}

	@Override
	public String affichageCaracteristique() {
		// TODO Auto-generated method stub
		return "Tete";
	}

	@Override
	public String emplacementEquipement() {
		// TODO Auto-generated method stub
		return "Tete";
	}

	@Override
	public void utiliser(Heros h) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String typeArmure() {
		// TODO Auto-generated method stub
		return "Tete";
	}

	@Override
	public Armure equiper(Heros h) {
		// TODO Auto-generated method stub
		h.setInitiative(h.getInitiative());
		h.setEsquive(h.getEsquive());
		h.setDefense(h.getDefense());
		h.setDefenseM(h.getDefenseM());
		return this;
	}

	@Override
	public Armure desequiper(Heros h) {
		// TODO Auto-generated method stub
		h.setInitiative(Degree.somme(h.getInitiative(), this.getEncombrement()));
		h.setEsquive(Degree.somme(h.getEsquive(),this.getEncombrement()));
		h.setDefense(Degree.soustraction(h.getDefense(), this.getSolidite()));		
		h.setDefenseM(Degree.somme(h.getDefenseM(), this.getResistanceMagique()));
		
		return this;
	}

	public String toString(){
		return "O";
	}
}
