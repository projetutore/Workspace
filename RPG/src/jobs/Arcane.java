package jobs;

import java.util.Arrays;



public class Arcane {
    private String nomArcane;

    private int degatsArcane;

    private int coutMana;

    private int coutPA;

    private int nivAcquisition;

    private String description;

    private int dureeIncantation;

    private String ratio;
    
    private Effet[] effetArcane = new Effet[2];

    public Arcane() {
        Effet brulure= new Effet("Brulure", 5);
        this.nomArcane = "Arcane";
        this.effetArcane[0] = brulure;
        this.description = "";
        this.dureeIncantation = 0;
        this.ratio = "";
    }

    public Arcane(String nomArcane, int degatsArcane, int coutMana, int coutPA, int nivAcquisition,
    		String description, int dureeIncantation, String ratio, Effet[] effetArcane){
    	this.nomArcane = nomArcane;
    	this.degatsArcane = degatsArcane;
    	this.coutMana = coutMana;
    	this.coutPA = coutPA;
    	this.nivAcquisition = nivAcquisition;
    	this.description = description;
    	this.dureeIncantation = dureeIncantation;
    	this.ratio = ratio;
    	this.effetArcane = effetArcane;
    }
    
    public Arcane(Arcane a) {
    	this.nomArcane = new String(a.getNomArcane());
    	this.degatsArcane = a.getDegatsArcane();
    	this.coutMana = a.getCoutMana();
    	this.coutPA = a.getCoutPA();
    	this.nivAcquisition = a.getNivAcquisition();
    	this.description = new String(a.getDescription());
    	this.dureeIncantation = a.getDureeIncantation();
    	this.effetArcane = a.getEffetArcane();
    }

    public int getCoutMana() {
        return coutMana;
    }

    public void setCoutMana(int coutMana) {
        this.coutMana = coutMana;
    }

    public int getCoutPA() {
        return coutPA;
    }

    public void setCoutPA(int coutPA) {
        this.coutPA = coutPA;
    }

    public int getNivAcquisition() {
        return nivAcquisition;
    }

    public void setNivAcquisition(int nivAcquisition) {
        this.nivAcquisition = nivAcquisition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public int degatsRatio(Heros x) {
    	int degatsDurantCombat= (int) (this.degatsArcane * + (0.5d)*x.getIntelligence());
        return degatsDurantCombat;
    }

    public String getNomArcane() {
        return nomArcane;
    }

    public void setNomArcane(String nomArcane) {
        this.nomArcane = nomArcane;
    }

    public int getDegatsArcane() {
        return degatsArcane;
    }

    public void setDegatsArcane(int degatsArcane) {
        this.degatsArcane = degatsArcane;
    }

    public int getDureeIncantation() {
		return dureeIncantation;
	}

	public void setDureeIncantation(int dureeIncantation) {
		this.dureeIncantation = dureeIncantation;
	}

	public String getRatio() {
		return ratio;
	}

	public void setRatio(String ratio) {
		this.ratio = ratio;
	}

    public Effet[] getEffetArcane() {
        return effetArcane;
    }
    
    public void setEffetArcane(Effet[] effetArcane) {
        this.effetArcane = effetArcane;
    }

    public void coutMana_Niv(Heros h){
    	this.degatsArcane = h.getNiveau(); 
    }
	@Override
	public String toString() {
		return  nomArcane + ", degatsArcane="
				+ degatsArcane + ", coutMana=" + coutMana + ", coutPA="
				+ coutPA + ", nivAcquisition=" + nivAcquisition
				+ ", description=" + description + ", dureeIncantation="
				+ dureeIncantation + ", effetArcane="
				+ Arrays.toString(effetArcane);
	}


}
