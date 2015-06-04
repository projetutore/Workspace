package carte;

import java.util.*;

import jobs.Heros;
import jobs.Monstre;

public class Carte{
	
	//Attrubuts
	private int nbLig;
	private int nbCol;
	private Object [][] grille;
	private String s = ".";
	private String mur = "#";
	
	//Constructeur
	public Carte(int n, int p){
		nbLig = n;
		nbCol = p;
		grille = new Object [nbLig][nbCol];
		
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j<nbCol; j++){
				
				grille[i][j] = s;
				
			}
		}
	}
	//Accesseurs
	public Object getCase(int l, int c){
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
		Object tmp;
		try{
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j<nbCol; j++){
			
				if(grille[i][j] instanceof Heros){//on cherche le joueur
					if(i-1 >= 0 && grille[i-1][j] == s ){//on teste la position
						tmp = grille[i][j]; //On copie le perso
						grille[i][j] = s;//on s la case 
						grille[i-1][j] = tmp;//on deplace le perso
						this.Afficher();
						return 1;
					}
					if (i-1 >= 0 && grille[i-1][j] instanceof Monstre){
						tmp = grille[i][j]; 
						grille[i][j] = s; 
						grille[i-1][j] = tmp;
						this.Afficher();
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
		Object tmp;
		try{
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j<nbCol; j++){
			
				if(grille[i][j] instanceof Heros){//on cherche le joueur
					if(i+1 <= nbLig && grille[i+1][j] == s ){//on teste la position
						tmp = grille[i][j]; //On copie le perso
						grille[i+1][j] = tmp;//on deplace le perso
						grille[i][j] = s;//on s la case 
						this.Afficher();
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
		Object tmp;
		try{
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j<nbCol; j++){
			
				if(grille[i][j] instanceof Heros && grille[i][j-1] == s){//on cherche le joueur
					if(i-1 >= 0){//on teste la position
						tmp = grille[i][j]; //On copie le perso
						grille[i][j] = s;//on s la case 
						grille[i][j-1] = tmp;//on deplace le perso
						this.Afficher();

					}		
				}
			}		
		}
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Impossible de se deplacer ici");
		}
	
	}
	
	public void deplacerDroite(){
		Object tmp;
		try{
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j<nbCol; j++){
			
				if(grille[i][j] instanceof Heros && grille[i][j+1] == s ){//on cherche le joueur
					if(i+1 <= nbCol){//on teste la position
						tmp = grille[i][j]; //On copie le perso
						grille[i][j] = s;//on s la case 
						grille[i][j+1] = tmp;//on deplace le perso
						this.Afficher();

						break;
					}		
				}
			}		
		}
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Impossible de se deplacer ici");
		}
	
	}
}
