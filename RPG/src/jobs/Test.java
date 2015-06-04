package jobs;

public abstract class Test extends Personnage{

	private int dede;
	public Test(){
		dede= 5;
	}
	
	public String toString(){
		return " " +dede;
	}
	public static void main(String args[]){
		Test test[] =  new Test[5];
		for(Test t :test)
		System.out.println(t);
	}
}
