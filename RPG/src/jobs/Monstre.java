package jobs;

public class Monstre extends Personnage{

	private String type;

	public Monstre(String type) {
		super();
		this.type = type;
	}
	

	public Monstre(Monstre choisi) {
		super(choisi);
		this.type = new String(choisi.getType());
		// TODO Auto-generated constructor stub
	}


	public Monstre(String nom, int vie, int maxVie, int mana, int maxMana,
			int force, int maxForce, int intelligence, int maxIntelligence,
			int agilite, int maxAgilite, int constitution, int maxConstitution,
			int resistance, int maxResistance, int pa, int maxPa, String type) {
		super(nom, vie, maxVie, mana, maxMana, force, maxForce, intelligence,
				maxIntelligence, agilite, maxAgilite, constitution, maxConstitution,
				resistance, maxResistance, pa, maxPa);
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	public Monstre(String nom, int maxVie, int maxMana,
			 int maxForce,  int maxIntelligence, int maxAgilite,
			 int maxConstitution, int maxResistance, int maxPa, String type) {
		super(nom, maxVie,  maxMana, maxForce, 
				maxIntelligence, maxAgilite,  maxConstitution,
				 maxResistance,  maxPa);
		this.type = type;
	}


	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Monstre [type=" + type + "]";
	}
	
	
}
