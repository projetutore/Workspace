package jobs;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("7f6c4969-d33a-449f-8b22-c02b92487ec8")
public class Type {
    @objid ("92e51e4f-00cd-41dc-8243-01be5cb36d0f")
    private String nomType;

    @objid ("ae4117f9-607b-40e4-b674-408fe0f1619d")
    private Arcane[] tabArcaneMonstre;
    
    public Type(){
    	this.nomType = "";
    }

    public Type(String nomType, Arcane[] tabArcaneMonstre){
    	this.nomType = nomType;
    	this.tabArcaneMonstre = tabArcaneMonstre;
    }
    
    public Type(Type t){
    	this.nomType = new String(t.getNomType());
    	this.tabArcaneMonstre = t.getTabArcaneMonstre();
    }
	public String getNomType() {
		return nomType;
	}

	public void setNomType(String nomType) {
		this.nomType = nomType;
	}

	public Arcane[] getTabArcaneMonstre() {
		return tabArcaneMonstre;
	}

	public void setTabArcaneMonstre(Arcane[] tabArcaneMonstre) {
		this.tabArcaneMonstre = tabArcaneMonstre;
	}
    
}
