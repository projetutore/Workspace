package carte;

public class PtsCarte implements Elements {

	private String affichage;
	
	public PtsCarte(String affichage){
		this.affichage = affichage;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return affichage;
	}



	public String getAffichage() {
		return affichage;
	}

	public void setAffichage(String affichage) {
		this.affichage = affichage;
	}

	@Override
	public String affichageCaracteristique() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String args[]){
		PtsCarte mur = new PtsCarte("#");
		System.out.println(mur);
	}

}
