package jobs;

public class PersonnageCarException extends Exception{
	public PersonnageCarException(String message){
		super(message);
		//System.out.println("Un personnage avec un degr� n�gatif ne peut pas �tre instanci�");
	//	System.out.println("Le probleme provient de cela" + nbre);
	}
}
