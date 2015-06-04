package Objets;

import jobs.Degree;

public class Arme extends Objet{
	


	private Degree impactArme;
	private Degree maniabilite;
	private Degree impactMagique;
	private String description;
	private int nombreMain;
	private int portee;
	public static final int UNEMAIN = 1;
	public static final int DEUXMAINS = 2;
	
	public Arme(){
		super("Arme futile");
	}
	public Arme(String nomArme, Degree impactArme, Degree maniabilite, String description){
		super(nomArme);
		this.impactArme = impactArme;
		this.maniabilite = maniabilite; 
		this.description = description;
	}
	
	public Arme(String nomArme, Degree impactArme,Degree impactMagique, Degree maniabilite,  String description){
		super(nomArme);
		this.impactArme = impactArme;
		this.maniabilite = maniabilite;
		this.impactMagique = impactMagique;
		this.description = description;
	}

	public Arme(String nomArme, Degree impactArme, Degree maniabilite, int nombreMain, String description){
		super(nomArme);
		this.impactArme = impactArme;
		this.maniabilite = maniabilite;
		this.description = description;
		this.setNombreMain(nombreMain);
	}
	
	public Arme(String nomArme, int impactArme, int maniabilite, String description, int nombreMain) {
		super(nomArme);
		this.impactArme = new Degree(impactArme);
		this.maniabilite = new Degree(maniabilite);
		this.description = description;
		this.setNombreMain(nombreMain);
	}

	public Degree getImpactArme() {
		return impactArme;
	}

	public void setImpactArme(Degree impactArme) {
		this.impactArme = impactArme;
	}

	public Degree getManiabilite() {
		return maniabilite;
	}

	public void setManiabilite(Degree maniabilite) {
		this.maniabilite = maniabilite;
	}

	public Degree getImpactMagique() {
		return impactMagique;
	}

	public void setImpactMagique(Degree impactMagique) {
		this.impactMagique = impactMagique;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public int getNombreMain() {
		return nombreMain;
	}

	public void setNombreMain(int nombreMain){
		if(nombreMain == 1)
			this.nombreMain = UNEMAIN;
		else
			this.nombreMain = DEUXMAINS;
	}

	public int getPortee() {
		return portee;
	}

	public void setPortee(int portee) {
		this.portee = portee;
	}

	public String toString() { 
		if(this.getClass().getSimpleName().equals("Baton")|| this.getClass().getSimpleName().equals("BaguetteMagique"))
			return super.toString()+ ", impactArme=" + impactArme + ", impactMagique="+ impactMagique +
					", maniabilite="+ maniabilite + ", nombreMain=" + nombreMain;
			return super.toString()+ ", impactArme=" + impactArme + ", maniabilite="
				+ maniabilite + ", nombreMain=" + nombreMain + "\n";
	} 

	public static void main(String args[]) throws ExceptionArme{
		Degree x = new Degree(5);
		Degree y = new Degree(2);
		Arme epeebois;
		epeebois = new EpeeLourde("Epee en bois", x, y, " ");
		System.out.println(epeebois);

		
	}
}
