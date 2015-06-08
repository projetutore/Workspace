package carte;

import java.io.Serializable;
import java.util.*;

import Objets.CreationArme;
import Objets.ExceptionArme;
import Objets.Objet;
import sauvegarde.SauvegardeJeu;
import jobs.Heros;
import jobs.Monstre;
import jobs.PersonnageCarException;

public class Carte implements Serializable{
	
	//Attrubuts
	private int nbLig;
	private int nbCol;
	private Elements [][] grille;
	private Elements s = new PtsCarte(".");
	private Elements mur = new PtsCarte("#");
	private ArrayList<Monstre> listeMonstre; 
	private ArrayList<? extends Objet> listeObjet;
	//Constructeur
	public Carte(int n, int p){
		nbLig = n;
		nbCol = p;
		grille = new Elements [nbLig][nbCol];
		
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j<nbCol; j++){
				
				grille[i][j] = s;
				
			}
		}
		for(int i = 0 ; i<((nbLig*nbCol)/5); i++){
			this.placementAleatoire();
			i++;
		}

	}
	//Accesseurs
	public Elements getCase(int l, int c){
		return grille[l-1][c-1];
	}
	
	public int getnbLig(){
		return nbLig;
	}
	
	public int getnbCol(){
		return nbCol;
	}
	public Elements[][] getGrille() {
		return grille;
	}
	//Methodes
	public String Afficher(){
		System.out.println();
		String s = "";
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j<nbCol; j++){
				
				s += " | " + grille[i][j];
				
			}
			s += "|\n";
		}
		return s;
	}
	
	public void placer(int l, int c, Elements t ){
		
		l = l-1;
		c = c-1;
		//on teste si on se trouve bien sur la grille 
		if (l<0 || c<0 || l>nbLig || c>nbCol){
			System.out.print("ERREUR de placement !");
			return;
		}
		if (grille[l][c] ==  s ){
			grille[l][c] =  t;
		}
		else {
			System.out.print("ERREUR, cet zone n'est pas s !");

		}
			
		
	}
	//Deplacer
	public int deplacerHaut(){
		Elements tmp;
		try{
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j<nbCol; j++){
			
				if(grille[i][j] instanceof Heros){//on cherche le joueur
					if(i-1 >= 0 && grille[i-1][j] == s ){//on teste la position
						tmp = grille[i][j]; //On copie le perso
						grille[i][j] = s;//on s la case 
						grille[i-1][j] = tmp;//on deplace le perso
						return 1;
					}
					else if(i-1 <= nbLig && grille[i-1][j] instanceof Objet ){//on teste la position
							((Heros) grille[i][j]).ajoutObjet((Objet) grille[i-1][j]);
							tmp = grille[i][j]; 
							grille[i-1][j] = tmp;
							grille[i][j] = s;
							return 3;
					}
					if (i-1 >= 0 && grille[i-1][j] instanceof Monstre){
						tmp = grille[i][j]; 
						grille[i][j] = s; 
						grille[i-1][j] = tmp;
						System.out.println(this.Afficher());
						return 2;
					}		
				}
			}		
		}
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Impossible de se deplacer ici");
		}
	
		return 0;
	}
	
	public void deplacerBas(){
		Elements tmp;
		try{
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j<nbCol; j++){
			
			
				if(grille[i][j] instanceof Heros){//on cherche le joueur
					if(i+1 <= nbLig && grille[i+1][j] == s ){//on teste la position
						tmp = grille[i][j]; //On copie le perso
						grille[i+1][j] = tmp;//on deplace le perso
						grille[i][j] = s;//on s la case 
						return;
					}
					else if(i+1 <= nbLig && grille[i+1][j] instanceof Objet ){//on teste la position
							((Heros) grille[i][j]).ajoutObjet((Objet) grille[i+1][j]);
							tmp = grille[i][j]; 
							grille[i+1][j] = tmp;
							grille[i][j] = s;
							return;
							}
					}		
				}
			}		
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Impossible de se deplacer ici");
		}
	
	}
	
	public void deplacerGauche(){
		Elements tmp;
		try{
		
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j<nbCol; j++){
			
				if(grille[i][j] instanceof Heros && grille[i][j-1].toString().equals("O")){
					((Heros) grille[i][j]).ajoutObjet((Objet) grille[i][j-1]);
					tmp = grille[i][j];
					grille[i][j]= s;
					grille[i][j-1] = tmp;	
				}
				else if(grille[i][j] instanceof Heros && grille[i][j-1] == s){//on cherche le joueur
					if(i-1 >= 0){//on teste la position
						tmp = grille[i][j]; //On copie le perso
						grille[i][j] = s;//on s la case 
						grille[i][j-1] = tmp;//on deplace le perso
					}
			
						
				}
			}		
		}
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Impossible de se deplacer ici");
		}
	
	}
	
	public void deplacerDroite(){
		Elements tmp;
		try{
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j<nbCol; j++){
				
				if(grille[i][j] instanceof Heros && grille[i][j+1] instanceof Objet){
					((Heros) grille[i][j]).ajoutObjet((Objet) grille[i][j+1]);
					tmp = grille[i][j];
					grille[i][j]= s;
					grille[i][j+1] = tmp;	
					return;
				}
				else if(grille[i][j] instanceof Heros && grille[i][j+1] == s ){//on cherche le joueur
					if(i+1 <= nbCol){//on teste la position
						tmp = grille[i][j]; //On copie le perso
						grille[i][j] = s;//on s la case 
						grille[i][j+1] = tmp;//on deplace le perso

						return;
					}		
				}
			}		
		}
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Impossible de se deplacer ici");
		}
	
	}
	public void deplacement(){
		int i = 0;
		while(i!=-1){
		
		System.out.println("Vers où voulez vous deplacer ?\n(1 = gauche, 2 = bas, 3 = droite, 5 = haut)");
		Scanner scan = new Scanner(System.in);
		int nb = 0;
		try{
		nb = scan.nextInt();
		}catch (InputMismatchException e){
			System.out.println("Rentrer un autre chiffre");
		}

		switch (nb){
		case 5: this.deplacerHaut();

	
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
		case 2: this.deplacerBas();

		break;
		case 1: this.deplacerGauche();

		break;
		case 3: this.deplacerDroite();
		break;
		case 8: 
			
			break;
		default: System.out.println("mauvais chiffre");
		}
		
		System.out.println(this.Afficher());

		i++;
		}
	}

	public void placementAleatoire(){
		try {
			listeMonstre = Monstre.ajoutMonstreType();
		} catch (PersonnageCarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			listeObjet = CreationArme.creationEpeeLegeres();
		} catch (ExceptionArme e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Random alea = new Random();
		int aleatoireX = alea.nextInt(this.nbLig);
		int aleatoireY = alea.nextInt(this.nbCol);
		int choix = alea.nextInt(3);
		int objet_tire = alea.nextInt(listeObjet.size());
		int monstre_tire = alea.nextInt(listeMonstre.size());
		if(this.grille[aleatoireX][aleatoireY] == s){
			switch (choix){
			case 0: grille[aleatoireX][aleatoireY] =  listeMonstre.get(monstre_tire);
					break;
			case 1: grille[aleatoireX][aleatoireY] = listeObjet.get(objet_tire);
					break;
			case 2: grille[aleatoireX][aleatoireY] = mur;
					break;
			}
		}
		
	}
	
	public String toString() {
		return "Carte "+ nbLig + "*" + nbCol;
	}

}
