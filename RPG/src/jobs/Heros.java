package jobs;

import Objets.Arme;

import java.util.Scanner;

public class Heros extends Personnage {
	
    /**
     * Un heros possède une experience
     * integer. 
     */
    private int experience;

    private int niveau;

    private Jobs job;

    private Arcane[] tabArcaneHeros;

    private Arme mainDroite = new Arme("MainDroite", 0, 0, null, 1); 
    private Arme mainGauche = new Arme("Maingauche", 0, 0, null, 1);

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
        this.job = new Jobs();
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
    		int resistance, int maxPa, Jobs job, Arcane[] tabArcaneHeros,
			Arme mainDroite, Arme mainGauche) {
		super(nom, vie, mana, force, intelligence, agilite, constitution, resistance, maxPa);
		this.niveau = 1;
		this.job = job;
		this.tabArcaneHeros = tabArcaneHeros;
		this.mainDroite = mainDroite;
		this.mainGauche = mainGauche;
        this.remiseAttaque();
        this.remiseDegats();
	}
   
    public Jobs getJob() {
        return job;
    }

    public void setJob(Jobs job) {
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

    public Arcane getArcaneHeros(int i){
    	return tabArcaneHeros[i];
    }
    
    public void setArcaneHeros(int i){
    	this.tabArcaneHeros[i]=this.getJob().getArcaneDeJob(i);
    }
    public Arme getMainDroite() {
		return mainDroite;
	}

	public void setMainDroite(Arme mainDroite) {
		this.mainDroite = mainDroite;
	}

	public Arme getMainGauche() {
		return mainGauche;
	}

	public void setMainGauche(Arme mainGauche) {
		this.mainGauche = mainGauche;
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

/*
     * Cette fonction sert à créer son héros, l'utilisateur choisit la classe du héros, donne son nom et sa classe 
     * Le tableau de la classe est donc attribué au héros et le premier Arcane de la classe est débloqué.
     */
    public Heros creationPersonnage() {
        System.out.println("Vous voici à l'heure de la création de votre personnage\n "+
                "Tout d'abord, comment vous appelerez vous?");
        @SuppressWarnings("resource")
        Scanner creationPersonnage = new Scanner(System.in);
        Heros x = new Heros();
        x.setNom(creationPersonnage.nextLine());
        while(x.getJob().getNomJob()=="Classe"){
        System.out.println("Je vois, c'est donc comme cela que vous avez décidé de vous appelez.\n" +
                            "A présent, il est temps de décider de votre classe : \n"
                            + "1 - Paladin \n"
                            + "2 - Maraudeur \n"
                            + "3 - Arcaniste \n"
                            + "4 - Lance Rouge \n"
                            + "5 - Bretteur \n"
                            );
        int choix = creationPersonnage.nextInt();
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
		this.setDegats(new Degree(Degree.somme(this.getdForce(), this.getMainDroite().getImpactArme())));
		this.setAttaque(new Degree(Degree.somme(this.getdAgilite(), this.getMainDroite().getManiabilite())));
	}
	
	public void remiseAttaque() {
		this.setDegats(new Degree(Degree.somme(this.getdForce(), this.getMainDroite().getImpactArme())));
	}

	public void remiseDegats() {
		this.setAttaque(new Degree(Degree.somme(this.getdAgilite(), this.getMainDroite().getManiabilite())));
	}

 	public String toString() {
 		return job + " " + super.toString() + " experience=" + experience
 				+ ", niveau=" + niveau + "\nArme :" + mainDroite + ", mainGauche=" + mainGauche
 				+ ", degats=" + this.getDegats();
 	}

 	public static void main(String[] args) {
        Heros[] herosOccupe = new Heros[500];
        Heros heros = new Heros();
        
        herosOccupe[1] = heros.creationPersonnage();    
        herosOccupe[1].setExperience(1900);
        @SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
        scan.nextLine();
        System.out.println(herosOccupe[1].toString());
        Type baleine = new Type("Baleine" , null);
        Monstre monstre = new Monstre("Gluant", 200, 50, 30, 10,10, 14, 4, 3, baleine, 80);
   
        @SuppressWarnings("unused")
		Combat xy = new Combat(herosOccupe[1], monstre);
    }



}
