package jobs;

public class Personnage {

	private String nom = new String();
	private int vie;
	private int maxVie;
	private int mana;
	private int maxMana;
	private int force;
	private int maxForce;
	private int intelligence;
	private int maxIntelligence;
	private int agilite;
	private int maxAgilite;
	private int constitution;
	private int maxConstitution;
	private int resistance;
	private int maxResistance;
	private int pa;
	private int maxPa;
	
	public Personnage(){
		this.nom = "Inconnu";
	}
	
	public Personnage(String nom, int maxVie, int maxMana, int maxForce, int maxIntelligence,
			int maxAgilite, int maxConstitution, int maxResistance, int maxPa ) {
		this.nom = nom;
		this.vie = this.maxVie = maxVie;
		this.mana = this.maxMana = maxMana;
		this.force = this.maxForce = maxForce;
		this.intelligence = this.maxIntelligence = maxIntelligence;
		this.agilite = this.maxAgilite = maxAgilite;
		this.constitution = this.maxConstitution = maxConstitution;
		this.resistance = this.maxResistance = maxResistance;
		this.pa = this.maxPa = maxPa;
	}

	public Personnage(String nom, int vie, int maxVie, int mana, int maxMana,
			int force, int maxForce, int intelligence, int maxIntelligence,
			int agilite, int maxAgilite, int constitution, int maxConstitution,
			int resistance, int maxResistance, int pa, int maxPa) {
		this.nom = nom;
		this.vie = vie;
		this.maxVie = maxVie;
		this.mana = mana;
		this.maxMana = maxMana;
		this.force = force;
		this.maxForce = maxForce;
		this.intelligence = intelligence;
		this.maxIntelligence = maxIntelligence;
		this.agilite = agilite;
		this.maxAgilite = maxAgilite;
		this.constitution = constitution;
		this.maxConstitution = maxConstitution;
		this.resistance = resistance;
		this.maxResistance = maxResistance;
		this.pa = pa;
		this.maxPa = maxPa;
	}



	public Personnage(Personnage choisi) {
		this.nom = new String(choisi.getNom());
		this.vie = choisi.getVie();
		this.mana = choisi.getMana();
		this.force= choisi.getForce();
		this.intelligence = choisi.getIntelligence();
		this.agilite = choisi.getAgilite();
		this.constitution = choisi.getConstitution();
		this.pa = choisi.getPa();
	}
	
	public void defense(){

	}
	

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public int getMaxVie() {
		return maxVie;
	}

	public void setMaxVie(int maxVie) {
		this.maxVie = maxVie;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getMaxForce() {
		return maxForce;
	}

	public void setMaxForce(int maxForce) {
		this.maxForce = maxForce;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getMaxIntelligence() {
		return maxIntelligence;
	}

	public void setMaxIntelligence(int maxIntelligence) {
		this.maxIntelligence = maxIntelligence;
	}

	public int getAgilite() {
		return agilite;
	}

	public void setAgilite(int agilite) {
		this.agilite = agilite;
	}

	public int getMaxAgilite() {
		return maxAgilite;
	}

	public void setMaxAgilite(int maxAgilite) {
		this.maxAgilite = maxAgilite;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getMaxConstitution() {
		return maxConstitution;
	}

	public void setMaxConstitution(int maxConstitution) {
		this.maxConstitution = maxConstitution;
	}

	public int getResistance() {
		return resistance;
	}

	public void setResistance(int resistance) {
		this.resistance = resistance;
	}

	public int getMaxResistance() {
		return maxResistance;
	}

	public void setMaxResistance(int maxResistance) {
		this.maxResistance = maxResistance;
	}

	public int getPa() {
		return pa;
	}

	public void setPa(int pa) {
		this.pa = pa;
	}

	public int getMaxPa() {
		return maxPa;
	}

	public void setMaxPa(int maxPa) {
		this.maxPa = maxPa;
	}

	public void setStatistiques(){
	//	this.vie = this.maxVie;
	//	this.mana = this.maxMana;
		this.force = this.maxForce;
		this.intelligence = this.maxIntelligence;
		this.constitution = this.maxConstitution;
		this.agilite = this.maxAgilite;
	}
	@Override
	public String toString() {
		return  nom + ", Vie=" + maxVie + ", mana=" + maxMana
				+ ", force=" + maxForce + ", intelligence=" + maxIntelligence
				+ ", agilite=" + maxAgilite + ", constitution=" + maxConstitution
				+ ", pa=" + maxPa;
	}

}
