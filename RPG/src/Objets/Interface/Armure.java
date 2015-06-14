package Objets.Interface;

import jobs.Heros;

public interface Armure extends Defensif{

	public String typeArmure();
	public Armure equiper(Heros h);
	public Armure desequiper(Heros h);

}
