package jobs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import Arcane.Arcane;
import Objets.Classe.Arme.Main;
import Objets.Classe.Protection.AvantBras;
import Objets.Classe.Protection.Pieds;
import Objets.Classe.Protection.Tete;
import Objets.Classe.Protection.Torse;
import Objets.Interface.Arme;
import Objets.Interface.Armure;
import Objets.Interface.Objet;
import carte.Carte;
import carte.Elements;

/**
 * Heros est la classe representant le personnageJoueur
 * @version 1.0
 *
 */
public class Heros extends Personnage implements Elements {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Un heros poss�de une experience de type integer
     * 
     * @see Heros#getExperience()
     * @see Heros#setExperience(int)
     * @see Heros#gainExperience(int)
     */
    private int experience;

    /** Un heros poss�de un niveau integer
     * 
     * @see Heros#getNiveau()
     * @see Heros#setNiveau(int)
     * @see Heros#niveauSuperieur()
     */
    private int niveau;

    /**
     * Le "job" du heros. Non modifiable apr�s la creation
     * 
     * Penser � regarder la documentation de la classe Jobs
     * 
     * @see Jobs
     * 
     * @see Heros#getJob()
     * @see Heros#setJob(Jobs)
     */
    private Job job;

    /**
     * Tableau d'arcane du Heros
     * 
     * Penser � regarder la documentation de la classe Arcane
     * 
     * @see Arcane
     * 
     * @see Heros#getTabArcaneHeros()
     * @see Heros#setTabArcaneHeros(Arcane[])
     * @see Heros#setArcaneHeros(int)
     */
    private Arcane[] tabArcaneHeros;

    /**
     * Un personnage poss�de deux mains, chaque main contenant une arme
     *
     * @see Arme
     * 
     * @see Heros#getMainDroite()
     * @see Heros#getMainGauche()
     * @see Heros#setMainDroite(Arme)
     * @see Heros#setMainGauche(Arme)
     * @see Heros#equiper(Objet)
     * @see Heros#equipementArme(Arme)
     */
    
    public static final Arme DEFAULT_MAINDROITE = new Main("MainDroite"); 
    public static final Arme DEFAULT_MAINGAUCHE = new Main("Maingauche");
    
    private Arme mainDroite = DEFAULT_MAINDROITE;
    private Arme mainGauche = DEFAULT_MAINGAUCHE;
    
    /**
     * Un heros poss�de un torse, son torse par 
     * d�faut n'ajoute aucun degr� suppl�mentaire;
     * 
     * @see Armure
     * @see Torse
     * @see Cote
     * 
     * 
     *@see Heros#setTorse(Armure)
     *@see Heros#getTorse()
     *@see Heros#equiper(Objet)
     *@see Heros#equipementArmure(Armure)
     */
    public static final Armure DEFAULT_TORSE = new Torse();
    private Armure torse = DEFAULT_TORSE;
    
    /**
     * Un heros poss�de une t�te qui par d�fault ne lui ajoute rien.
     * 
     * @see Armure
     * @see Tete
     * @see Casque
     * 
     * @see Heros#getTete()
     * @see Heros#setTete(Armure)
     * @see Heros#equiper(Objet)
     * @see Heros#equipementArmure(Armure)
     */
    public static final Armure DEFAULT_TETE = new Tete();
    private Armure tete = DEFAULT_TETE;
    
    /**
     * Un heros poss�de des avants_bras, par defaut ne lui ajoute rien.
     * 
     * @see Armure
     * @see AvantBras
     * @see ProtegeBras
     * 
     * @see Heros#getAvant_bras()
     * @see Heros#setAvant_bras(Armure)
     * @see Heros#equiper(Objet)
     * @see Heros#equipementArmure(Armure)
     */
    public static final Armure DEFAULT_AVANT_BRAS = new AvantBras();
    private Armure avant_bras = DEFAULT_AVANT_BRAS;
    
    /**
     * Un heros poss�de des pieds qui peuvent accueillir des bottes, 
     * par defaut lui ajoute aucun degr�.
     * 
     * @see Armure
     * @see Pieds
     * @see Bottes
     * 
     * @see Heros#getPieds()
     */
    public static final Armure DEFAULT_PIEDS = new Pieds();
    private Armure pieds = DEFAULT_PIEDS;
    
    
    
    
    
    
    /**
     * Un personnage poss�de �galement un inventaire,
     * cette inventaire est un tableau d'objet de 20 emplacements.
     * 
     * @see Objet
     * @see Heros#getInventaire()
     * @see Heros#setInventaire(Objet[])
     * 
     */
    private Objet[] inventaire = new Objet[20];

    /**
     * Represente le nombre de points gagnees par niveau
     * 
     * @see FichePerso
     * @see Heros#monteeStat(int)
     * 
     */
    public static final int PTS_NIV = 3;
    
    
    
    
    /**
     * Constructeur par defaut d'un Heros
     */
    public Heros() {
    	/**
    	 * Fait appel au constructeur par defaut de la classe Personnage
    	 */
        super();
        /**
         * Instancie un job avec le constructeur par defaut.
         */
        this.job = new Job();
        /**
         * Met l'experience du Heros a 0.
         */
        this.experience = 0;
        /**
         * Met le niveau du heros � 1
         */
        this.niveau = 1;
        /**
         * Donne un tableau de 5 Arcanes au heros.
         * Leur valeur sera null
         */
        this.tabArcaneHeros = new Arcane[5];
        /**
         * L'attaque du heros est la somme entre son degr� de force
         * et le degr� d'Attaque de son arme
         */
        

    }
  
    /**
     * Accesseur du job
     * 
     * @return le job du heros en cours
     */
    public Job getJob() {
        return job;
    }

    /**
     * Mutateur du job
     * 
     * @param job : job qui va remplacer celui en cours du h�ros.
     */
    public void setJob(Job job) {
        this.job = job;
    }

    /**
     * Accesseur de l'experience
     * @return l'experience du heros en cours.
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Augmente l'experience gagn� par le heros lors d'un combat.
     * @param experienceGagnee : nombre de points d'experience gagn�.
     */
    public void gainExperience(int experienceGagnee){
    	this.experience += experienceGagnee;
    	if (this.experience>=100 && this.niveau < 19){
    		this.niveauSuperieur();
    	}
    }

    /**
     * Accesseur du niveau de l'instance en cours.
     * @return : le niveau de l'instance en cours
     */
    public int getNiveau() {
        return niveau;
    }

    public Arcane[] getTabArcaneHeros() {
        return tabArcaneHeros;
    }

    public void setTabArcaneHeros(Arcane[] tabArcaneHeros) {
        this.tabArcaneHeros = tabArcaneHeros;
    }
    
    public void setArcaneHeros(int i){
  //  	this.tabArcaneHeros[i]=this.getJob().getArcaneDeJob(i);
    }
    
    /**
     * acceseur de la MainDroite
     * @return l'arme contenu dans la mainDroite
     */
    public Arme getMainDroite() {
		return mainDroite;
	}

    /**
     * Modifie l'arme situ�e dans la mainDroite
     * @param mainDroite: arme qui va remplacer l'ancienne arme.
     */
	public void setMainDroite(Arme mainDroite) {
		if(mainDroite.getNombreMain()==2){
			this.mainDroite = mainDroite; 
			this.mainGauche = mainDroite;
		}
		else if(mainDroite.getNombreMain()==2){
			this.mainDroite = mainDroite;
			this.mainGauche = DEFAULT_MAINGAUCHE;
		}
		else
			this.mainDroite = mainDroite;
	}

	/**
	 * Acceseur de l'arme situ�e dans la mainGauche
	 * @return l'arme dans l'emplacement mainGauche
	 */
	public Arme getMainGauche() {
		return mainGauche;
	}

	/**
	 * Mutateur de la mainGauche.
	 * @param mainGauche: l'arme qui sera mise dans la mainGauche.
	 */
	public void setMainGauche(Arme mainGauche) {
			if(mainGauche.getNombreMain()==2){
			this.mainGauche = mainGauche; 
				this.mainDroite = mainGauche;
		}
		else if(mainDroite.getNombreMain()==2){
			this.mainGauche = mainGauche;
			this.mainDroite = DEFAULT_MAINDROITE;
		}
		else
			this.mainGauche = mainGauche;
	}

	/**
	 * Accesseur de l'armure �quip�e au torse
	 * @return : l'armure du torse
	 */
	public Armure getTorse() {
		return torse;
	}

	/**
	 * Mutateur de l'armure �quip�e au torse.
	 * @param torse : Armure qui remplacera la pr�cedente armure.
	 */
	public void setTorse(Armure torse) {
		this.torse = torse;
	}

	/**
	 * Accesseur du casque �quip� � la tete.
	 * @return : le casque �quip� � la tete.
	 */
	public Armure getTete() {
		return tete;
	}

	/**
	 * Mutateur de la tete
	 * @param tete: Casque qui remplacera le casque pr�cedemment �quip�
	 */
	public void setTete(Armure tete) {
		this.tete = tete;
	}

	/**
	 * Acceseur des avants_bras
	 * @return : les proteges bras
	 */
	public Armure getAvant_bras() {
		return avant_bras;
	}

	/**
	 * Mutateur des avants bras
	 * @param avant_bras: remplace les avants bras precedents.
	 */
	public void setAvant_bras(Armure avant_bras) {
		this.avant_bras = avant_bras;
	}


	/**
	 * Accesseur de l'equipement aux pieds
	 * @return l'equipement au pieds.
	 */
	public Armure getPieds() {
		return pieds;
	}


	/**
	 * Mutateur de l'equipement concernant les pieds
	 * @param pieds : remplace le precedent equipement des pieds.
	 */
	public void setPieds(Armure pieds) {
		this.pieds = pieds;
	}



	/**
	 * La methode equiper, regarde l'emplacement de l'arme
	 * en fonction de celui-ci fait appel � une m�thode �quipement diff�rente.
	 * 
	 * @param equipement
	 * 
	 * @see Arme#emplacementEquipement()
	 */
	public void equiper(Objet equipement){
		
		switch(equipement.emplacementEquipement()){
		/**
		 * Dans le cas o� emplacement Equipement est "Main"
		 * On fait appel � equipementArme(Arme)
		 */
		case "Main":
			Arme arme_equip = (Arme) equipement;
			this.equipementArme(arme_equip);	
			break;
			
		/**
		 * Dans le cas o� emplacementEquipement == "Torse"
		 * On fait appelle � �quipementArmure(Armure)
		 */
		
		default:	Armure armure_equip = (Armure) equipement;
				this.equipementArmure(armure_equip);
				break;
		}
	}
	
	/**
	 * Cette fonction permet au personnage de s'�quiper d'une arme.
	 * 
	 * @param arme_equip
	 * 
	 * @see Arme#equiper(Heros)
	 * 
	 */
	public void equipementArme(Arme arme_equip){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int choixEquipement;
		/**
		 * Dans le cas ici ou l'arme que l'on souhaite �quiper est une arme � deux mains.
		 */
		if(arme_equip.getNombreMain()==2){
			
			/**
			 * On verifie d'abord si une arme � deux mains est �quip�e
			 * (on peut remplacer mainDroite par mainGauche, cela revient au m�me)
			 */
			if(this.getMainDroite().getNombreMain() == 2){
				
				System.out.println("Etes-vous sur de vouloir remplacer : \n" + mainDroite.affichageCaracteristique()
						+ "\n1-Equiper "+arme_equip.affichageCaracteristique()+ "\n2-Annuler");
			}
			
			/**
			 * Dans le cas ou l'on serait �quip� d'une ou plusieurs armes � 1 main.
			 */
			else{
				
			System.out.println("Etes-vous sur de vouloir remplacer : \n"+ mainDroite.affichageCaracteristique() + " et " 
		    + mainGauche.affichageCaracteristique()	+ " ?" + "\n1-Equiper "+arme_equip.affichageCaracteristique()+ "\n2-Annuler");
			}
			/**
			 * Choix �quipement devient la r�ponse de l'utilisateur au programme:
			 * 1 = Oui et proc�der � l'�quipement
			 * 2 ou autres = annulation.
			 */
			choixEquipement = scanner.nextInt();
			while(choixEquipement!=1 && choixEquipement!=2){
				System.out.println("Choisissez entre 1 et 2");
				choixEquipement = scanner.nextInt();
			}
			
			/**
			 * Dans le cas de la r�ponse
			 */
			switch(choixEquipement){
		
				case 1: 
					/** 
					 * Si le personnageest �quip� d'une arme � deux mains dans la mainDroite
					 * on fait appel � mainDroite.desequiper(Heros)
					 */
					if(this.getMainDroite().getNombreMain() == 2){
					mainDroite.desequiper(this);
					}
					/**
					 * Dans le cas contraire, on fait appel � mainDroite.desequiper(Heros,numMain)
					 */
					else{
						mainDroite.desequiper(this,1);
						mainGauche.desequiper(this,2);
					}
					
				
					
				/**
				 * On met dans la mainDroite(ou gauche) l'arme � �quiper
				 */
				this.setMainDroite(arme_equip.equiper(this));
				break;
				case 2:
				return;
			}
		}
		
		
		/**
		 * Dans le cas ici o� l'arme que l'on souhaite �quiper est � une main.
		 */
		else{

		System.out.println("Dans quelle main souhaitez-vous �quiper votre arme? \n1- Main Droite :" + mainDroite.affichageCaracteristique()
				+ "\n\n"+ "2- Main Gauche :" + mainGauche.affichageCaracteristique());
		/**
		 * On enregistre ensuite sa reponse dans une variable. 
		 */
		choixEquipement = scanner.nextInt();
		while(choixEquipement!=1 && choixEquipement!=2){
			System.out.println("Choisissez entre 1 et 2");
			scanner.nextInt();
		}
		
		/**
		 * Si la mainDroite(ou MainGauche) est une arme � deux mains
		 */
		
		if(mainDroite.getNombreMain()==2){
			/**
			 * On la desequipe
			 */
			mainDroite.desequiper(this);
			if(choixEquipement == 1){
				/**
				 * Puis selon la reponse de l'utilisateur au choix de la main
				 * on remplace la MainDroite(ou gauche) par l'homme qu'on souhaite �quiper
				 * ici mainDroite.
				 */
				this.setMainDroite(arme_equip.equiper(this));
			}
			/**
			 * Ici mainGauche
			 */
			else{
				this.setMainGauche(arme_equip.equiper(this));
			}
		}

		/**
		 * Dans le cas o� ce n'est pas le cas (arme � une main)
		 */
		else{
			
		
		switch(choixEquipement){
		/**
		 * Si choixEquipement = 1 on desequipe l'arme de la mainDroite et on la remplace par arme_equip
		 */
		case 1:
			mainDroite.desequiper(this,1);
			this.setMainDroite(arme_equip.equiper(this));
			break;
		/**
		 * Si choixEquipement = 2 on desequipe l'arme de la mainGauche et on la remplace par arme_equip.
		 */
		case 2:
	
			mainGauche.desequiper(this, 2);
			this.setMainGauche(arme_equip.equiper(this));
			break;
			}
		}

		}
	}
	
	/**
	 * Cette fonction permet de s'equiper d'une armure � l'emplacement Torse
	 * 
	 * @param armure_equip : armure que l'on souhaite Equiper
	 */
	
	public void equipementArmure(Armure armure_equip){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int choixEquipement;
		
		/**
		 * En fonction de l'emplacement armure, on fait une comparaison differente
		 */
		switch(armure_equip.emplacementEquipement()){
		case "Torse":				
			System.out.println("Etes-vous sur de vouloir vous equiper de : \n"+ armure_equip.affichageCaracteristique() +
					" � la place de " + this.getTorse().affichageCaracteristique() + " ?\n1-Equiper\n2-Annuler");
			break;
		case "Pieds":
			System.out.println("Etes-vous sur de vouloir vous equiper de : \n"+ armure_equip.affichageCaracteristique() +
					" � la place de " + this.getPieds().affichageCaracteristique() + " ?\n1-Equiper\n2-Annuler");
			break;
		case "Avant-Bras":
			System.out.println("Etes-vous sur de vouloir vous equiper de : \n"+ armure_equip.affichageCaracteristique() +
					" � la place de " + this.getAvant_bras().affichageCaracteristique() + " ?\n1-Equiper\n2-Annuler");
			break;
		case "Tete":
			System.out.println("Etes-vous sur de vouloir vous equiper de : \n"+ armure_equip.affichageCaracteristique() +
					" � la place de " + this.getTete().affichageCaracteristique() + " ?\n1-Equiper\n2-Annuler");
			break;
		}
		
		choixEquipement = scanner.nextInt();
		while(choixEquipement!=1 && choixEquipement!=2){
			System.out.println("Choisissez entre 1 et 2");
			choixEquipement = scanner.nextInt();
			}
				
		switch(choixEquipement){
		/**
		 * Dans le cas o� le Heros valide(rentre 1)
		 * On desequipe l'armure contenu dans emplacementEquipement egale � celui d'armure_equip
		 * puis on equipe armure_equip � l'emplacement d�sir�.
		 */
			case 1: 
				switch(armure_equip.emplacementEquipement()){
				case "Torse":				
					this.getTorse().desequiper(this);
					this.setTorse(armure_equip.equiper(this));
					break;
				case "Pieds":
					this.getPieds().desequiper(this);
					this.setPieds(armure_equip.equiper(this));
					break;
				case "Avant-Bras":
					this.getAvant_bras().desequiper(this);
					this.setAvant_bras(armure_equip.equiper(this));
					break;
				case "Tete":
					this.getTete().desequiper(this);
					this.setTete(armure_equip.equiper(this));
					break;
				}

				break;
		/**
		 * Dans le cas o� on rentre 2, on return.			
		 */
			case 2:
				return;
		}
	}

	/**
	 * Phase de niveau sup�rieur (Experience >=100)
	 * 
	 * @see Heros#gainExperience(int)
	 */
    public void niveauSuperieur() {
    	@SuppressWarnings("unused")
		FichePerso base = null;
    	int gNiveau = 0;
                while(this.experience >=100 && this.niveau < 20){
                        this.experience -=100;
                        this.niveau++;
                        System.out.println(this.getNom() +" a pris en puissance, le niveau " + this.niveau + " a �t� atteint.");
                        this.repartitionPoints();
                        gNiveau++;
                        
                }
                base = new FichePerso(this.getNom(),this, PTS_NIV*gNiveau);
                this.remiseDegree();
    }

    /**
     * Permet la cr�ation d'un personnageJoueur.
     * 
     * @return une instance de Heros qui sera le nouvel h�ros cr�e.
     * @since 1.0
     */
    public static Heros creationPersonnage() {
        System.out.println("Vous voici � l'heure de la cr�ation de votre personnage\n "+
                "Tout d'abord, comment vous appelerez vous?");
        Heros x = new Heros();
        while(x.getJob().getNomJob()=="Classe"){
	        try{
	            @SuppressWarnings("resource")
	        Scanner creation = new Scanner(System.in);
	        x.setNom(creation.nextLine());
	        System.out.println("Je vois, c'est donc comme cela que vous avez d�cid� de vous appelez.\n" +
	                            "A pr�sent, il est temps de d�cider de votre classe : \n"
	                            + "1 - Paladin \n"
	                            + "2 - Maraudeur \n"
	                            + "3 - Arcaniste \n"
	                            + "4 - Lance Rouge \n"
	                            + "5 - Bretteur \n"
	                            );
	        int choix = creation.nextInt();
	        x.setJob(x.getJob().choixJob(choix, x));
	        }catch(InputMismatchException e){
	        	e.printStackTrace();
	        }
        }
        x.remiseDegree();
        return x;
    }


    /**
     * Pour l'IHM, retourne un tableau d'entier contenu les stats.
     * @return
     */
    public int[] repartitionPoints(){
    	int f = this.getForce();
    	int i = this.getIntelligence();
    	int c = this.getConstitution();
    	int a = this.getAgilite();
    	int r = this.getResistance();
    	int[] stat = {f, i, c, a,r };
    	return stat;
    }
    
    /**
     * Pour l'IHM, augmente les stats d'un point.
     * @param stat
     */
    public void monteeStat(int stat){	
    	switch (stat){
    	case 0:
    		this.setForce(this.getForce()+1);
    		break;
    	case 1:
    		this.setIntelligence(this.getIntelligence()+1);
    		break;
    	case 2:
    		this.setConstitution(this.getConstitution()+1);
    		break;
    	case 3:
    		this.setAgilite(this.getAgilite()+1);
    		break;
    	case 4:
    		this.setResistance(this.getResistance()+1);
    		break;
    	}
    }
    
    /**
     * Pour l'IHM, baisse les stats d'un point.
     * @param stat
     */
    public void baisseStat(int stat){
    	switch(stat){
    	case 0:
    		this.setForce(this.getForce()-1);
    		break;
    	case 1:
    		this.setIntelligence(this.getIntelligence()-1);
    		break;
    	case 2:
    		this.setConstitution(this.getConstitution()-1);
    		break;
    	case 3:
    		this.setAgilite(this.getAgilite()-1);
    		break;
    	case 4:
    		this.setResistance(this.getResistance()-1);
    		break;
    	}
    }  

    /**
     * remiseDegree ou remiseStat
     * Ce qui sert � la gestion des Degr�es.
     */
	public void remiseDegree() {
		this.setVie(this.getMaxVie());
		this.setdForce(new Degree(this.getForce()));
		this.setdIntelligence(new Degree(this.getIntelligence()));
		this.setdConstitution(new Degree(this.getConstitution()));
		this.setdAgilite(new Degree(this.getAgilite()));
		this.setdResistance(new Degree(this.getResistance()));
		this.setDegats(Degree.somme(this.getdForce(), this.getMainDroite().getImpactArme()));
		try{
			this.setDegatsM(Degree.somme(this.getdIntelligence(), this.getMainDroite().getImpactMagique()));
		}catch(NullPointerException e){
			this.setDegatsM(new Degree(this.getdIntelligence()));
		}
		this.setAttaque(Degree.somme(this.getdAgilite(), this.getMainDroite().getManiabilite()));
		this.setInitiative(Degree.soustraction(this.getdAgilite(), this.torse.getEncombrement()));
		this.setEsquive(Degree.soustraction(this.getdAgilite(), this.torse.getEncombrement()));
		this.setDefense(Degree.somme(this.getdConstitution(), this.torse.getSolidite()));		
		this.setDefenseM(Degree.somme(this.getdResistance(), this.torse.getResistanceMagique()));
	}
	
	/**
	 * toString du Heros en cours, renvoi H (affichage sur la carte)
	 */
 	public String toString() {
 		return "H";
 	}

 	/**
 	 * Affichage des caract�ristiques de l'instance en cours
 	 *  
 	 */
 	@Override
	public String affichageCaracteristique() {
		 return job + " " + super.toString() + " experience: " + experience
 				+ " niveau: " + niveau + "\nmainDroite : " + mainDroite.affichageCaracteristique()+ "\nmainGauche=" + mainGauche.affichageCaracteristique()
 				+ "\n\ndegats=" + this.getDegats() + "; attaque="+this.getAttaque() + "; defense=" + this.getDefense()+"\n";
	}

 	public Arcane gestionArcane() {
		int i = 0;
		try{
    		for(Arcane a : this.getTabArcaneHeros()){
    				System.out.println(i+ " "+ a.getNomArcane()+ " PA: " + a.getCoutPa());
   				 	i++;
    		}
    		
    		
		}catch(NullPointerException e){
    	}catch(InputMismatchException e){
    	}
		
		int c=0;
		@SuppressWarnings("resource")
		Scanner rentrer = new Scanner(System.in);
		c = rentrer.nextInt();
		return this.getTabArcaneHeros()[c];
 	}
 	
 	/**
 	 * Ajoute un objet dans l'Inventaire
 	 * 
 	 * @param o : l'objet que l'on souhaite ajouter dans l'inventaire
 	 */
 	public void ajoutObjet(Objet o){
 		int i = 0;
 		/**
 		 * On cherche un emplacement libre dans l'Inventaire
 		 */
 		while( inventaire[i] != null){
 			i++;
 		}
 		
 		/**
 		 * Quand on le trouve, on place l'objet o � cette emplacement.
 		 */
 		if(inventaire[i]== null){
 			inventaire[i] = o;
 			System.out.println("Vous avez mis dans votre sac " + o.getNomObjet() + "\n");
 		}
 		/**
 		 * Si on le trouve pas (Inventaire remplir), message affich�.
 		 */
 		else{
 			System.out.println("Vous n'avez plus de place dans votre inventaire, jeter d'abord un objet avant mettre celui-ci dans votre sac!");
 		}
 	}
 	
 	/**
 	 * Retire un objet qui est dans l'Inventaire
 	 * 
 	 * @param o : objet que l'on souhaite retirer du sac
 	 */
 	public void retirerObjet(Objet o){
 		int i = 0;
 		
 		/**
 		 * Tant que l'Emplacement i de l'inventaire ne correspond � l'objet que l'on cherche
 		 */
 		while( inventaire[i] == null || inventaire[i] != null){
 				try{
 					/**
 					 * Si on trouve l'objet
 					 */
 					if(inventaire[i].equals(o)){
 					
 				/**
 				 * On remplace l'emplacement o� est contenu l'objet par un emplacement libre (null) 
 				 */
 				inventaire[i] = null;
 				return;
 					}
 				/** 
 				 * Dans le cas o� on a rien trouv� du tout
 				 * on return.
 				 */
 	 		}catch(NullPointerException e ){
 	 			return;
 	 			
 	 		}

 			i++;
 		}
 		return;
 	}
 		
 	/**
 	 * Affiche l'Inventaire
 	 * 
 	 * @see Objet#utiliser(Heros)
 	 */
 	public void affichageInventaire(){
 		
 		/**
 		 * case_vide agit comme un incrementeur
 		 */
 		int case_vide = 0;
 		
 		/**
 		 * On parcours l'Inventaire.
 		 */
 		for(int i = 0 ; i<inventaire.length; i++){
 			/**
 			 * Si l'emplacement i est vide
 			 * on incremente case_vide de 1.
 			 */
 			if(inventaire[i] == null){
 				case_vide +=1;
 			}
 			
 			/**
 			 * Si le nombre de case vide est �gale � la taille de l'inventaire
 			 * cela veut dire que l'inventaire est vide, il n'y a donc rien � afficher.
 			 */
 			if(case_vide == inventaire.length){
				System.out.println("Votre inventaire est vide!");
				return;
 			}
 			
 			/**
 			 *Si l'emplacement i de l'inventaire est un Objet,
 			 *on print son nom, avec le numero correspondant � son emplacement dans l'Inventaire. 
 			 */
			if(this.inventaire[i] instanceof Objet)
 				System.out.println("Objet " + i +": "  + inventaire[i].getNomObjet());	
		}
 		
 		/**
 		 * Le scanner qui va permettre de choisir l'objet que l'on souhaite utiliser
 		 */
 		Scanner choix = new Scanner(System.in);
 		System.out.println("Veuillez-saisir le n� de l'objet que vous souhaitez utiliser.");
 		int choixObjet = choix.nextInt();
 		while(inventaire[choixObjet] == null){
 			return;
 		}
 		
 		
 		System.out.println("Souhaitez-vous utilisez " + inventaire[choixObjet].getNomObjet() + "\nO - Oui\nN - Non");
 		
 		/**
 		 * Dans le cas o� on valide l'utilisation de l'objet,
 		 */
 			String oui_non = choix.next();
 			switch (oui_non){
 			case "O": 
 				inventaire[choixObjet].utiliser(this);
 				break;
 			case "N":
 				return;
 		}
 	}
 	
 	/**
 	 * Choix � faire sur la carte
 	 * 
 	 * @param carte : carte sur laquelle le Heros se d�place
 	 */
	public void choix(Carte carte){
		int i = 0;
	/**
	 * Boucle infini.
	 */
		while(i!=-1){
		System.out.println("Que souhaitez-vous faire ?\n(1 = deplacer, 2 = attaquer, 3 = voir l'inventaire, 4 = arcane)\nIl vous reste "+this.getPa()+"Pa/"+this.getMaxPa()+"Pa");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int nb = 0;
		try{
		nb = scan.nextInt();
		}catch (InputMismatchException e){
			System.out.println("Rentrer un autre chiffre");
		}

		
		switch (nb){
		
		case 1: 
			if(this.getPa()<3){
				System.out.println("Vous n'avez pas assez de PA pour vous d�placer.");
				break;
			}
			carte.deplacement(this);
			break;
		case 2:
			if(this.getPa()<4){
				System.out.println("Vous n'avez pas assez de PA pour attaquer.");
				break;
			}
		
			if(mainDroite.getNombreMain()==2){
				System.out.println("Votre arme : "+ this.getMainDroite().affichageCaracteristique()
						+ "\nValider vous votre attaque? \n1 - Attaquer \n2 - Annuler");
				int choixAction = 0;
				
				choixAction = scan.nextInt();
				
				switch(choixAction){
				case 1 :
					carte.attaquer(this, 1);
					break;
				}
			}
			else{
				
		
			int choixMain = 0;
			System.out.println("Avec quelle main souhaitez vous attaquer?\n1 - "+ this.getMainDroite().affichageCaracteristique()+"\n2 - "+ this.getMainGauche().affichageCaracteristique());
			
			choixMain = scan.nextInt();

			switch(choixMain){
			case 1:
				carte.attaquer(this, 1);
				break;
			case 2:
				carte.attaquer(this, 2);
				break;
				}
			}
			break;
		case 3: 
			this.affichageInventaire();
			break;
		case 4:
			this.gestionArcane();
			break;
		}
	
		for(int k = 0; k < carte.getnbLig(); k++){
			for(int j = 0; j<carte.getnbCol(); j++){
				if(carte.getGrille()[k][j] instanceof Monstre){
					((Type)carte.getGrille()[k][j]).action(carte);
				}
			}
		}
		System.out.println(carte.Afficher());
		}

	}
	public static void afficheCollectionHeros(ArrayList <Heros> colHeros){
		int indice =0;

		for (Heros h : colHeros){
			System.out.println("Monstre " + indice + " de la collection => " + h.affichageCaracteristique());
			indice++;
		}
		System.out.println("\n");
	}



	@Override
	/**
	 * Fonction equals, compare l'instance actuelle avec un object
	 * renvoi true si les deux instances sont semblables.
	 * Faulse si les deux instances ne sont pas les m�mes
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Heros)) {
			return false;
		}
		Heros other = (Heros) obj;
		if (avant_bras == null) {
			if (other.avant_bras != null) {
				return false;
			}
		} else if (!avant_bras.equals(other.avant_bras)) {
			return false;
		}
		if (experience != other.experience) {
			return false;
		}
		if (!Arrays.equals(inventaire, other.inventaire)) {
			return false;
		}
		if (job == null) {
			if (other.job != null) {
				return false;
			}
		} else if (!job.equals(other.job)) {
			return false;
		}
		if (mainDroite == null) {
			if (other.mainDroite != null) {
				return false;
			}
		} else if (!mainDroite.equals(other.mainDroite)) {
			return false;
		}
		if (mainGauche == null) {
			if (other.mainGauche != null) {
				return false;
			}
		} else if (!mainGauche.equals(other.mainGauche)) {
			return false;
		}
		if (niveau != other.niveau) {
			return false;
		}
		if (pieds == null) {
			if (other.pieds != null) {
				return false;
			}
		} else if (!pieds.equals(other.pieds)) {
			return false;
		}
		if (!Arrays.equals(tabArcaneHeros, other.tabArcaneHeros)) {
			return false;
		}
		if (tete == null) {
			if (other.tete != null) {
				return false;
			}
		} else if (!tete.equals(other.tete)) {
			return false;
		}
		if (torse == null) {
			if (other.torse != null) {
				return false;
			}
		} else if (!torse.equals(other.torse)) {
			return false;
		}
		return true;
	}
}
