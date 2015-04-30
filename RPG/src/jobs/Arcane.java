package jobs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("b0b9c453-102d-481a-aefd-e70abc8e9936")
public class Arcane {
    @objid ("d8ac0a73-3846-4d49-b9d7-9f83499fb1b9")
    private String nomArcane;

    @objid ("84a6851b-5a1c-4e4a-aa38-8bd5de51b5b5")
    private int degatsArcane;

    @objid ("c3f3bbcb-c7e9-46fb-8005-a3a0572912e4")
    private int coutMana;

    @objid ("4053420a-10a5-40e8-aeca-7235590ec185")
    private int coutPA;

    @objid ("eb44986b-9b22-466e-8809-ec00c04daa88")
    private int nivAcquisition;

    @objid ("c38662f9-b29d-4099-9f8f-b88e367488a4")
    private String description;

    private int dureeIncantation;

    private String ratio;
    
    @objid ("a68052bd-5224-4159-8eb5-0a3d395d031f")
    private Effet[] effetArcane = new Effet[2];

    @objid ("9ce0957a-45b8-4e77-9467-dd0147973eb7")
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
    
    @objid ("c5b94b33-1b10-49d9-b77b-1e05f206fc6c")
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

    @objid ("499a632d-49de-4ff8-a6e9-e743cb631002")
    public int getCoutMana() {
        return coutMana;
    }

    @objid ("f650c184-34fd-4760-a7e7-defac239435f")
    public void setCoutMana(int coutMana) {
        this.coutMana = coutMana;
    }

    @objid ("0b0ef16e-ed5b-4fc9-90f2-9b10a6912fd9")
    public int getCoutPA() {
        return coutPA;
    }

    @objid ("ca146e2e-1ed4-4879-99f2-f0714013866f")
    public void setCoutPA(int coutPA) {
        this.coutPA = coutPA;
    }

    @objid ("5ebd5ac9-59cc-48d5-b529-34c59ee2152b")
    public int getNivAcquisition() {
        return nivAcquisition;
    }

    @objid ("23405a65-f8ad-4090-9a78-895b94b20bd6")
    public void setNivAcquisition(int nivAcquisition) {
        this.nivAcquisition = nivAcquisition;
    }

    @objid ("915f1031-2555-4c3a-9b9e-68600daf3407")
    public String getDescription() {
        return description;
    }

    @objid ("dc36f567-464e-44fb-8056-6ce3b7abd6d6")
    public void setDescription(String description) {
        this.description = description;
    }
    
    @objid ("153aafa7-2fc8-4007-ae21-c132831d42c5")
    public int degatsRatio(Heros x) {
    	int degatsDurantCombat= (int) (this.degatsArcane * + (0.5d)*x.getIntelligence());
        return degatsDurantCombat;
    }

    @objid ("479c7604-fbc1-43af-a185-f23f8c0d200c")
    public String getNomArcane() {
        return nomArcane;
    }

    @objid ("eff14a56-cc88-42f0-bb26-be0a54d3bd50")
    public void setNomArcane(String nomArcane) {
        this.nomArcane = nomArcane;
    }

    @objid ("1e7cc3d3-bdb6-483e-872c-083cdc82cfa3")
    public int getDegatsArcane() {
        return degatsArcane;
    }

    @objid ("d6f60c75-b816-49d4-9555-996d7de3b0b0")
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

	@objid ("6d2b6459-b910-42a4-9e75-7d126a300824")
    public Effet[] getEffetArcane() {
        return effetArcane;
    }
    
    @objid ("a3193f1f-2b58-41c0-84fb-e83e6c53029c")
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
