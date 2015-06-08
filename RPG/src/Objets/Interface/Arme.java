package Objets.Interface;

import jobs.Heros;

public interface Arme extends Offensif{

	public Arme equiper(Heros h);
	public void desequiper(Heros h);
	public void desequiper(Heros h, int numMain);
}
