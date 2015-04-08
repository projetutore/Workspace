package jobs;

import java.util.Random;
import java.util.Scanner;


public class Combat {
	
	public Combat(Heros heros, Monstre monstre){
		// initialisation du nombre de tour pour le bonus d'Experience
		int nbtour; 
		for(nbtour = 1; (monstre.getVie()>0 && heros.getVie()>0) ; nbtour++){
			actionJoueur(heros, monstre);
		}
		
	}
	
	public void actionJoueur(Heros heros, Monstre monstre){
		System.out.println(heros.getPa());
		System.out.println("Que souhaitez vous que votre personnage fasse? \n1- Attaquer \n2- Defendre \n3- Arcane \n4- Enchainement ");
			@SuppressWarnings("resource")
			Scanner choix = new Scanner(System.in);
			int action = choix.nextInt();
			switch(action){
			case 1:
				int degats = calculDegats(heros, monstre);
				if (degats > 0){
					System.out.println("Vous infligez " + degats + " � " + monstre.getNom());
				}
				heros.setPa(heros.getPa()-1);
				break;
			case 2:
				heros.defense();
				System.out.println("Votre personnage se d�fend");	
				break;
			case 3:
				for(Arcane i : heros.getTabArcaneHeros())
					System.out.println(i);
				action = choix.nextInt();
				switch(action){
				}
				break;
			case 4: 
				
			}
	}

	
/*	public int deroulement(Heros h, Personnage y){
		int nbtour = 0; // initialisation du nombre de tour qui permet un bonus d'xp
		for(nbtour = 1; (monstre.getVie()>0 && heros.getVie()>0); nbtour++){
			System.out.println(heros.getPa());
			
			switch (action){
			
			case 1: // si le joueur tape 1, il attaque l'ennemi.
				int degatSubitAttaque = calculDegats(heros,y);
				monstre.setVie(monstre.getVie()-degatSubitAttaque);
				System.out.println("Votre personnage attaque et retire "+ degatSubitAttaque+" de vie � "+monstre.getNom() + " " + (monstre.getVie()));
				y.getVie();
				System.out.println("Tour :" + nbtour+ " ");
				heros.setPa(heros.getPa()-1);// jusqu'� ici = fonction tour joueur
				if(monstre.getVie() <0)
					break;
				int degatSubitDefense = calculDegats(y,heros);
				heros.setVie(heros.getVie()-degatSubitDefense);
				System.out.println("Votre personnage est attaqu�, il perd"+ degatSubitDefense+" de vie "+heros.getNom() + " " + ( heros.getVie() ) );
				break;
				
			case 2: //si le joueur tape 2, il se prot�ge du prochain coup adverse, de plus, il r�cup�re 1PA
				heros.setConstitution(((30*heros.getConstitution())/100)+heros.getConstitution());
				degatSubitDefense = calculDegats(y,heros);
				heros.setVie(heros.getVie()-degatSubitDefense);
				System.out.println("\nVotre personnage est attaqu�, il perd"+ degatSubitDefense+" de vie "+heros.getNom() + " " + ( heros.getVie() ) );
				heros.setConstitution(h.getConstitution());
				break;
				
			case 3:/*en tapant 3, le joueur s'appr�te � lancer un de ses arcanes contenues 
			dans la liste des sorts, il  a de nouveau un sort � selectionner.
				for(Sort i : h.getTabSortHeros())
					System.out.println(i);
				action = choix.nextInt();
				switch(action){
				}
				break;
				
			case 4:
				this.Enchainement(heros, monstre);
				heros.setPa(heros.getPa() -1 );
				break;
			}
			
		if (heros.getPa()<h.getPa())
			heros.setPa(heros.getPa()+1);

		}
		System.out.println(nbtour);
		if(heros.getVie()<0){
			System.out.println("Vous avez perdu, game over!");
			return 0;
		}
		h.gainExperience(calculExperience(nbtour, 40));
		System.out.println("Votre personnage a gagn� 40 exp�rience son exp�rience est � present de " + h.getExperience());
		return 1;
	}*/

/*
 * La fonction qui calcule les d�g�ts prend en compte deux personnages.
 * Le personnage p1 tire un d� de 20 qui d�termine le pourcentage de force en + que poss�dera son attaque
 * Le personnage p2 tire �galement un d� de 20 qui determine le pourcentage de Constitution en + que poss�dera sa d�fense.
 * De plus, un d� de 20 est �galement tir� pour savoir si le personnage fera un coup critique.
 * Dans le cas o� la d�fense du p2 est sup�rieur � celle du p1, la fonction retourne 0, dans le cas contraire,
 * les d�gats sont ceux d'attAleatoire.
 */
	public int calculDegats(Personnage p1, Personnage p2){
		// le personnage p1 est celui qui attaque, le p2 celui qui defend. 
		Random random = new Random(); 
		int rand = random.nextInt(21);
		rand+=10; 
		double attAleatoire = (rand * p1.getForce() ) /100 ; // de 10 a 30%
		rand = random.nextInt(21)+10;
		double defenseAleatoire = (rand * p2.getConstitution()) / 100; // de 10 a 30%
		System.out.println(defenseAleatoire);
		System.out.println(attAleatoire);
		int coupCritique = random.nextInt(20)+1;	
		System.out.println(coupCritique);

		if (defenseAleatoire > p1.getForce()+attAleatoire){
			System.out.println("Ce coup est inneficace " + p2.getNom() + " n'a perdu aucun points de vie");
			return 0;
		}
		else if(coupCritique == 1){
			System.out.println("Coup critique!");
			return (int) ((int) ((p1.getForce())+attAleatoire)*2-(p2.getConstitution()+defenseAleatoire));
		}
		return (int) ((int) ((p1.getForce())+attAleatoire)-(p2.getConstitution()+defenseAleatoire)) ;
	}
	
/*
 * La fonction defense augmente la constitution du personnage de 30%	
 */
	
	public void defense(Personnage p){
		p.setConstitution( p.getConstitution() + (30*p.getConstitution() / 100 ));
	}
/*	public void Enchainement(Personnage p1, Personnage p2){
		int enchainementContinu =0;
		while(p1.getPa()>0){
			System.out.println("Que sera donc votre enchainement? 1-Attaquer");
			@SuppressWarnings("resource")
			Scanner choix = new Scanner(System.in);
			int action = choix.nextInt();
			switch (action){
			case 0:
				return;
			case 1:
				int degatSubitAttaque = calculDegats(p1,p2);
				p2.setVie(p2.getVie()-degatSubitAttaque);
				System.out.println("Votre personnage attaque et retire "+ degatSubitAttaque+" de vie � "+p2.getNom() + " " + (p2.getVie()));
				p2.getVie();
				p1.setPa(p1.getPa()-1+enchainementContinu);
				System.out.println(p1.getPa());
				enchainementContinu--;
				break;
			}
		}
	}*/
	
	public void calculPa(Personnage p){
	}
	
	
	public int calculExperience(int nbtour, int experience){
		return 2*experience - bonusExperience(nbtour-1, experience);
	}
	
	
	public int bonusExperience(int nbtour, int experience){
		int experienceGagnee = (nbtour * experience)/10;
		if (experienceGagnee>experience){
			return experience;
		}
			return experienceGagnee;
	}
	
	public static void main(String[] args) {
		Effet brulure= new Effet("Brulure", 5); 
		Effet estocadeDemoniaque = new Effet("Estocade Demoniaque", 10);
		
	}

}
