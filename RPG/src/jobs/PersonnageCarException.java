package jobs;

public class PersonnageCarException extends Exception{
	public PersonnageCarException(String message){
		super(message);
		//System.out.println("Un personnage avec un degré négatif ne peut pas être instancié");
	//	System.out.println("Le probleme provient de cela" + nbre);
	}
}
