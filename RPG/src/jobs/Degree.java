package jobs;

import java.io.Serializable;

public class Degree implements Serializable {

	/**
	 * Le Degree est fait de deux parties:
	 *Les dés un entier...
	 */
	int des;
	/**
	 * ...et le reste: un autre entier 
	 */
	int reste; 
	private static final int BASE = 7;
	
	public Degree(){
		this.des = 0;
		this.reste=0;
	}
	
	public Degree(int stat){
		this.des = stat/BASE;
		this.reste = stat%BASE;
	}

	public Degree(int a, int b){
		this.des = a;
		this.reste = b;
	}
	
	public Degree(Degree degree){
		this.des = degree.getDes();
		this.reste = degree.getReste();
	}

	public String toString(){
		return des+"D+"+reste;
	}
	
	public static Degree somme(Degree a, Degree b){
		Degree somme = new Degree();
		somme.setDes((a.getDes())+(b.getDes()));
		somme.setReste(a.getReste()+b.getReste());
		return somme;
	}
	
	public static Degree soustraction(Degree a, Degree b){
		Degree somme = new Degree();
		somme.setDes((a.getDes())-(b.getDes()));
		somme.setReste(a.getReste()-b.getReste());
		if(somme.des<0){
			somme = new Degree();
		}
		else if(somme.reste<0){
			somme= new Degree(somme.des, 0);
		}
		return somme;
	}
	public boolean equals(Object o){
		Degree lambda = (Degree) o;
		if(this.des == lambda.getDes() && this.reste == lambda.getReste())
				return true;
		return false;
	}
	
	
	public int getDes() {
		return des;
	}
	public void setDes(int des) {
		this.des = des;
	}
	public int getReste() {
		return reste;
	}
	public void setReste(int reste) {
		this.reste = reste;
	}
	public static void main(String[] args) {
		Degree test = new Degree(2,4);
		Degree test2 = null;
		Degree test4 = new Degree(8,8);
		System.out.println(test);
		System.out.println(test2);
		System.out.println(Degree.somme(test, test4));
		System.out.println(test.equals(null));
	}

}
