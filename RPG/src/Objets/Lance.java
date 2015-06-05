package Objets;

import jobs.Degree;

public class Lance implements Arme {

	private String nomLance; 
	private Degree impactLance;
	private Degree maniabilite;
	private String description;
	private int portee = 2 ; 
	private int nombreMain = UNEMAIN ;

	
	public Lance(String nomLance, Degree impactLance, Degree maniabilite, String description) throws ExceptionArme {
		this.nomLance = nomLance;
		this.impactLance = impactLance; 
		this.maniabilite = maniabilite;
		this.description = description;
	}

	@Override
	public String getNomObjet() {
		return nomLance;
	}

	@Override
	public Degree getImpactArme() {
		// TODO Auto-generated method stub
		return impactLance;
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
		return  nomLance +"\nImpactArme: "+ impactLance + "; Maniabilite:"+ maniabilite +"\nPortee = " + portee
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
