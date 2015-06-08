package jobs;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Objets.CreationArme;
import Objets.ExceptionArme;
import Objets.Objet;
import Objets.Classe.Arme.Baton;
import Objets.Classe.Arme.EpeeLegere;
import Objets.Classe.Arme.Main;
import Objets.Classe.Protection.Cote;
import Objets.Classe.Protection.Torse;
import Objets.Interface.Arme;
import Objets.Interface.Armure;
import carte.Elements;
/**
 * Heros est la classe representant le personnageJoueur
 * @version 1.0
 *
 */
public class Heros extends Personnage implements Elements {
	
    /**
     * Un heros possède une experience de type integer
     * 
     * @see Heros#getExperience()
     * @see Heros#setExperience(int)
     * @see Heros#gainExperience(int)
     */
    private int experience;

    /** Un heros possède un niveau integer
     * 
     * @see Heros#getNiveau()
     * @see Heros#setNiveau(int)
     * @see Heros#niveauSuperieur()
     */
    private int niveau;

    /**
     * Le "job" du heros. Non modifiable après la creation
     * 
     * Penser à regarder la documentation de la classe Jobs
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
     * Penser à regarder la documentation de la classe Arcane
     * 
     * @see Arcane
     * 
     * @see Heros#getTabArcaneHeros()
     * @see Heros#setTabArcaneHeros(Arcane[])
     * @see Heros#setArcaneHeros(int)
     */
    private Arcane[] tabArcaneHeros;

    /**
     * Un personnage possède deux mains, chaque main contenant une arme
     *
     * @see Arme
     * 
     * @see Heros#setMainDroite(Arme)
     * @see Heros#setMainGauche(Arme)
     * @see Heros#equiper(Arme)
     */
    
    public static final Arme DEFAULT_MAINDROITE = new Main("MainDroite"); 
    public static final Arme DEFAULT_MAINGAUCHE = new Main("Maingauche");
    public static final Armure DEFAULT_TORSE = new Torse();
    
    private Arme mainDroite = DEFAULT_MAINDROITE;
    private Arme mainGauche = DEFAULT_MAINGAUCHE;
    
    private Armure torse = DEFAULT_TORSE;
    private Objet[] inventaire = new Objet[20];

    /**
     * Represente le nombre de points gagnees par niveau
     * 
     * @see FichePerso
     * @see Heros#monteeStat(int)
     * 
     */
    public static final int PTS_NIV = 2;
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
         * Met le niveau du heros à 1
         */
        this.niveau = 1;
        /**
         * Donne un tableau de 5 Arcanes au heros.
         * Leur valeur sera null
         */
        this.tabArcaneHeros = new Arcane[5];
        /**
         * L'attaque du heros est la somme entre son degré de force
         * et le degré d'Attaque de son arme
         */
        

    }


	public Heros(String nom, int vie, int mana, int force, int intelligence, int agilite, int constitution,
    		int resistance, int maxPa, Job job, Arcane[] tabArcaneHeros,
			Arme mainDroite, Arme mainGauche) {
		/**
		 * Fait appel au constructeur de la calsse mère
		 * 
		 * @see Personnage
		 */
		super(nom, vie, mana, force, intelligence, agilite, constitution, resistance, maxPa);
		this.niveau = 1;
		this.job = job;
		this.tabArcaneHeros = tabArcaneHeros;
		this.mainDroite = mainDroite;
		this.mainGauche = mainGauche;

	}
   
    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
        if (this.experience>=100 && this.niveau <19){
        	this.niveauSuperieur();
        }
    }
    
    public void gainExperience(int experienceGagnee){
    	this.experience += experienceGagnee;
    	if (this.experience>=100 && this.niveau < 19){
    		this.niveauSuperieur();
    	}
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public Arcane[] getTabArcaneHeros() {
        return tabArcaneHeros;
    }

    public void setTabArcaneHeros(Arcane[] tabArcaneHeros) {
        this.tabArcaneHeros = tabArcaneHeros;
    }
    
    public void setArcaneHeros(int i){
    	this.tabArcaneHeros[i]=this.getJob().getArcaneDeJob(i);
    }
    public Arme getMainDroite() {
		return mainDroite;
	}

	public void setMainDroite(Arme mainDroite) {
		if(mainDroite.getNombreMain()==2){
			this.mainDroite = mainDroite; 
			if(this.getJob().getNomJob().equals("Bretteur"))
				this.mainGauche = DEFAULT_MAINGAUCHE; 
			else
				this.mainGauche = mainDroite;
		}
		else if(mainDroite.getNombreMain()==2){
			this.mainDroite = mainDroite;
			this.mainGauche = DEFAULT_MAINGAUCHE;
		}
		else
			this.mainDroite = mainDroite;
	}

	public Arme getMainGauche() {
		return mainGauche;
	}

	public void setMainGauche(Arme mainGauche) {
			if(mainGauche.getNombreMain()==2){
			this.mainGauche = mainGauche; 
			if(this.getJob().getNomJob().equals("Bretteur"))
				this.mainDroite = DEFAULT_MAINDROITE; 
			else
				this.mainDroite = mainGauche;
		}
		else if(mainDroite.getNombreMain()==2){
			this.mainGauche = mainGauche;
			this.mainDroite = DEFAULT_MAINDROITE;
		}
		else
			this.mainGauche = mainGauche;
	}

	public Armure getTorse() {
		return torse;
	}


	public void setTorse(Armure torse) {
		this.torse = torse;
	}


	public Objet[] getInventaire() {
		return inventaire;
	}


	public void setInventaire(Objet[] inventaire) {
		this.inventaire = inventaire;
	}


	public void equiper(Objet equipement){
		
		switch(equipement.emplacementEquipement()){
		case "Main":
			Arme arme_equip = (Arme) equipement;
			this.equipementArme(arme_equip);	
		case "Torse":
			Armure armure_equip = (Armure) equipement;
			this.equipementArmure(armure_equip);
		}
		this.remiseDegree();
	}
	
	public void equipementArme(Arme arme_equip){
		Scanner scanner = new Scanner(System.in);
		int choixEquipement;
		if(arme_equip.getNombreMain()==2){
			System.out.println("Etes-vous sur de vouloir remplacer : \n"+ mainDroite.affichageCaracteristique() + " et\n" 
		    + mainGauche.affichageCaracteristique()	+ " ?" + "\n1-Equiper \n2-Annuler" );
			choixEquipement = scanner.nextInt();
			while(choixEquipement!=1 && choixEquipement!=2){
				System.out.println("Choisissez entre 1 et 2");
				choixEquipement = scanner.nextInt();
			}
			switch(choixEquipement){
				case 1: 
				mainDroite.desequiper(this);
				this.setMainDroite(arme_equip.equiper(this));
				break;
				case 2:
				return;
			}
		}
		else{

		System.out.println("Dans quelle main souhaitez-vous équiper votre arme? \n1- Main Droite :" + mainDroite.affichageCaracteristique()
				+ "\n\n"+ "2- Main Gauche :" + mainGauche.affichageCaracteristique());
		choixEquipement = scanner.nextInt();
		while(choixEquipement!=1 && choixEquipement!=2){
			System.out.println("Choisissez entre 1 et 2");
			scanner.nextInt();
		}
		if(mainDroite.getNombreMain()==2 || mainGauche.getNombreMain()==2){
			mainDroite.desequiper(this);
		}
		switch(choixEquipement){
		case 1:
			mainDroite.desequiper(this,1);
			this.setMainDroite(arme_equip.equiper(this));
			break;
		case 2:
			mainGauche.desequiper(this, 2);
			this.setMainGauche(arme_equip.equiper(this));
			break;
			}
		}
	}
	
	public void equipementArmure(Armure armure_equip){
		Scanner scanner = new Scanner(System.in);
		int choixEquipement;
		
		System.out.println("Etes-vous sur de vouloir vous equiper de : \n"+ armure_equip.affichageCaracteristique() +
				" à la place de " + this.getTorse().affichageCaracteristique() + " ?\n1-Equiper\n2-Annuler");
				choixEquipement = scanner.nextInt();
				while(choixEquipement!=1 && choixEquipement!=2){
					System.out.println("Choisissez entre 1 et 2");
					choixEquipement = scanner.nextInt();
				}
				switch(choixEquipement){
					case 1: 
					armure_equip.desequiper(this);
					this.setTorse(armure_equip.equiper(this));
					break;
					
					case 2:
					return;
				}
			}

    public void niveauSuperieur() {
    	@SuppressWarnings("unused")
		FichePerso base = null;
    	int gNiveau = 0;
                while(this.experience >=100 && this.niveau < 20){
                        this.experience -=100;
                        this.niveau++;
                        System.out.println(this.getNom() +" a pris en puissance, le niveau " + this.niveau + " a été atteint.");
                        this.repartitionPoints();
                        gNiveau++;
                        
                }
                base = new FichePerso(this.getNom(),this, PTS_NIV*gNiveau);
                this.remiseDegree();
    }

/**
     * Permet la création d'un personnageJoueur.
     * @return une instance de Heros qui sera le nouvel héros crée.
     * @since 1.0
     */
    public static Heros creationPersonnage() {
        System.out.println("Vous voici à l'heure de la création de votre personnage\n "+
                "Tout d'abord, comment vous appelerez vous?");
        @SuppressWarnings("resource")
        Scanner creation = new Scanner(System.in);
        Heros x = new Heros();
        x.setNom(creation.nextLine());
        while(x.getJob().getNomJob()=="Classe"){
        System.out.println("Je vois, c'est donc comme cela que vous avez décidé de vous appelez.\n" +
                            "A présent, il est temps de décider de votre classe : \n"
                            + "1 - Paladin \n"
                            + "2 - Maraudeur \n"
                            + "3 - Arcaniste \n"
                            + "4 - Lance Rouge \n"
                            + "5 - Bretteur \n"
                            );
        int choix = creation.nextInt();
        x.setJob(x.getJob().choixJob(choix, x));
       }
        x.remiseDegree();
        return x;
    }

    public String toStringTabArcaneHeros(){
    	try{
    		for (Arcane c : this.tabArcaneHeros){
    			return c.toString();
    		}
    	} catch(NullPointerException e){
    		return null;
    	}
    	return null;
    }

    public int[] repartitionPoints(){
    	int f = this.getForce();
    	int i = this.getIntelligence();
    	int c = this.getConstitution();
    	int a = this.getAgilite();
    	int r = this.getResistance();
    	int[] stat = {f, i, c, a,r };
    	return stat;
    }
    
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

	public void remiseDegree() {
		this.setdForce(new Degree(this.getForce()));
		this.setdIntelligence(new Degree(this.getIntelligence()));
		this.setdConstitution(new Degree(this.getConstitution()));
		this.setdAgilite(new Degree(this.getAgilite()));
		this.setdResistance(new Degree(this.getResistance()));
		this.setDegats(Degree.somme(this.getdForce(), this.getMainDroite().getImpactArme()));
		this.setAttaque(Degree.somme(this.getdAgilite(), this.getMainDroite().getManiabilite()));
		this.setInitiative(Degree.soustraction(this.getdAgilite(), this.torse.getEncombrement()));
		this.setEsquive(Degree.soustraction(this.getdAgilite(), this.torse.getEncombrement()));
		this.setDefense(Degree.somme(this.getdConstitution(), this.torse.getSolidite()));		
		this.setDefenseM(Degree.somme(this.getdResistance(), this.torse.getResistanceMagique()));
	}
	
	
 	public String toString() {
 		return "H";
 	}

 	@Override
	public String affichageCaracteristique() {
		// TODO Auto-generated method stub
		 return job + " " + super.toString() + " experience: " + experience
 				+ " niveau: " + niveau + "\nArme :" + mainDroite.affichageCaracteristique()+ ", mainGauche=" + mainGauche.affichageCaracteristique()
 				+ ", degats=" + this.getDegats();
	}

 	public Arcane Arcane() {
		int i = 0;
		try{
    		for(Arcane a : this.getTabArcaneHeros()){
    				System.out.println(i+ " "+ a.getNomArcane()+ " PA: " + a.getCoutPA());
   				 	i++;
    		}
    		
    		
		}catch(NullPointerException e){
    	}catch(InputMismatchException e){
    	}
		
		int c=0;
		Scanner rentrer = new Scanner(System.in);
		c = rentrer.nextInt();
		return this.getTabArcaneHeros()[c];
 	}
 	
 	public void ajoutObjet(Objet o){
 		int i = 0;
 		while( inventaire[i] != null){
 			i++;
 		}
 		if(inventaire[i]== null){
 			inventaire[i] = o;
 			System.out.println("Vous avez récupéré " + o.affichageCaracteristique());
 		}
 		else{
 			System.out.println("Vous n'avez plus de place dans votre inventaire, jeter d'abord un objet avant de ramasser celui-ci!");
 		}
 			
 	}
 	public static void main(String[] args) {
 		
        Heros[] herosOccupe = new Heros[500];
        
        herosOccupe[1] = Heros.creationPersonnage();    
      /*  herosOccupe[1].setExperience(1900);
        Scanner scan=new Scanner(System.in);
        scan.nextLine();
        System.out.println(herosOccupe[1].toString());*/
        Degree x = new Degree(5);
		Degree y = new Degree(2);
		Degree z = new Degree(20);

		System.out.println(herosOccupe[1].getAttaque());

		
		Cote a_essayer = new Cote("Cote", x, y , y, "");
		System.out.println(herosOccupe[1].getDefense());
		System.out.println(herosOccupe[1].getInitiative());
		System.out.println(herosOccupe[1].getEsquive());	
		
		herosOccupe[1].equiper(a_essayer);
		System.out.println(herosOccupe[1].getAttaque());

	//	herosOccupe[1].setInitiative(Degree.soustraction(herosOccupe[1].getInitiative(), herosOccupe[1].getTorse().getEncombrement()));
	//	herosOccupe[1].setEsquive(Degree.soustraction(herosOccupe[1].getEsquive(),herosOccupe[1].getTorse().getEncombrement()));
	//	herosOccupe[1].setDefense(Degree.somme(herosOccupe[1].getDefense(), herosOccupe[1].getTorse().getSolidite()));
		
		System.out.println(herosOccupe[1].getDefense());
		System.out.println(herosOccupe[1].getInitiative());
		System.out.println(herosOccupe[1].getEsquive());	
		
		herosOccupe[1].equiper(DEFAULT_TORSE);
		System.out.println(herosOccupe[1].getAttaque());
		System.out.println(herosOccupe[1].getDefense());
		System.out.println(herosOccupe[1].getEsquive());
		System.out.println(herosOccupe[1].getInitiative());

		/*
		
		System.out.println(herosOccupe[1].getdAgilite());
		System.out.println(herosOccupe[1].getdConstitution());
		System.out.println(herosOccupe[1].getDefense());
		System.out.println(herosOccupe[1].getInitiative());
		/*
		try {
			batonbois = new Baton("Baton en bois", x, z, y, " ");
		} catch (ExceptionArme e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<Arme> epeeLourde = null;
		try {
			epeeLourde = CreationArme.creationEpeeLourdes();
		} catch (ExceptionArme e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		herosOccupe[1].equiper(epeeLourde.get(0));
		System.out.println(herosOccupe[1].getDegats());

		herosOccupe[1].equiper(batonbois);
		System.out.println(herosOccupe[1].getDegats());

	System.out.println(herosOccupe[1].getDegats());
		Arme epeeLegere = null;
		try{
			epeeLegere = new EpeeLegere("Epee Legere", z,y, " ");
		}catch(ExceptionArme e){
			e.printStackTrace();
		}
		
		herosOccupe[1].equiper(epeeLegere);
		System.out.println(herosOccupe[1].getDegatsM());

		System.out.println(herosOccupe[1].getDegats());
		System.out.println(herosOccupe[1].mainDroite.affichageCaracteristique());
		System.out.println(herosOccupe[1].mainGauche.affichageCaracteristique());


    */
    }	
}
