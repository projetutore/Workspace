package jobs;

public class Degree {

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
		Degree test2 = new Degree(2,4);
		Degree test4 = new Degree(8,8);
		System.out.println(test);
		System.out.println(test2);
		System.out.println(Degree.somme(test, test4));
	}

}
