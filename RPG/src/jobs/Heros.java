package jobs;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import java.util.Scanner;

@objid ("2205ae55-09e5-4d6b-8984-b9c3e42fc46a")
public class Heros extends Personnage {
	
    @objid ("b4870a1e-0a67-44f0-828b-a651c2812a9e")
    private int horsLimite;

    @objid ("38eed8bc-3656-490d-83ff-01c39df4b026")
    private int experience;

    @objid ("9f7e37e4-b375-484f-b56b-7e5a658dc101")
    private int niveau;

    @objid ("d73c7a32-769e-4db6-ae54-5eaa543ccf96")
    private int creation;

    @objid ("77d7b0da-1851-44a4-a870-bd4bf9bcc0cb")
    private Jobs job;

    @objid ("d44fa5aa-2711-496e-b94f-37d0e162f55b")
    private Arcane[] tabArcaneHeros;

    @objid ("812b20ce-ea4d-4afb-880c-8f03c990260f")
    public Heros() {
        super();
        this.job = new Jobs();
        this.horsLimite = 0;
        this.experience = 0;
        this.niveau = 1;
        this.creation = 0;
        this.tabArcaneHeros = new Arcane[5];
    }

    @objid ("86389886-08b2-456e-9c80-905412b02b19")
    public Heros(String nom, int vie, int maxVie, int mana, int maxMana, int force, int maxForce, int intelligence, 
    		int maxIntelligence, int agilite, int maxAgilite, int constitution, int maxConstitution, int resistance, 
    		int maxResistance, int pa, int maxPa, Jobs job, int horsLimite, int experience, int niveau, 
    		int creation, Arcane[] tabArcaneHeros) {
        super(nom, vie, maxVie, mana, maxMana, force, maxForce, intelligence,
                maxIntelligence, agilite, maxAgilite, constitution,
                maxConstitution, resistance, maxResistance, pa, maxPa);
        this.job = job;
        this.horsLimite = horsLimite;
        this.experience = experience;
        this.niveau = niveau;
        this.creation = creation;
        this.tabArcaneHeros = tabArcaneHeros;
    }

    public Heros(String nom, int maxVie, int maxMana, int maxForce, int maxIntelligence, int maxAgilite, int maxConstitution,
    		int maxResistance, int maxPa, 
    		Jobs job, int horsLimite, int experience, int niveau, 
    		int creation, Arcane[] tabArcaneHeros){
    	super(nom, maxVie, maxMana, maxForce, maxIntelligence, maxAgilite, maxConstitution, maxResistance, maxPa);
    	this.job = job;
        this.horsLimite = horsLimite;
        this.experience = experience;
        this.niveau = niveau;
        this.creation = creation;
        this.tabArcaneHeros = tabArcaneHeros;
    }
    @objid ("c026bb53-5579-4cdc-ad4e-f929dc35edd0")
    public Heros(Heros nomme) {
        super(nomme);
        this.job = new Jobs(nomme.getJob());
        this.horsLimite = nomme.getHorsLimite();
        this.experience = nomme.getExperience();
        this.niveau = nomme.getNiveau();
        this.creation = nomme.getCreation();
        this.tabArcaneHeros =  nomme.getTabArcaneHeros();
    }

   
    @objid ("91724160-b16a-47ce-8a60-14dc45803a9b")
    public Jobs getJob() {
        return job;
    }

    @objid ("f15b331b-e8de-42d8-bcd5-0b461eda5a2f")
    public void setJob(Jobs job) {
        this.job = job;
    }

    @objid ("cc612c0c-4e2b-4d54-8948-74f17f89b366")
    public int getHorsLimite() {
        return horsLimite;
    }

    @objid ("26151899-c89b-44a1-8190-38415f86be48")
    public void setHorsLimite(int horsLimite) {
        this.horsLimite = horsLimite;
    }

    @objid ("ef0ac767-8756-4212-b69f-56534e663632")
    public int getExperience() {
        return experience;
    }

    @objid ("d36df90b-0f56-4899-bef6-048694d8cdb7")
    public void setExperience(int experience) {
        this.experience = experience;
        if (this.experience>=100 && this.niveau <30){
        	this.niveauSuperieur();
        }
    }

    @objid ("3ed59b32-fd46-47f3-9c3c-7888bd68e5ff")
    public int getNiveau() {
        return niveau;
    }

    @objid ("2ce26ff5-1572-44de-bfa9-80f0623367bf")
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    @objid ("3983e511-92e8-499c-b3fa-9319bc11e064")
    public int getCreation() {
        return creation;
    }

    @objid ("f58f3dbf-9276-4084-8925-1409c44d2acc")
    public void setCreation(int creation) {
        this.creation = creation;
    }

    @objid ("9253eff4-5b5c-46f1-a396-85812fd73019")
    public Arcane[] getTabArcaneHeros() {
        return tabArcaneHeros;
    }

    @objid ("6e6b7639-4fd4-4c03-b1a4-d4dc51075647")
    public void setTabArcaneHeros(Arcane[] tabArcaneHeros) {
        this.tabArcaneHeros = tabArcaneHeros;
    }

    public Arcane getArcaneHeros(int i){
    	return tabArcaneHeros[i];
    }
    
    public void setArcaneHeros(int i){
    	this.tabArcaneHeros[i]=this.getJob().getArcaneDeJob(i);
    }
    @objid ("3e71e256-7f58-480b-b584-d2cfb17eb55a")
    public int gainExperience(int xp) {
        return this.experience = this.experience+xp;
    }

    @objid ("4b12bbcf-5109-498f-ac8f-b1ea3834a8e6")
    public void niveauSuperieur() {
                for(@SuppressWarnings("unused")
                int i = 0; this.experience >= 100 && (this.niveau < 30) ; i++) {    
                        this.experience -=100;
                        this.niveau++;
                        System.out.println(this.getNom() +" a pris en puissance, le niveau " + this.niveau + " a �t� atteint.");
                        this.repartitionPoints();
                        }
                     this.experience = 0;
    }

/*
     * Cette fonction sert � cr�er son h�ros, l'utilisateur choisit la classe du h�ros, donne son nom et sa classe 
     * Le tableau de la classe est donc attribu� au h�ros et le premier Arcane de la classe est d�bloqu�.
     */
    @objid ("048660f3-936a-4136-9a33-0ff7295af17b")
    public Heros creationPersonnage() {
        System.out.println("Vous voici � l'heure de la cr�ation de votre personnage\n "+
                "Tout d'abord, comment vous appelerez vous?");
        @SuppressWarnings("resource")
        Scanner creationPersonnage = new Scanner(System.in);
        Heros x = new Heros();
        x.setNom(creationPersonnage.nextLine());
        while(x.getJob().getNomJob()=="Classe"){
        System.out.println("Je vois, c'est donc comme cela que vous avez d�cid� de vous appelez.\n" +
                            "A pr�sent, il est temps de d�cider de votre classe : \n"
                            + "1 - Paladin \n"
                            + "2 - Maraudeur \n"
                            + "3 - Arcaniste \n"
                            + "4 - Lance Rouge \n"
                            + "5 - Bretteur \n"
                            + "6 - Plus d'info sur le personnage"
                            );
        int choix = creationPersonnage.nextInt();
        switch (choix){
        case 1: 
            x.setJob(x.getJob().paladin(x));        
            System.out.println("Votre personnage est donc un Paladin");
            System.out.println(x.getJob());
            break;
        case 2:
            x.setJob(x.getJob().maraudeur(x));    
            break;
        case 3:
            x.setJob(x.getJob().arcaniste(x));        
            break;
        case 4:
            x.setJob(x.getJob().lanceRouge(x));        
            break;
        case 5:
            x.setJob(x.getJob().bretteur(x));        
            break;
        case 6:
            System.out.println("Le Paladin :  c'est un protecteur, de ce fait, "
                                + "il est beaucoup plus r�sistant que tout autre classe, cependant, "
                                + "ses coups sont de qualit��s moyennes et il est assez lent, cependant"
                                + "il cro�t de mani�re naturelle dans toute les stats sans exceller dans une seule.\n"
                                + "Le Maraudeur : un �tre habitu� � vivre dans les zones difficiles et ayant pour habitude de se d�brouiller sans aucun probl�me"
                                + "de ce fait, il est agile et excelle dans les coups puissants."
                                + "Cependant, la fusion des deux lui emp�che d'agir rapidement,\n"
                                + "sa puissance lui permet donc de finir ses adversaires rapidement,"
                                + "de ne plus pouvoir agir et se faire attaquer. \n"
                                + "L'Arcaniste : il s'agit d'un �tre qui s'est exclusivement concentr� sur les arcanes. \n"
                                + "De nature intelligente et sage, ils combattent tr�s peu au corps et disposent donc d'une force en dessous de la moyenne.\n"
                                + "Cependant, ils sont entrain��s � r�sister au coup et de plus, ils usent d'arcanes protecteur pour se prot�ger durant le temps"
                                + "d'invocations de ses Arcanes.\n"
                                + "La Lance Rouge : des lanciers dont les coups et les arcanes sont d�vastateurs, cependant, du fait d'utilisation de lance, "
                                + "ils sont assez fragiles, sans doute les plus fragiles d'entre tous. \n"
                                + "Le Bretteur : Des �peistes hors-pair, d'une agilit� deconcertante et d'une pr�cision ph�nomenale, ses coups sont pr�cis et "
                                + "f�roces."
                                );
            break;
        }
            }
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

    
    @objid ("beb4b89f-c440-4561-a009-f417f89a0815")
    @Override
    public String toString() {
        return   job +" "+ super.toString()+"\nhorsLimite=" + horsLimite + ", experience=" + experience
                        + ", niveau=" + niveau + ", creation=" + creation + ", Arcane =" + toStringTabArcaneHeros() + "]";
    }
    
    public void repartitionPoints(){
    	int pointRestant = 8;
    	Scanner pointArentrer = new Scanner(System.in);
    	Scanner valider =  new Scanner(System.in);
    	do {
    		System.out.println("Que souhaitez-vous augmenter?");
    		int stat = pointArentrer.nextInt();
    		switch(stat){
	    		case 0:
	    			System.out.println("De combien de points voulez-vous augmenter votre vie?");
	    		int nombrePoint = pointArentrer.nextInt(); 
	    		while(nombrePoint > pointRestant){
	    			System.out.println("Combien de points?");
	    			nombrePoint = pointArentrer.nextInt();
	    			}
	    			System.out.println("Valider?");
	    			String validation = valider.next();
	    			switch(validation){
	    			case "oui": 
	    				this.setMaxVie(this.getMaxVie()+nombrePoint);
	    				pointRestant = pointRestant-nombrePoint; 
	    			case "non":
    				
    			}
    		}
    	}while (pointRestant>0);
    }
    
    public int ameliorationStatistique(int stat){
    	return 0;
    }
    @objid ("05623be2-3406-4f24-9764-9f2fe13bbbfa")
    public static void main(String[] args) {
        Heros[] herosOccupe = new Heros[500];
        Heros heros = new Heros();
        
        herosOccupe[1] = heros.creationPersonnage();    
        herosOccupe[1].setExperience(100);
        
        System.out.println(herosOccupe[1].toString());
        Type baleine = new Type("Baleine" , null);
        Monstre monstre = new Monstre("Gluant", 200, 50, 30, 10,10, 14, 4, 3, baleine, 80);
   
        
        Combat xy = new Combat(herosOccupe[1], monstre);
    }

}
