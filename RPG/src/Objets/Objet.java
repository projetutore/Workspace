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
	
}
