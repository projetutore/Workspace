package Objets.Classe.Arme;

public class ExceptionArme extends Exception {
	public ExceptionArme( int nombreMain){
		super("La cause est le nombre de main utilis� par l'arme : c'est-�-dire : " + nombreMain);
	}
}
