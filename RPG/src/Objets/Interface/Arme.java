package Objets.Interface;

import jobs.Heros;
import jobs.Monstre;

public interface Arme extends Offensif{

	public Arme equiper(Heros h);
	public void desequiper(Heros h);
	public void desequiper(Heros h, int numMain);
	public void attaquer(Heros h, Monstre y);
}
