package Objets;

import jobs.Degree;

public class BaguetteMagique implements Arme{

	private String nomBaguette; 
	private Degree impactArme;
	private Degree maniabilite;
	private Degree impactMagique;
	private String description;
	private int portee = 3 ; 
	private int nombreMain = UNEMAIN ;


/*	public afficherInventaire(){
		int i = 0;
		for(Objet c : Inventaire){
			System.out.println(i + Inventaire[0]);
			
		}
	}*/
	
	public BaguetteMagique(String nomBaguetteMagique, Degree impactArme, Degree impactMagique,  Degree maniabilite, String description) throws ExceptionArme{
		this.nomBaguette = nomBaguetteMagique;
		this.impactArme = impactArme; 
		this.impactMagique = impactMagique;
		this.maniabilite = maniabilite;
		this.description = description;
	}
	
	public Degree getImpactMagique() {
		return impactMagique;
	}

	public String getNomObjet() {
		return nomBaguette;
	}

	public Degree getImpactArme() {
		return impactArme;
	}

	public Degree getManiabilite() {
		return maniabilite;
	}

	public String getDescription() {
		return description;
	}

	public int getNombreMain() {
		return nombreMain;
	}

	public int getPortee() {
		return portee;
	}
	
	public String toString(){
		return "O";
	}
	
	public String affichageCaracteristique(){
		return  nomBaguette + "\nImpactArme: "+ impactArme + "; Maniabilite: " + maniabilite + "; ImpactMagique: " + impactMagique +
				"\nPortee = " + portee + "; NombreMain = " + nombreMain;
	}
	public static void main(String args[]) throws ExceptionArme{
		Arme x = new BaguetteMagique("Baguette de Luxe", new Degree(3), new Degree(3), new Degree(3), "");
		System.out.println(x.affichageCaracteristique());
	}

	@Override
	public String emplacementEquipement() {
		// TODO Auto-generated method stub
		return "Main";
	}
}
