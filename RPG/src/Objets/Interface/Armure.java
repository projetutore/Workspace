package Objets.Interface;

import jobs.Heros;

public interface Armure extends Defensif{

	public Armure equiper(Heros h);
	public void desequiper(Heros h);

}