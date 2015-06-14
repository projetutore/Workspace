package CalculEtCombat;

import java.util.ArrayList;
import java.util.Random;

import jobs.Heros;
import jobs.Monstre;
import jobs.Personnage;
import jobs.PersonnageCarException;

public class Calcul {

	/**
	 * La fonction qui calcule les degats prend en compte deux personnages.
	 * 
	 */
	    public static int calculDegats(Personnage p1, Personnage p2) {
	        // le personnage p1 est celui qui attaque, le p2 celui qui defend. 
	    	if(p2.getVie()<= 0){
	    		if (p2.getVie()<=0){
					return 0;
				}
	    	}
	    	
	    	Random lancer_de_des = new Random();
	    	Random xpenplus = new Random();
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
		    		degats += (lancer_de_des.nextInt(8)+1)+(p1.getDegats().getReste());
		    	}
		    			
		    	for(int j = 1; j<=p2.getDefense().getDes(); j++){
		    		if(p1 instanceof Heros){
		    			Heros h = (Heros) p1;
		    		/**
		    		 * Dans le cas o� le personnage est un Heros �quip� d'une Lance
		    		 * le r�sultat du lancer de d�s de d�fense de p2 est /3 et le resultat du reste est �galement /3
		    		 */
		    			if(h.getMainDroite().typeArme().equals( "Lance"))
				    		defense += (lancer_de_des.nextInt(8)+1)/3+(p2.getEsquive().getReste());	
				    	else
				    		defense += (lancer_de_des.nextInt(8)+1)+(p2.getEsquive().getReste());
		     			}
		    		
		    		else{
		    			defense += (lancer_de_des.nextInt(8)+1)+(p2.getEsquive().getReste()); 
		    		}
		    	}

		
		    	degatsInfliges = degats-defense;	

	    		if(p1 instanceof Heros){
	    			Heros h = (Heros) p1;
	    			Monstre mon = (Monstre) p2;
	    			int xp = 0;
	    			if(h.getMainDroite().getClass().getSimpleName().equals( "EpeeLourde")){
	    				degatsInfliges *=2;
	    			}
	    			if(degatsInfliges<=0){
	    	            System.out.println(h.getNom() + " Tente d'attaquer " + mon.getNom() + ". Ce coup ne fait aucun d�g�t " + mon.getNom() + " n'a perdu aucun points de vie");
	    			}
	    			else{	    
	    				mon.regainDeVie(-degatsInfliges);
	    				System.out.println( h.getNom() + " inflige " + degatsInfliges+ " � " + mon.getNom());
	    				if (mon.getVie()<=0){
	    					System.out.println(mon.getNom() + " est mort et a fait tomber un objet");
	    					xp = mon.getExperienceDonnee();

	    				}
	    				else{
	    					System.out.println("\nIl lui reste � present " + mon.getVie());
	    					xp = mon.getExperienceDonnee()/5+xpenplus.nextInt(mon.getExperienceDonnee()/5);
	    					h.gainExperience(xp);
	    				}
	    			}
					h.gainExperience(xp);
	    			System.out.println(h.getNom() + " a gagn� avec ce coup " + xp);
	    		}
	    		
	    		if(p1 instanceof Monstre)
		    	System.out.println("Un deux!");

	    		if(p1 instanceof Monstre){
	    			Monstre mon = (Monstre) p1;
	    			Heros h = (Heros) p2;
	    			if(degatsInfliges <= 0 ){
	    				System.out.println(h.getNom() +" s'est prot�g� de l'attaque de "+mon.getNom() + ". Cette attaque ne lui fait par cons�quent aucun d�g�ts.");
	    			}
	    			else{
	    				h.regainDeVie(-degatsInfliges);
	    				System.out.println( mon.getNom() + " inflige un coup � "+ h.getNom() + ". La vie de " + h.getNom() + " est � pr�sent de " + h.getVie());
	    			}
	    			
	    			if(h.getVie() <= 0){
	    				System.out.println("Olala, il semblerait que " + h.getNom() + " soit mort(e)");
	    			}
	    		}
	    		return degatsInfliges;
	    	}		
	    	
	    	else{
	    		System.out.println(p2.getNom() + " esquive l'attaque de "+p1.getNom());
	    	}
	    	return 0;
	    }
	    
}
