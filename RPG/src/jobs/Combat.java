package jobs;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("5c7f8217-f04a-40a3-9b42-6ed84ff6e0b6")
public class Combat {
    @objid ("7cd3477c-bdc1-417c-8774-ca885ceb71b9")
    public Combat(Heros heros, Monstre monstre) {
        // initialisation du nombre de tour pour le bonus d'Experience
        int nbtour = 0; 
        for(nbtour = 1; (monstre.getVie()>0 && heros.getVie()>0) ; nbtour++){
            do{
                actionJoueur(heros, monstre);
                
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            actionMonstre(monstre, heros);
            resetDefense(monstre);
            resetDefense(heros);
            }while(heros.getPa()>0);
                actionMonstre(monstre, heros);
                resetDefense(monstre);
                resetDefense(heros);
            /* if (heros.getPa()<heros.getMaxPa())
                heros.setPa(heros.getPa()+1); */
            
        }
        int xp = heros.gainExperience(calculExperience(nbtour, monstre.getExperienceDonnee()));
        System.out.println("Votre personnage a gagné " + xp + " expérience son expérience est à present de " + heros.getExperience());
        return;
    }

    @objid ("8a18bf43-bac5-4a41-817f-bb35b95f5c63")
    public void actionJoueur(Heros heros, Monstre monstre) {
        System.out.println("PA = " + heros.getPa());
        System.out.println(heros.getConstitution());
        System.out.println("Que souhaitez vous que votre personnage fasse? \n1- Attaquer \n2- Defendre \n3- Arcane \n4- Enchainement ");
                @SuppressWarnings("resource")
                Scanner choix = new Scanner(System.in);
                int action = choix.nextInt();
                switch(action){
                case 1:
                    attaque(heros, monstre);
                    break;
                case 2:
                    defense(heros);
                    System.out.println("Votre personnage se défend");
                    break;
                case 3:
                    Arcane(heros, monstre);
                    break;
                case 4: 
                    Enchainement(heros, monstre);
                    break;
                }
    }

    @objid ("f24efc6e-89fa-4ab3-96f0-586c583badc6")
    public void actionMonstre(Monstre monstre, Heros heros) {
        if(monstre.attaqueSelonHeros(heros) == 1){
        attaque(monstre, heros);
        }
        else if(monstre.attaqueSelonHeros(heros) == 3){
            explosion(monstre, heros);
        }
    }

/*
 * La fonction qui calcule les dï¿½gï¿½ts prend en compte deux personnages.
 * Le personnage p1 tire un dï¿½ de 20 qui dï¿½termine le pourcentage de force en + que possï¿½dera son attaque
 * Le personnage p2 tire ï¿½galement un dï¿½ de 20 qui determine le pourcentage de Constitution en + que possï¿½dera sa dï¿½fense.
 * De plus, un dï¿½ de 20 est ï¿½galement tirï¿½ pour savoir si le personnage fera un coup critique.
 * Dans le cas oï¿½ la dï¿½fense du p2 est supï¿½rieur ï¿½ celle du p1, la fonction retourne 0, dans le cas contraire,
 * les dï¿½gats sont ceux d'attAleatoire.
 */
    @objid ("045dc1d7-add6-426d-8224-bcd5296287b8")
    public int calculDegats(Personnage p1, Personnage p2) {
        // le personnage p1 est celui qui attaque, le p2 celui qui defend. 
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
         */
        if ((p1 instanceof Heros)){
            ((Heros) p1).getJob().getNomJob().equals("LanceRouge");
            coup = (int) (int) ((p1.getForce()+attAleatoire) - ((2/3)*(p2.getConstitution())+defenseAleatoire));
            p2.setVie(p2.getVie()-coup);
            return coup;
        }
        /*
         * Dans le cas contraire, le calcul s'effectue normalement. 
         */
        else if (p2.getConstitution()+defenseAleatoire > p1.getForce()+attAleatoire)
            System.out.println(p1.getNom() + " Tente d'attaquer " + p2.getNom() + ". Ce coup ne fait aucun dégât " + p2.getNom() + " n'a perdu aucun points de vie");
        else if(coupCritique == 1){
            System.out.println("Coup critique!");
            coup = (int) ((int) ((p1.getForce())+attAleatoire)-(p2.getConstitution()+defenseAleatoire));
            p2.setVie(p2.getVie()-coup);
            return coup;
        }
        p2.setVie(p2.getVie()-coup);
        return coup ;
    }

    @objid ("5bfb7dcb-7b10-4a6e-9605-76ba6f6352c6")
    public void explosion(Monstre monstre, Heros heros) {
        int explosion_m = monstre.getMaxVie()/4;
        heros.setVie(heros.getVie()-explosion_m);
        System.out.println(monstre.getNom() + " s'autodétruit. Il inflige " + explosion_m + " à " + heros.getNom());
        monstre.setVie(0);
    }

/*
 * Fonction qui prend en paramï¿½tre deux personnages    
 */
    @objid ("1e472f07-3758-445f-8374-21b7c35ce661")
    public void attaque(Personnage p1, Personnage p2) {
        int degats = calculDegats(p1, p2);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        if (degats > 0){
            if(p1 instanceof Monstre){
            System.out.println( p2.getNom()+ " est attaqué par " + p1.getNom() + " et perd " + degats + ". "
                    + " Sa vie est de " + p2.getVie() + ".");
        }
            else{
            System.out.println( p1.getNom() + " inflige " + degats + " à " + p2.getNom()+
                    "\nIl lui reste à present " + p2.getVie());
            ((Heros) p1).setExperience(((Heros) p1).getExperience() + 10);
            System.out.println("Experience" +((Heros) p1).getExperience());
            }
        }
    }

/*
     * La fonction defense augmente la constitution du personnage de 30%    
     */
    @objid ("fcf58d0e-fee0-4f48-9ccb-36d0a6610230")
    public void defense(Personnage p) {
        p.setConstitution( p.getConstitution() + (30*p.getConstitution() / 100 ));
        System.out.println(p.getConstitution());
    }

    @objid ("b3161646-b435-4e83-a23c-d3cb004b2fbf")
    public void resetDefense(Personnage p) {
        if(p.getConstitution() >= 30*p.getMaxConstitution()/100 && p.getConstitution() <=31*p.getMaxConstitution()/100);
            p.setConstitution(p.getMaxConstitution());
    }

    @objid ("2bd31c1a-d3eb-4fe4-8fdf-0f9447143268")
    public void Enchainement(Personnage p1, Personnage p2) {
        int enchainementContinu = 0 ;
        while(p1.getPa()>0){
            System.out.println("Que sera donc votre enchainement?\n 1-Attaquer \n 2-Arcanes \n");
            @SuppressWarnings("resource")
            Scanner choix = new Scanner(System.in);
            int action = choix.nextInt();
            switch (action){
            case 0:
                return;
            case 1:
                attaque(p1, p2);
                p1.setPa(p1.getPa()-1+enchainementContinu);
                System.out.println(p1.getPa());
                enchainementContinu--;
                break;
            case 2:
            	
            }
        }
    }

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

		do{									
	 		System.out.println("Choisissez un sort existant");

    			Scanner choix = new Scanner(System.in);
    			c=choix.nextInt();
			 	}while(c>i);
		p2.setVie(p2.getVie()-p1.getArcaneHeros(c).degatsRatio(p1));
        System.out.println( p1.getNom() + " lance " + p1.getArcaneHeros(c).getNomArcane() + "l'arcane inflige alors " + p1.getArcaneHeros(c).degatsRatio(p1) + " à " + p2.getNom()+
                "\nIl lui reste à present " + p2.getVie());

    }


	@objid ("d9fea520-8775-4eb4-aed1-0f7059db6976")
    public void calculPa(Personnage p) {
    }

    @objid ("6c8f200b-690c-47ee-9e8d-8f77397b0a58")
    public int calculExperience(int nbtour, int experience) {
        return 2*experience - bonusExperience(nbtour-2, experience);
    }

    @objid ("36f61c0b-9b33-41e5-aa93-d5ae7c2c809b")
    public int bonusExperience(int nbtour, int experience) {
        int experienceGagnee = (nbtour * experience)/10;
        if (experienceGagnee>experience){
            return experience;
        }
        return experienceGagnee;
    }

}
