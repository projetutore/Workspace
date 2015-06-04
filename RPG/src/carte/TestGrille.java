package carte;

import jobs.Heros;

public class TestGrille {
	public static void main (String[] args){
		Carte c1 = new Carte(12,8);
		c1.placer(3, 5, new Heros());
		//c1.placer(8, 2, 'O'); c1.placer(7, 4, 'O'); c1.placer(2, 8, 'O');
		c1.placer(1, 1, new Monstres()); c1.placer(10, 7, new Monstres()); c1.placer(11, 2, new Monstres());
		
		System.out.print("Debut test\n");
		System.out.print(c1.getCase(3, 5) + "= J \n");
		System.out.print(c1.getCase(7, 4) + "= O\n");
		System.out.print(c1.getCase(10, 7) + "= M\n");
		System.out.print(c1.getCase(3, 3) + "= .\n");
		System.out.println("Test de deplacer\n");
		c1.deplacerHaut();
		System.out.print(c1.getCase(3, 5) + "= . \n");
		
		System.out.println("D�but de la partie...");
		System.out.println("Cr�ation du personnage...");
		Heros p1 = new Heros();
		System.out.println("Affichage du personnage...");
		
		System.out.println("Vie : " + p1.getVie());
		System.out.println("Xp : " + p1.getExperience());
		System.out.println("Votre personnage se fait attaquer \n il perd 15 pts de vie");
		p1.setVie(85);
		System.out.println("Vie : " + p1.getVie());
		System.out.println("Xp : " + p1.getExperience());
		System.out.println("Votre personnage se repose 2 min");
	//	p1.seReposer(2);
		System.out.println("Vie : " + p1.getVie());
		System.out.println("Xp : " + p1.getExperience());
		System.out.println("Fin de la partie\n-----------------------");
	

	}
}

