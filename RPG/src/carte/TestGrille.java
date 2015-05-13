package carte;

public class TestGrille {
	public static void main (String[] args){
		Carte c1 = new Carte(12,8);
		c1.placer(3, 5, 'J');
		c1.placer(8, 2, 'O'); c1.placer(7, 4, 'O'); c1.placer(2, 8, 'O');
		c1.placer(1, 1, 'M'); c1.placer(10, 7, 'M'); c1.placer(11, 2, 'M');
		
		System.out.print("Debut test\n");
		System.out.print(c1.getCase(3, 5) + "= J \n");
		System.out.print(c1.getCase(7, 4) + "= O\n");
		System.out.print(c1.getCase(10, 7) + "= M\n");
		System.out.print(c1.getCase(3, 3) + "= .\n");
		System.out.println("Test de deplacer\n");
		c1.deplacerHaut();
		System.out.print(c1.getCase(3, 5) + "= . \n");
		
		System.out.println("Début de la partie...");
		System.out.println("Création du personnage...");
		Personnage p1 = new Personnage();
		System.out.println("Affichage du personnage...");
		
		System.out.println("Vie : " + p1.getVie());
		System.out.println("Xp : " + p1.getXp());
		System.out.println("Votre personnage se fait attaquer \n il perd 15 pts de vie");
		p1.setVie(85);
		System.out.println("Vie : " + p1.getVie());
		System.out.println("Xp : " + p1.getXp());
		System.out.println("Votre personnage se repose 2 min");
		p1.seReposer(2);
		System.out.println("Vie : " + p1.getVie());
		System.out.println("Xp : " + p1.getXp());
		System.out.println("Fin de la partie\n-----------------------");
	

	}
}

