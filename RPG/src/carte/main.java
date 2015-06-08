package carte;
import java.util.*;

import jobs.Heros;
import jobs.Monstre;

public class main {
	
	public static void main (String[] args){
		/*System.out.println("Veuillez entrer un nom");
		 *Scanner sc1 = new Scanner(System.in);
		 *int nb = sc1.nextInt();
		 *System.out.println("Vous avez entr� : " + nb);
		 *
		 *System.out.println("Veuillez entrer une chaine :");
		 *Scanner sc2 = new Scanner(System.in);
		 *String str = sc2.nextLine();
		 *System.out.println("Vous avez entr� : " + str);
		 */
		//Creation de la grille 
		Carte c1 = new Carte(12,8);
		
		//On lace les �l�ments 
		c1.placer(3, 3, new Heros());
		
		//c1.placer(8, 2, 'O');		c1.placer(7, 4, 'O');		c1.placer(2, 8, 'O');
		
		//c1.placer(2, 5, new Monstre());		c1.placer(10, 7, new Monstre());		c1.placer(11, 2, new Monstre());

		int j = 0;
		while(j<5){
		c1.placementAleatoire();
		j++;
		}
		//Affichage
		System.out.println("J = joueur\nO = objet\nM = monstre\n. = vide");
		c1.Afficher();
		
		Heros p1 = new Heros();
		System.out.println("Caractéristique de votre Heros :");
		System.out.println(p1.affichageCaracteristique());
		
		Monstre m1 = new Monstre();
		
		int i = 0;
		while(i!=-1){
		
			System.out.println("Vers o� voulez vous deplacer ?\n(1 = gauche, 2 = bas, 3 = droite, 5 = haut)");
			Scanner scan = new Scanner(System.in);
			int nb = 0;
			try{
			nb = scan.nextInt();
			}catch (InputMismatchException e){
				System.out.println("Rentrer un autre chiffre");
			}

			switch (nb){
			case 5: c1.deplacerHaut();

		
				/*System.out.println("D�but du combat...");
				while(p1.getVie() > 0 && m1.getVie() > 0 ){
					System.out.println("Caract�ristique de l'adversaire :");
					System.out.println(m1.toString());
					System.out.println("Vos caract�ristiques : ");
					System.out.println(p1.toString());
					System.out.println("Vous lancer une attaque !");
					m1.setVie(m1.getVie() - p1.attaquer()); 
					System.out.println("Vous vous faite attaquer !");
					p1.setVie(p1.getVie() - m1.attaquer());
					
						for(int j = 0; j < 1; j++){
							System.out.println("\n  \n");
						}
				}
				System.out.println("Fin du combat...");*/
			break;
			case 2: c1.deplacerBas();

			break;
			case 1: c1.deplacerGauche();

			break;
			case 3: c1.deplacerDroite();
			break;
			default: System.out.println("mauvais chiffre");
			}
			
			i++;
		}
	}
}
