package jeu;

import java.io.Serializable;

import sauvegarde.SauvegardeJeu;
import jobs.Heros;
import jobs.Monstre;
import carte.Carte;

public class Jeu implements Serializable {
	@Override
	public String toString() {
		return "Jeu [carte=" + carte + ", personnageJoueur=" + personnageJoueur
				+ "]";
	}

	public Carte carte;
	public Heros personnageJoueur;
	
	public Jeu(){
		carte = new Carte(10,10);
		personnageJoueur = Heros.creationPersonnage();
		//carte.Afficher();
		//carte.placer(3, 3, personnageJoueur);
				
		//carte.placer(2, 5, new Monstre());		carte.placer(10, 7, new Monstre());		carte.placer(10, 2, new Monstre());

		//carte.deplacement();	
	}
	
	public static void main (String args[]){
		Jeu test=  new Jeu();
		SauvegardeJeu save = new SauvegardeJeu(test);
	}
}
