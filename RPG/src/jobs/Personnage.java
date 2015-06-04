package jobs;

public abstract class Personnage {
    private String nom;

    private int vie, maxVie, mana, maxMana, force, intelligence, agilite, constitution, resistance, pa, maxPa;

    private Degree dForce;
    private Degree dIntelligence;
    private Degree dConstitution;
    private Degree dAgilite;
    private Degree dResistance;
    private Degree attaque;
    private Degree degats;
    private Degree degatsM;

    public Personnage(){
    	this.nom = "Inconnu";
    }


    public Personnage(String nom, int vie, int mana, int force,
			int intelligence, int agilite, int constitution, int resistance,
			int pa) {
		this.nom = nom;
		this.vie = this.maxVie = vie;
		this.mana = this.maxMana = mana;
		this.force = force;
		this.intelligence = intelligence;
		this.agilite = agilite;
		this.constitution = constitution;
		this.resistance = resistance;
		this.pa = pa = this.maxPa;
        this.dForce = new Degree(this.force);
        this.dIntelligence = new Degree(this.intelligence);
        this.dConstitution = new Degree(this.constitution);
        this.dAgilite = new Degree(this.agilite);
        this.dResistance = new Degree(this.resistance);
        }

    public Personnage(Personnage choisi) {
        this.nom = new String(choisi.getNom());
        this.vie = this.maxVie = choisi.getVie();
        this.mana = this.maxMana = choisi.getMana();
        this.force= choisi.getForce();
        this.intelligence = choisi.getIntelligence();
        this.agilite = choisi.getAgilite();
        this.constitution = choisi.getConstitution();
        this.resistance = choisi.getResistance();
        this.pa =  this.maxPa = choisi.getPa() ;
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

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }


    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getAgilite() {
        return agilite;
    }

    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
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

    public Degree getdForce() {
		return dForce;
	}

	public void setdForce(Degree dForce) {
		this.dForce = dForce;
	}

	public Degree getdIntelligence() {
		return dIntelligence;
	}

	public void setdIntelligence(Degree dIntelligence) {
		this.dIntelligence = dIntelligence;
	}

	public Degree getdConstitution() {
		return dConstitution;
	}

	public void setdConstitution(Degree dConstitution) {
		this.dConstitution = dConstitution;
	}

	public Degree getdAgilite() {
		return dAgilite;
	}

	public void setdAgilite(Degree dAgilite) {
		this.dAgilite = dAgilite;
	}

	public Degree getdResistance() {
		return dResistance;
	}

	public void setdResistance(Degree dResistance) {
		this.dResistance = dResistance;
	}

	public Degree getAttaque() {
		return attaque;
	}

	public void setAttaque(Degree attaque) {
		this.attaque = attaque;
	}

	public Degree getDegats() {
		return degats;
	}

	public void setDegats(Degree degats) {
		this.degats = degats;
	}

	public Degree getDegatsM() {
		return degatsM;
	}


	public void setDegatsM(Degree degatsM) {
		this.degatsM = degatsM;
	}


	public int getMaxMana() {
		return maxMana;
	}
	
	public abstract void remiseAttaque();
	public abstract void remiseDegats();
	public abstract void remiseDegatsM();
	public abstract void remiseDegree();
	
    public String toString() {
        return  nom + "\nVIE:" + maxVie + ", MANA:" + maxMana +
        		" FOR: " + force + " INT: " + intelligence
                + " AGI: " + agilite +  " CONS: " + constitution
                + " RES: " + resistance + "\nPA:" + pa + "/"+maxPa;
    }
    
    public String toStringCaracteristique(){
    	return "FOR : " + force + "   INT : " + intelligence
        + "\nAGI : " + agilite +  "    CONS : " + constitution
        + "\nRES : " + resistance;
    }
    
 	public static void main(String[] args) {
        Heros paris = new Heros();
    	System.out.println(paris);
    }
}
