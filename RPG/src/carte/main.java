package carte;
import java.util.*;

public class main {
	public static void main (String[] args){
		/*System.out.println("Veuillez entrer un nom");
		 *Scanner sc1 = new Scanner(System.in);
		 *int nb = sc1.nextInt();
		 *System.out.println("Vous avez entrŽ : " + nb);
		 *
		 *System.out.println("Veuillez entrer une chaine :");
		 *Scanner sc2 = new Scanner(System.in);
		 *String str = sc2.nextLine();
		 *System.out.println("Vous avez entrŽ : " + str);
		 */
		//Creation de la grille 
		Carte c1 = new Carte(12,10);
		
		//On lace les ŽlŽments 
		c1.placer(3, 5, 'J');
		
		c1.placer(8, 2, 'O');		c1.placer(7, 4, 'O');		c1.placer(2, 8, 'O');
		
		c1.placer(2, 5, 'M');		c1.placer(10, 7, 'M');		c1.placer(11, 2, 'M');

		//Affichage
		System.out.println("J = joueur\nO = objet\nM = monstre\n. = vide");
		c1.Afficher();
		
		Personnage p1 = new Personnage();
		System.out.println("CaractŽristique de votre personnage :");
		System.out.println(p1.toString());
		
		Monstres m1 = new Monstres();
		
		int i = 0;
		while(i<1){
		
			System.out.println("Vers o� voulez vous deplacer ?\n(1 = haut, 2 = bas, 3 = gauche, 4 = droite)");
			Scanner scan = new Scanner(System.in);
			int nb = scan.nextInt();
			
			switch (nb){
			case 1: c1.deplacerHaut();
		
				System.out.println("DŽbut du combat...");
				while(p1.getVie() > 0 && m1.getVie() > 0 ){
					System.out.println("CaractŽristique de l'adversaire :");
					System.out.println(m1.toString());
					System.out.println("Vos caractŽristiques : ");
					System.out.println(p1.toString());
					System.out.println("Vous lancer une attaque !");
					m1.setVie(m1.getVie() - p1.attaquer()); 
					System.out.println("Vous vous faite attaquer !");
					p1.setVie(p1.getVie() - m1.attaquer());
					
						for(int j = 0; j < 1; j++){
							System.out.println("\n  \n");
						}
				}
				System.out.println("Fin du combat...");
			break;
			case 2: c1.deplacerBas();
			break;
			case 3: c1.deplacerGauche();
			break;
			case 4: c1.deplacerDroite();
			break;
			default: System.out.println("mauvais chiffre");
			}
			
			i++;
		}
	}
}
