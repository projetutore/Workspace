package carte;

import java.util.Random;

public class Personnage {
	
	//Attributs
	
	private int vie;
	private int xp;
	private int force;
	
	//Constructeurs
	
	public Personnage (){
		vie = 100;
		xp = 0;
		force = 10;
	}
	public Personnage (int v, int x, int f){
		vie = v;
		xp = x;
		force = f;
	}
	
	//Accesseurs

	public int getVie() {
		return vie;
	}
	public int getXp() {
		return xp;
	}
	
	public int getForce() {
		return force;
	}
	
	
	//Setters
	
	public void setVie(int v) {
		this.vie = v;
		if (vie <0 )
			vie = 0;
	}
	
	public void setXp(int x) {
		this.xp = x;
	}
	
	public void setForce(int f) {
		this.force = f;
	}
	
	//Service methode permettant de réaliser une actions 
	
	public void seReposer(int i){ // 1, 2 min
		/*Controle des parm*/
		if (i<1){
			i = 1;
		}
		if (i>2){
			i=3;
		}
		
		if (i == 1){ // 5 pts de vie en plus 
			vie +=5;
			if(vie>100)
				vie =100;
		}
		if (i == 2){ // 5 pts de vie en plus 
			vie +=10;
			if(vie>100)
				vie =100;
		}
			
	}
	
	public int attaquer(){ //Toute attaque renvoie 5pts de dégats
		Random rand = new Random();
		int d = rand.nextInt(force)+5;
		return d;
	}
	
	//Surchage
	
	public String toString(){
		return "Vie du personnage = " + vie +"\nXp = "  + xp+ "\nForce = "+force;
	}
	
}
