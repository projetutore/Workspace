package Objets;

import jobs.Degree;

public class EpeeLourde implements Arme {
	private String nomEpeeLourde; 
	private Degree impactEpeeLourde;
	private Degree maniabilite;
	private String description;
	private int portee = 1 ; 
	private int nombreMain = DEUXMAINS ;

	
	public EpeeLourde(String nomEpeeLourde, Degree impactEpeeLourde, Degree maniabilite, String description) throws ExceptionArme {
		this.nomEpeeLourde = nomEpeeLourde;
		this.impactEpeeLourde = impactEpeeLourde; 
		this.maniabilite = maniabilite;
	}

	@Override
	public String getNomObjet() {
		return nomEpeeLourde;
	}

	@Override
	public Degree getImpactArme() {
		// TODO Auto-generated method stub
		return impactEpeeLourde;
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
		return  nomEpeeLourde +"\nImpactArme: "+ impactEpeeLourde + "; Maniabilite:"+ maniabilite +"\nPortee = " + portee
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
