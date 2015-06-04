package combat;

import java.util.InputMismatchException;
import java.util.Scanner;

import jobs.Arcane;
import jobs.Heros;
import jobs.Personnage;

public class Combat {
	public Arcane listeArcane;
	
	public void Arcane(Personnage p1, Personnage p2) {
	    	

			int i = 0;
			try{
				if(p1 instanceof Heros)
	    		for(Arcane a : ((Heros) p1).getTabArcaneHeros()){
	    				System.out.println(i+ " "+ a.getNomArcane()+ " PA: " + a.getCoutPA());
	   				 	i++;
	    		}
	    		
	    		
			}catch(NullPointerException e){
	    	}catch(InputMismatchException e){
	    	}
			
			int c=0;
/*
			do{									
		 		System.out.println("Choisissez un sort existant");

	    			Scanner choix = new Scanner(System.in);
	    			c=choix.nextInt();
				 	}while(c>i)
				 	*/
	    }

}
