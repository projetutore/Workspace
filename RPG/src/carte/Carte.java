package carte;

import java.util.*;

public class Carte {
	
	//Attrubuts
	private int nbLig;
	private int nbCol;
	private char [][] grille;
	
	//Constructeur
	public Carte(int n, int p){
		nbLig = n;
		nbCol = p;
		grille = new char [nbLig][nbCol];
		
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j<nbCol; j++){
				
				grille[i][j] = '.';
				
			}
		}
	}
	//Accesseurs
	public char getCase(int l, int c){
		return grille[l-1][c-1];
	}
	
	//Methodes
	public void Afficher(){
		System.out.println();
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j<nbCol; j++){
				
				System.out.print(" | " + grille[i][j]);
				
			}
			System.out.println(" | ");
		}
		System.out.println();
	}
	
	public void placer(int l, int c, char t ){
		
		l = l-1;
		c = c-1;
		//on teste si on se trouve bien sur la grille 
		if (l<0 || c<0 || l>nbLig || c>nbCol){
			System.out.print("ERREUR de placement !");
			return;
		}
		if (grille[l][c] == '.'){
			grille[l][c] = t;
		}
		else {
			System.out.print("ERREUR, cet zone n'est pas vide !");

		}
			
		
	}
	//Deplacer
	public int deplacerHaut(){
		char tmp;
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j<nbCol; j++){
			
				if(grille[i][j] == 'J'){//on cherche le joueur
					if(i-1 >= 0 && grille[i-1][j] == '.' ){//on teste la position
						tmp = grille[i][j]; //On copie le perso
						grille[i][j] = '.';//on vide la case 
						grille[i-1][j] = tmp;//on deplace le perso
						return 1;
					}
					if (i-1 >= 0 && grille[i-1][j] == 'M'){
						tmp = grille[i][j]; 
						grille[i][j] = '.'; 
						grille[i-1][j] = tmp;
						return 2;
					}		
				}
			}		
		}
		return 0;
	}
	
	public void deplacerBas(){
		char tmp;
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j<nbCol; j++){
			
				if(grille[i][j] == 'J'){//on cherche le joueur
					if(i+1 <= nbLig && grille[i+1][j] =='.' ){//on teste la position
						tmp = grille[i][j]; //On copie le perso
						grille[i][j] = '.';//on vide la case 
						grille[i+1][j] = tmp;//on deplace le perso
						return;
					}		
				}
			}		
		}
	
	}
	
	public void deplacerGauche(){
		char tmp;
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j<nbCol; j++){
			
				if(grille[i][j] == 'J' && grille[i][j-1] == '.'){//on cherche le joueur
					if(i-1 >= 0){//on teste la position
						tmp = grille[i][j]; //On copie le perso
						grille[i][j] = '.';//on vide la case 
						grille[i][j-1] = tmp;//on deplace le perso
				
					}		
				}
			}		
		}
	
	}
	
	public void deplacerDroite(){
		char tmp;
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j<nbCol; j++){
			
				if(grille[i][j] == 'J' && grille[i][j+1] == '.' ){//on cherche le joueur
					if(i+1 <= nbCol){//on teste la position
						tmp = grille[i][j]; //On copie le perso
						grille[i][j] = '.';//on vide la case 
						grille[i][j+1] = tmp;//on deplace le perso
						break;
					}		
				}
			}		
		}
	
	}
}
