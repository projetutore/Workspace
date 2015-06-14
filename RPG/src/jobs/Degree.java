package jobs;

import java.io.Serializable;

/**
 * Les degrees sont l'assemblage de d�s et de reste qui
 * permettent � un personnage de combattre et donc � un objet de 
 * lui donner davantage de stats.
 *
 */
public class Degree implements Serializable {

	/**
	 * Le Degree est fait de deux parties:
	 *Les d�s un entier...
	 */
	int des;
	/**
	 * ...et le reste: un autre entier 
	 */
	int reste; 
	
	/**
	 * Nombre de points necessaire pour obtenir un d�s
	 */
	private static final int BASE = 7;
	
	/**
	 * Constructeur par d�faut du degree, met le d�s et le reste � 0.
	 */
	public Degree(){
		this.des = 0;
		this.reste=0;
	}
	
	/**
	 * Constructeur par parametre. La stat est divis� par la BASE
	 * 
	 * d�s = � la division de stat par la base
	 * reste = le reste de la division de la stat par la base
	 * @param stat
	 */
	public Degree(int stat){
		this.des = stat/BASE;
		this.reste = stat%BASE;
	}

	/**
	 * Second Constructeur par param�tre, dans le cas o� l'on souhaite directement
	 * instancier des et reste.
	 * 
	 * @param a : nombre de des du degree.
	 * @param b : reste du degree.
	 */
	public Degree(int a, int b){
		this.des = a;
		this.reste = b;
	}
	
	/**
	 * Constructeur par copie des degrees.
	 * 
	 * @param degree: degree que l'on souhaite copier.
	 */
	public Degree(Degree degree){
		this.des = degree.getDes();
		this.reste = degree.getReste();
	}

	/**
	 * toString du degree, le renvoi selon l'affiche
	 * "2D+5" (xD+Y)
	 */
	public String toString(){
		return des+"D+"+reste;
	}
	
	/**
	 * Les degrees s'additionnent le des d'un degree a s'addionne au des d'un degree b
	 * Leurs reste s'additionnent egalement entre eux.
	 * 
	 * 
	 * @param a : premier degree a additionn�
	 * @param b : degree qui sera additionn� au parametre a
	 * @return : un nouveau degr�, la somme des deux.
	 */
	public static Degree somme(Degree a, Degree b){
		Degree somme = new Degree();
		somme.setDes((a.getDes())+(b.getDes()));
		somme.setReste(a.getReste()+b.getReste());
		return somme;
	}
	
	/**
	 * De la m�me mani�re, les degrees se soustraient 
	 * 
	 * @param a : premier degree a soustraire
	 * @param b : degree qui sera soustrait au parametre a
	 * @return : un nouveau degr�, la diff�rence des deux.
	 */
	public static Degree soustraction(Degree a, Degree b){
		Degree somme = new Degree();
		somme.setDes((a.getDes())-(b.getDes()));
		somme.setReste(a.getReste()-b.getReste());
		if(somme.des<0){
			somme = new Degree();
		}
		/**
		 * Dans le cas o� la somme est inf�rieur � 0, on la ram�ne � 0.
		 */
		else if(somme.reste<0){
			somme= new Degree(somme.des, 0);
		}
		return somme;
	}
	
	/**
	 * Methode equals des degrees.
	 */
	public boolean equals(Object o){
		Degree lambda = (Degree) o;
		if(this.des == lambda.getDes() && this.reste == lambda.getReste())
				return true;
		return false;
	}
	
	/**
	 * Accesseur du d�s
	 * @return le des de l'instance en cours
	 */
	public int getDes() {
		return des;
	}
	
	/**
	 * Mutateur du d�s
	 * @param des : remplace le d�s de l'instance actuelle.
	 */
	public void setDes(int des) {
		this.des = des;
	}
	
	/**
	 * Accesseur du reste
	 * @return le reste de l'instance en cours.
	 */
	public int getReste() {
		return reste;
	}
	
	/**
	 * Mutateur du reste
	 * @param reste : remplace le reste de l'instance actuelle.
	 */
	public void setReste(int reste) {
		this.reste = reste;
	}
}
