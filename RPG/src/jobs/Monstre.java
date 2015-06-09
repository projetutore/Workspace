package jobs;

import java.util.ArrayList;
import java.util.ListIterator;

import carte.Elements;

public class Monstre extends Personnage implements Elements {
    private int experienceDonnee;

    public Type type;

    public Monstre(String nom, int vie, int mana, int force, int intelligence, int agilite,
    		int constitution,int resistance, int maxPa, Type type, int experienceDonnee) 
    throws PersonnageCarException{
		super(nom, vie, mana, force, intelligence, agilite, constitution, resistance, maxPa);
    	if(vie <=0 || mana<=0 || force <0 || intelligence<0 || agilite< 0 || constitution < 0 || resistance <0
    			|| maxPa <0){
    		throw new PersonnageCarException("");
    	}
    	this.setdForce(new Degree(force));
    	this.setdIntelligence(new Degree(intelligence));
    	this.setdAgilite(new Degree(agilite));
    	this.setEsquive(new Degree(agilite));
    	this.setdConstitution(new Degree(constitution));
    	this.setdResistance(new Degree(resistance));
    	this.setMaxPa(maxPa) ;this.setPa(maxPa);
    	this.remiseDegree();
    	System.out.println(this.getEsquive() + " esquive du monstre");
    	System.out.println(this.getDefense()+ " defense du monstre");
        this.type = type;
        this.experienceDonnee = experienceDonnee;
    }
    
    public Monstre(Monstre choisi) {
        super(choisi);
        this.type = choisi.getType();
        this.experienceDonnee = this.getExperienceDonnee();
        this.setdForce(new Degree(choisi.getForce()));
    	this.setdIntelligence(new Degree(choisi.getIntelligence()));
    	this.setdAgilite(new Degree(choisi.getAgilite()));
    	this.setEsquive(new Degree(choisi.getAgilite()));
    	this.setdConstitution(new Degree(choisi.getConstitution()));
    	this.setdResistance(new Degree(choisi.getResistance()));
    	this.setMaxPa(choisi.getMaxPa()) ;this.setPa(choisi.getPa());
    	this.remiseDegree();
    }

    public Monstre() {
		// TODO Auto-generated constructor stub
	}

	public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getExperienceDonnee() {
        return experienceDonnee;
    }

    public void setExperienceDonnee(int experienceDonnee) {
        this.experienceDonnee = experienceDonnee;
    }
    
    public int intelligenceArtificiel(Heros h) {
    	return 0;
    }




	@Override
	public void remiseDegree() {
		this.setdForce(new Degree(this.getForce()));
		this.setdIntelligence(new Degree(this.getIntelligence()));
		this.setdConstitution(new Degree(this.getConstitution()));
		this.setdAgilite(new Degree(this.getAgilite()));
		this.setdResistance(new Degree(this.getResistance()));
		this.setDegats(this.getdForce());
		this.setAttaque(this.getdAgilite());
		this.setInitiative(this.getdAgilite());
		this.setEsquive(this.getdAgilite());
		this.setDefense(this.getdConstitution());		
		this.setDefenseM(this.getdResistance());
	}
	
	public String toString(){
		return "M";
	}
	public String stringStats(){
		return this.getNom() + " VIE:"+this.getMaxVie() + " MANA: " + this.getMaxMana() + " FOR: "+this.getdForce()+
		" INT: " + this.getdIntelligence() + " AGI:" + this.getdAgilite() + " CONS: " + this.getdConstitution() +
		" RES: " + this.getdResistance();
	}
	public Monstre formationMonstre() throws PersonnageCarException{
		Monstre x =  new Monstre("Bombo", 200, 100, -2, 12, 14, 8, 6, 10, null, 20);
		return x;
	}
	
	public static void afficheCollectionMonstre(ArrayList <Monstre> colMonstre){
				int indice =0;

				for (Monstre m : colMonstre){
					System.out.println("Monstre " + indice + " de la collection => " + m.affichageCaracteristique());
					indice++;
				}
				System.out.println("\n");
	}
	
	public static void afficheCollectionMonstreAttaque(ArrayList <Monstre> colMonstre){
				int indice =0;

				for (Monstre m : colMonstre){
					System.out.println((indice+1) +" - " + m.affichageCaracteristique());
					indice++;
				}
				System.out.println("\n");
	}
	public static ArrayList<Monstre> ajoutMonstreType() throws PersonnageCarException{
		Type bombo = new Bombo();
		ArrayList <Monstre> monstreCollec = new ArrayList<Monstre>();
		ArrayList <Monstre> bomboCollec = new ArrayList<Monstre>();
		ArrayList <Monstre> ogreCollec =new ArrayList<Monstre>();
		Monstre bomboFeu =  new Monstre("Bombo de Feu", 100, 100, 4, 12, 2, 8, 6, 10, bombo, 20);
		Monstre grandBomboFeu = new Monstre("Grand Bombo de Feu", 100, 100, 5, 12, 14, 8, 6, 10, bombo, 20);
		bomboCollec.add(bomboFeu);
		bomboCollec.add(grandBomboFeu);
	//	Monstre.afficheCollectionMonstre(bomboCollec);
	//	Monstre.afficheCollectionMonstre(ogreCollec);
	//	Monstre.afficheCollectionMonstre(bomboCollec);
		monstreCollec.addAll(ogreCollec);
		monstreCollec.addAll(0,bomboCollec);
	//	Monstre.afficheCollectionMonstre(monstreCollec);
		Monstre bomboGeant= new Monstre("Bombo Geant", 1000, 400, 40,20,20,15,20, 40, bombo, 100);

		return bomboCollec;
	}
	
	public static void main(String args[]){
		try{
			Monstre.ajoutMonstreType();
		}catch(PersonnageCarException e){}
		
	}



	@Override
	public String affichageCaracteristique() {
		// TODO Auto-generated method stub
		return  getNom() + "\nVIE:" + getVie() + ", MANA:" + getMaxMana() +
        		" FOR: " + getForce() + " INT: " + getIntelligence()
                + " AGI: " + getAgilite() +  " CONS: " + getConstitution()
                + " RES: " + getResistance() + "\nPA:" + getPa() + "/"+getMaxPa();
	}
}