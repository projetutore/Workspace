package Objets.Interface;

import jobs.Degree;

public interface Defensif extends Objet {

	public Degree getEncombrement();

	public Degree getSolidite();

	public Degree getResistanceMagique();
	
	public String getDescription();
	
}
