package carte;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import jobs.Heros;
import jobs.Monstre;
import jobs.PersonnageCarException;
import Objets.CreationArme;
import Objets.ExceptionArme;
import Objets.Interface.Objet;

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
	public int deplacerHaut(Elements el){
		Elements tmp;
		try{
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j<nbCol; j++){
			
				if(grille[i][j].equals(el)){//on cherche le joueur
					if(i-1 >= 0 && grille[i-1][j] == s ){//on teste la position
					//	tmp = grille[i][j]; //On copie le perso
						grille[i][j] = s;//on s la case 
						grille[i-1][j] = el;//on deplace le perso
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
	
	public void deplacerBas(Elements el){
		Elements tmp;
		try{
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j<nbCol; j++){
			
			
				if(grille[i][j].equals(el)){//on cherche le joueur
					if(i+1 <= nbLig && grille[i+1][j] == s ){//on teste la position
					//	tmp = grille[i][j]; //On copie le perso
						grille[i+1][j] = el;//on deplace le perso
						grille[i][j] = s;//on s la case 
						return;
					}
					else if(i+1 <= nbLig && grille[i+1][j] instanceof Objet ){//on teste la position
							((Heros) el).ajoutObjet((Objet) grille[i+1][j]);
							tmp = grille[i][j]; 
							grille[i+1][j] = el;//on deplace le perso
							grille[i][j] = s;//on s la case 
							return;
							}
					}		
				}
			}		
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Impossible de se deplacer ici");
		}
	
	}
	
	public void deplacerGauche(Elements el){
		Elements tmp;
		try{
		
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j<nbCol; j++){
			
				if(grille[i][j].equals(el) && grille[i][j-1] instanceof Objet){
					((Heros) el).ajoutObjet((Objet) grille[i][j-1]);
					//tmp = grille[i][j];
					grille[i][j]= s;
					grille[i][j-1] = el;	
				}
				else if(grille[i][j] instanceof Heros && grille[i][j-1] == s){//on cherche le joueur
					if(i-1 >= 0){//on teste la position
						tmp = grille[i][j]; //On copie le perso
						grille[i][j]= s;
						grille[i][j-1] = el;
					}
			
						
				}
			}		
		}
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Impossible de se deplacer ici");
		}
	
	}
	
	public void deplacerDroite(Elements el){
		Elements tmp;
		try{
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j<nbCol; j++){
				
				if(grille[i][j].equals(el) && grille[i][j+1] instanceof Objet){
					((Heros) el).ajoutObjet((Objet) grille[i][j+1]);
					//tmp = el;
					grille[i][j]= s;
					grille[i][j+1] = el;	
					return;
				}
				if(grille[i][j].equals(el) && grille[i][j+1] == s ){//on cherche le joueur
					if(i+1 <= nbCol){//on teste la position
				//		tmp = el; //On copie le perso
						grille[i][j] = s;//on s la case 
						grille[i][j+1] = el;//on deplace le perso

						return;
					}		
				}
				else if(el instanceof Monstre && grille[i][j].equals(el) && grille[i][j+1] == s){
					if(i+1 <= nbCol){//on teste la position
						//tmp = grille[i][j]; //On copie le perso
						grille[i][j] = s;//on s la case 
						grille[i][j+1] = el;//on deplace le perso

						return;
					}
				}
			}		
		}
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Impossible de se deplacer ici");
		}
	
	}
	public void deplacement(Elements x){
		System.out.println("Vers où voulez vous deplacer ?\n(1 = gauche, 2 = bas, 3 = droite, 5 = haut)");
		Scanner scan = new Scanner(System.in);
		int nb = 0;
		try{
		nb = scan.nextInt();
		}catch (InputMismatchException e){
			System.out.println("Rentrer un autre chiffre");
		}

		switch (nb){
		case 5: this.deplacerHaut(x);

	
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
		case 2: this.deplacerBas(x);

		break;
		case 1: this.deplacerGauche(x);

		break;
		case 3: this.deplacerDroite(x);
		break;
		case 8: 
			
			break;
		default: System.out.println("mauvais chiffre");
		}
		
		System.out.println(this.Afficher());
	}
	
	public void attaquer(Heros p, int numMain){
		ArrayList <Monstre> monstre_a_attaquer = new ArrayList<Monstre>();
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j<nbCol; j++){
				if(grille[i][j].equals(p)){
					switch(numMain){
					case 1:
						for(int k = 0; k <=  p.getMainDroite().getPortee(); k++){
							try{
								if (grille[i+k][j] instanceof Monstre && monstre_a_attaquer.contains(grille[i+k][j]) ==false){
									monstre_a_attaquer.add((Monstre) grille[i+k][j] );
								}
								else if(grille[i-k][j] instanceof Monstre && monstre_a_attaquer.contains(grille[i-k][j]) ==false){
									monstre_a_attaquer.add((Monstre) grille[i-k][j]);
								}
							
							}catch(ArrayIndexOutOfBoundsException e){}
							
						for(int l = 0; l<= p.getMainDroite().getPortee(); l++){
							try{
								if (grille[i][j+l] instanceof Monstre && monstre_a_attaquer.contains(grille[i][j+l]) == false){
									monstre_a_attaquer.add((Monstre) grille[i][j+l]);
								}
								else if(grille[i][j-l] instanceof Monstre && monstre_a_attaquer.contains(grille[i][j-l]) == false){
									monstre_a_attaquer.add((Monstre) grille[i][j-l]);
								}
							}catch(ArrayIndexOutOfBoundsException e){}
						}
					}	
					break;

					case 2:
						for(int k = 0; k <=  p.getMainGauche().getPortee(); k++){
							try{
								if (grille[i+k][j] instanceof Monstre && monstre_a_attaquer.contains(grille[i+k][j]) ==false){
									monstre_a_attaquer.add((Monstre) grille[i+k][j] );
								}
								else if(grille[i-k][j] instanceof Monstre && monstre_a_attaquer.contains(grille[i-k][j]) ==false){
									monstre_a_attaquer.add((Monstre) grille[i-k][j]);
								}
							}catch(ArrayIndexOutOfBoundsException e){}
							
						for(int l = 0; l<= p.getMainGauche().getPortee(); l++){
								try{
									if (grille[i][j+l] instanceof Monstre && monstre_a_attaquer.contains(grille[i][j+l]) == false){
										monstre_a_attaquer.add((Monstre) grille[i][j+l]);
									}
									else if(grille[i][j-l] instanceof Monstre && monstre_a_attaquer.contains(grille[i][j-l]) == false){
										monstre_a_attaquer.add((Monstre) grille[i][j-l]);
									}
							
								}catch(ArrayIndexOutOfBoundsException e){}
							}
						}
					break;	
					}
				}
			}
		}
		
		if(monstre_a_attaquer.isEmpty()==false){
			System.out.println("Quel monstre souhaitez-vous attaquer?" );
			Monstre.afficheCollectionMonstreAttaque(monstre_a_attaquer);
			Scanner scanner = new Scanner(System.in);
			int choix = 0;
			try{
				choix = scanner.nextInt();
			while(choix<0 && choix >monstre_a_attaquer.size()){
				System.out.println("Veuillez saisir un chiffre entre 0(annuler l'attaque) et "+ monstre_a_attaquer.size());
				try{
					choix = scanner.nextInt();
				}catch(ArrayIndexOutOfBoundsException e){
					System.out.println("Veuillez saisir un chiffre entre 0(annuler l'attaque) et "+ monstre_a_attaquer.size());
				}
			}
			try{
			if(numMain == 1)
				p.getMainDroite().attaquer(p, monstre_a_attaquer.get(choix-1));		
			else
				p.getMainGauche().attaquer(p, monstre_a_attaquer.get(choix-1));
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.println("Veuillez saisir un chiffre entre 0(annuler l'attaque) et "+ monstre_a_attaquer.size());
			}
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.println("Veuillez saisir un chiffre entre 0(annuler l'attaque) et "+ monstre_a_attaquer.size());
			}
			
			if(monstre_a_attaquer.get(choix-1).getVie()<0){
				for(int i = 0; i < nbLig; i++){
					for(int j = 0; j<nbCol; j++){
						if(grille[i][j].equals(monstre_a_attaquer.get(choix-1))){
							grille[i][j] = s;
						}
					}
				}
			}
		}
		monstre_a_attaquer.clear();	
	}

	
	/*public void choix(){
		int i = 0;
		while(i!=-1){
		
		System.out.println("Que souhaitez-vous faire ?\n(1 = deplacer, 2 = attaquer, 3 = voir l'inventaire)");
		Scanner scan = new Scanner(System.in);
		int nb = 0;
		try{
		nb = scan.nextInt();
		}catch (InputMismatchException e){
			System.out.println("Rentrer un autre chiffre");
		}

		switch (nb){
		case 1: this.deplacement(this);
		case 2: 
		System.out.println("Avec quelle mainsouhaitez vous attaquer? ")	
			this.attaquer(p, numMain);
		}
	}
	}*/
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
		if(this.grille[aleatoireX][aleatoireY].equals(s)){
			switch (choix){
			case 0: grille[aleatoireX][aleatoireY] =  new Monstre(listeMonstre.get(monstre_tire));
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
