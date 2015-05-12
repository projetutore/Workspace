package Objets;

import jobs.Degree;

public class Arme extends Objet{
	


	private Degree impactArme;
	private Degree maniabilite;
	private String description;
	private int nombreMain;
	public static final int UNEMAIN = 1;
	public static final int DEUXMAINS = 2;
	
	
	public Arme(String nomArme, Degree impactArme, Degree maniabilite, String description, int nombreMain ) {
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

	@Override
	public String toString() {
		return super.toString()+ ", impactArme=" + impactArme + ", maniabilite="
				+ maniabilite + ", description=" + description
				+ ", nombreMain=" + nombreMain + "\n";
	}

	public static void main(String args[]){
		Arme epeebois = new Arme("Epee en bois", 7, 4, "Arme en bois", 1);
		System.out.println(epeebois);
	}
}
