package jobs;

import java.io.Serializable;
import java.util.ArrayList;

import Arcane.Arcane;
import Objets.Interface.Objet;
import carte.Carte;

public interface Type extends Serializable {
    
	/**
	 * Donne le type du monstre.
	 * @return
	 */
	public String getNomType();
	
	
	/**
	 * Represente les actions que va effectuer un Type de Monstre sur la carte
	 * 
	 * @param c : carte o� se trouve le monstre.
	 */
	public void action(Carte c);
	
	/**
	 * Un monstre tu� laisse un objet sur la map.
	 * @return un objet contenu dans la liste des objets du monstre tu�.
	 */
	public Objet objetLaisse();
	
}
