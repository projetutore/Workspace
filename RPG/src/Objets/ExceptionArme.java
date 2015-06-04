package Objets;

public class ExceptionArme extends Exception {
	public ExceptionArme( int nombreMain){
		super("La cause est le nombre de main utilisé par l'arme : c'est-à-dire : " + nombreMain);
	}
}
