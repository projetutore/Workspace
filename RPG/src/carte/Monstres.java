package carte;

import java.util.Random;

public class Monstres {
	
	//Attributs
	
	private int vie;
	private int force;
	
	//Constructeurs
	
	public Monstres (){
		vie = 30;
		force = 10;
	}
	public Monstres (int v, int x){
		vie = v;
		force = x;
	}
	
	//Accesseurs

	public int getVie() {
		return vie;
	}
	public int getF() {
		return force;
	}
	
	//Setters
	
	public void setVie(int v) {
		this.vie = v;
		if (vie <0 )
			vie = 0;
	}
	
	public void setF(int x) {
		this.force = x;
	}
	
	
	
	
	public int attaquer(){ //Toute attaque renvoie 5pts de dŽgats
		//return 5;
		Random rand = new Random();
		int d = rand.nextInt(force)+1;
		return d;
	}
	
	//Surchage
	
	public String toString(){
		return "Vie du monstre = " + vie +"\nForce = "  + force;
	}
	
}
