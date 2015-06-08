package jobs;

import java.util.ArrayList;

public class Bombo implements Type {

	private ArrayList <Arcane> arcaneDeBombo = Bombo.listeArcaneType();

	
	public String getNomType() {
		// TODO Auto-generated method stub
		return "Bombo";
	}

	@Override
	public ArrayList<Arcane> getTabArcaneMonstre() {
		// TODO Auto-generated method stub
		return arcaneDeBombo;
	}
	
	public static ArrayList<Arcane> listeArcaneType(){
		ArrayList <Arcane> arcaneDeBombo = new ArrayList<Arcane>();
		Arcane xy = new Arcane("Explosion", 0, 0, 3, 0, "Le bombo se fait exploser", 0, "Phy", null);
		arcaneDeBombo.add(xy);
		return arcaneDeBombo;
	}

}
