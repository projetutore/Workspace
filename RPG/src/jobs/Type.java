package jobs;

public class Type {
    private String nomType;

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
