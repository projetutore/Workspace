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
    	this.setdConstitution(new Degree(constitution));
    	this.setdResistance(new Degree(resistance));
    	this.setMaxPa(maxPa) ;this.setPa(maxPa);
        this.type = type;
        this.experienceDonnee = experienceDonnee;
    }
    
    public Monstre(Monstre choisi) {
        super(choisi);
        this.type = choisi.getType();
        this.experienceDonnee = this.getExperienceDonnee();
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


	public void remiseAttaque() {
		
	}

	@Override
	public void remiseDegats() {
		
	}

	@Override
	public void remiseDegree() {
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
					System.out.println("Monstre " + indice + " de la collection => " + m);
					indice++;
				}
				System.out.println("\n");
	}
	
	public static void ajoutMonstreType() throws PersonnageCarException{
		Type bombo = new Type("Bombo",null);
		Type ogre = new Type("Ogre", null);
		ArrayList <Monstre> monstreCollec = new ArrayList<Monstre>();
		ArrayList <Monstre> bomboCollec = new ArrayList<Monstre>();
		ArrayList <Monstre> ogreCollec =new ArrayList<Monstre>();
		Monstre bomboFeu =  new Monstre("Bombo de Feu", 200, 100, 4, 12, 14, 8, 6, 10, bombo, 20);
		Monstre grandBomboFeu = new Monstre("Grand Bombo de Feu", 200, 100, 5, 12, 14, 8, 6, 10, bombo, 20);
		Monstre ogreJeune = new Monstre("Jeune Ogre", 50, 25, 4, 8,6,8, 12, 8, ogre, 20);
		Monstre ogreAdulte = new Monstre("Ogre Adulte", 100, 50, 8, 16, 12, 16, 24, 16, ogre, 50);
		bomboCollec.add(bomboFeu);
		bomboCollec.add(grandBomboFeu);
		ogreCollec.add(ogreJeune);
	//	Monstre.afficheCollectionMonstre(bomboCollec);
	//	Monstre.afficheCollectionMonstre(ogreCollec);
		ogreCollec.add(1, ogreAdulte);
	//	Monstre.afficheCollectionMonstre(bomboCollec);
		monstreCollec.addAll(ogreCollec);
		monstreCollec.addAll(0,bomboCollec);
	//	Monstre.afficheCollectionMonstre(monstreCollec);
		Monstre bomboGeant= new Monstre("Bombo Geant", 1000, 400, 40,20,20,15,20, 40, bombo, 100);
		monstreCollec.set(0, bomboGeant);
		monstreCollec.get(0);
		Heros a = new Heros();
	//Monstre.afficheCollectionMonstre(monstreCollec);
		ListIterator<Monstre> i = monstreCollec.listIterator();
		System.out.println(monstreCollec.isEmpty());
			while(i.hasNext()){
				if(i.next().getType().equals(ogre)){
					i.remove();
			}
				Monstre.afficheCollectionMonstre(monstreCollec);
		}
	}
	
	public static void main(String args[]){
		try{
			Monstre.ajoutMonstreType();
		}catch(PersonnageCarException e){}
		
	}

	@Override
	public void remiseDegatsM() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String afficherm() {
		// TODO Auto-generated method stub
		return null;
	}
}