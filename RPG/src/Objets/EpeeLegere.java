package Objets;

import jobs.Degree;

public class EpeeLegere implements Arme {
	private String nomEpeeLegere; 
	private Degree impactEpeeLegere;
	private Degree maniabilite;
	private String description;
	private int portee = 1 ; 
	private int nombreMain = UNEMAIN ;

	
	public EpeeLegere(String nomEpeeLegere, Degree impactEpeeLegere, Degree maniabilite, String description) throws ExceptionArme {
		this.nomEpeeLegere = nomEpeeLegere;
		this.impactEpeeLegere = impactEpeeLegere; 
		this.maniabilite = maniabilite;
	}

	@Override
	public String getNomObjet() {
		return nomEpeeLegere;
	}

	@Override
	public Degree getImpactArme() {
		// TODO Auto-generated method stub
		return impactEpeeLegere;
	}

	@Override
	public Degree getManiabilite() {
		// TODO Auto-generated method stub
		return maniabilite;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	@Override
	public int getNombreMain() {
		// TODO Auto-generated method stub
		return nombreMain;
	}

	@Override
	public int getPortee() {
		// TODO Auto-generated method stub
		return portee;
	}

	public String toString(){
		return "O";
	}
	@Override
	public String affichageCaracteristique() {
		// TODO Auto-generated method stub
		return  nomEpeeLegere +"\nImpactArme: "+ impactEpeeLegere + "; Maniabilite:"+ maniabilite +"\nPortee = " + portee
				+ "; NombreMain = " + nombreMain;
	}

	@Override
	public Degree getImpactMagique() {
		// TODO Auto-generated method stub
		return new Degree();
	}

	public String emplacementEquipement() {
		// TODO Auto-generated method stub
		return "Main";
	}
}
