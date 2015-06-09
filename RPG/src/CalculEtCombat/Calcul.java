package CalculEtCombat;

import java.util.ArrayList;
import java.util.Random;

import jobs.Heros;
import jobs.Monstre;
import jobs.Personnage;
import jobs.PersonnageCarException;

public class Calcul {

	/*
	 * La fonction qui calcule les d�g�ts prend en compte deux personnages.
	 * Le personnage p1 tire un d� de 20 qui d�termine le pourcentage de force en + que poss�dera son attaque
	 * Le personnage p2 tire �galement un d� de 20 qui determine le pourcentage de Constitution en + que poss�dera sa d�fense.
	 * De plus, un d� de 20 est �galement tir� pour savoir si le personnage fera un coup critique.
	 * Dans le cas o� la d�fense du p2 est sup�rieur � celle du p1, la fonction retourne 0, dans le cas contraire,
	 * les d�gats sont ceux d'attAleatoire.
	 */
	    public static void calculDegats(Personnage p1, Personnage p2) {
	        // le personnage p1 est celui qui attaque, le p2 celui qui defend. 
	    	Random lancer_de_des = new Random();
	    	int touche = 0;
	    	int esquive = 0;
	    	for(int i = 1; i<=p1.getAttaque().getDes(); i++){
	    		touche += (lancer_de_des.nextInt(8)+1)+(p1.getAttaque().getReste());
	    		}
	    			
	    	for(int j = 1; j<=p2.getEsquive().getDes(); j++){
	    			esquive += (lancer_de_des.nextInt(8)+1)+(p2.getEsquive().getReste());	
	    	}

	    	if(touche>=esquive){
	    		int degats = 0;
	    		int defense = 0;
	    		int degatsInfliges = 0;
	    		for(int i = 1; i<=p1.getDegats().getDes(); i++){
		    		degats += (lancer_de_des.nextInt(8)+1)+p1.getDegats().getReste();
		    			System.out.println(degats + "="+i);;
		    		}
		    			
		    	for(int j = 1; j<=p2.getDefense().getDes(); j++){
		    			defense += (lancer_de_des.nextInt(8)+1)+p2.getEsquive().getReste();
		    			System.out.println(defense + "=" + j);	
		    	}
	    		
		    	degatsInfliges = degats-defense;
	    		if(p1 instanceof Heros){
	    			if(degatsInfliges<=0){
	    	            System.out.println(p1.getNom() + " Tente d'attaquer " + p2.getNom() + ". Ce coup ne fait aucun d�g�t " + p2.getNom() + " n'a perdu aucun points de vie");
	    			}
	    			else{	    
	    				p2.setVie(p2.getVie()-degatsInfliges);
	    				System.out.println( p1.getNom() + " inflige " + degatsInfliges+ " � " + p2.getNom()+
	    	                    "\nIl lui reste � present " + p2.getVie());
	    			}
	    		}
	    	}
	    	if(p2.getVie()<=0){
	    		System.out.println(p2.getNom() + " est mort");

	    		p2=null;
	    		
	    	}
	    }

	    	/*
	        Random random = new Random(); 
	        int rand = random.nextInt(21);
	        int coup = 0;
	        rand+=10; 
	        double attAleatoire = (rand * p1.getForce() ) /100 ; // de 10 a 30%
	        rand = random.nextInt(21)+10;
	        double defenseAleatoire = (rand * p2.getConstitution()) / 100; // de 10 a 30%
	        int coupCritique = random.nextInt(20)+1;    
	        coup = (int) ((int) ((p1.getForce())+attAleatoire)-(p2.getConstitution()+defenseAleatoire));
	        
	        /*
	         * Ici, on verifie si le personnage est de type heros et si son job est LanceRouge, dans ce cas
	         * on effectue Percer qui ignore 1/3 de la constitution adverse.
	         
	        if ((p1 instanceof Heros)){
	            ((Heros) p1).getJob().getNomJob().equals("LanceRouge");
	            coup = (int) (int) ((p1.getForce()+attAleatoire) - ((2/3)*(p2.getConstitution())+defenseAleatoire));
	            p2.setVie(p2.getVie()-coup);
	            return coup;
	        }
	        
	         * Dans le cas contraire, le calcul s'effectue normalement. 
	         */
	    	/*
	        else if (p2.getConstitution()+defenseAleatoire > p1.getForce()+attAleatoire)
	            System.out.println(p1.getNom() + " Tente d'attaquer " + p2.getNom() + ". Ce coup ne fait aucun d�g�t " + p2.getNom() + " n'a perdu aucun points de vie");
	        else if(coupCritique == 1){
	            System.out.println("Coup critique!");
	            coup = (int) ((int) ((p1.getForce())+attAleatoire)-(p2.getConstitution()+defenseAleatoire));
	            p2.setVie(p2.getVie()-coup);
	            return coup;
	        }
	        p2.setVie(p2.getVie()-coup);
	        return coup ;
	        */
		//	return esquive;
	  //  }
	    
	    public static void main(String args[]){
	    	Heros x = Heros.creationPersonnage();
	    	ArrayList <Monstre> listeMonstre = new ArrayList<Monstre>();
			try {
				listeMonstre = Monstre.ajoutMonstreType();
			} catch (PersonnageCarException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Calcul.calculDegats(x, listeMonstre.get(0));
	    }
}
