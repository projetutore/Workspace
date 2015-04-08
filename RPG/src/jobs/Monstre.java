package jobs;

public class Monstre extends Personnage{

	private String type;
	private int experienceDonnee;

	

	public Monstre(Monstre choisi) {
		super(choisi);
		this.type = new String(choisi.getType());
		this.experienceDonnee = this.getExperienceDonnee();
		// TODO Auto-generated constructor stub
	}


	public Monstre(String nom, int vie, int maxVie, int mana, int maxMana,
			int force, int maxForce, int intelligence, int maxIntelligence,
			int agilite, int maxAgilite, int constitution, int maxConstitution,
			int resistance, int maxResistance, int pa, int maxPa, String type,
			int experienceDonnee) {
		super(nom, vie, maxVie, mana, maxMana, force, maxForce, intelligence,
				maxIntelligence, agilite, maxAgilite, constitution, maxConstitution,
				resistance, maxResistance, pa, maxPa);
		this.type = type;
		this.experienceDonnee = experienceDonnee;
		// TODO Auto-generated constructor stub
	}

	public Monstre(String nom, int maxVie, int maxMana,
			 int maxForce,  int maxIntelligence, int maxAgilite,
			 int maxConstitution, int maxResistance, int maxPa, String type, int experienceDonnee) {
		super(nom, maxVie,  maxMana, maxForce, 
				maxIntelligence, maxAgilite,  maxConstitution,
				 maxResistance,  maxPa);
		this.type = type;
		this.experienceDonnee = experienceDonnee;
	}


	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public int getExperienceDonnee() {
		return experienceDonnee;
	}

	public void setExperienceDonnee(int experienceDonnee) {
		this.experienceDonnee = experienceDonnee;
	}

	public int attaqueSelonHeros(Heros h) {
		if(h.getVie()>80*(h.getMaxVie()/100) && this.getVie()>80*(this.getMaxVie()/100))
			return 1;
		else if(h.getVie()>40*(h.getMaxVie()/100) && this.getVie()>60*(this.getMaxVie()/100))
			return 2;
		else if(this.getVie()< 40*(this.getMaxVie()/100))
			return 3;
		return 0;
	}
	@Override
	public String toString() {
		return "Monstre [type=" + type + "]";
	}
	
	
}
