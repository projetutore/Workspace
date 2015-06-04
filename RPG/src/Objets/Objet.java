package Objets;

public abstract class Objet {

	private String nomObjet;

	public Objet(String nomObjet) {
		super();
		this.nomObjet = nomObjet;
	}

	@Override
	public String toString() {
		return nomObjet;
	}

	public String getNomObjet() {
		return nomObjet;
	}

	public void setNomObjet(String nomObjet) {
		this.nomObjet = nomObjet;
	}
	

}
