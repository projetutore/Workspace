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

}
