package jobs;

import java.io.Serializable;
import java.util.ArrayList;

public interface Type extends Serializable {
    
	public String getNomType();

	public ArrayList<Arcane> getTabArcaneMonstre() ;

	
}
