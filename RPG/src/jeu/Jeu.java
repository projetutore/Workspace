package jeu;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Objets.ExceptionArme;
import Objets.Classe.Arme.Arc;
import Objets.Classe.Arme.EpeeLourde;
import Objets.Classe.Arme.Gungnir;
import sauvegarde.SauvegardeJeu;
import jobs.Degree;
import jobs.Heros;
import jobs.Monstre;
import jobs.PersonnageCarException;
import carte.Carte;
import carte.PtsCarte;

public class Jeu implements Serializable {
	@Override
	public String toString() {
		return "Jeu :\n" + carte + "\npersonnageJoueur=" + personnageJoueur.affichageCaracteristique();
				
	}

	public Carte carte;
	public Heros personnageJoueur;
	
	public Jeu(){
		carte = new Carte(10,10);
		personnageJoueur = Heros.creationPersonnage();
		//carte.Afficher();
		carte.placer(3, 3, personnageJoueur);
			
		ArrayList<Monstre>listeMonstre = null;
		try {
		listeMonstre = Monstre.ajoutMonstreType();
		} catch (PersonnageCarException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		carte.placer(2, 5, listeMonstre.get(0));		carte.placer(1, 6, listeMonstre.get(1));		carte.placer(5, 2, listeMonstre.get(0));
		
		//carte.placer(4,5, new PtsCarte("#")); 		carte.placer(8,2, new PtsCarte("#")); 		carte.placer(7,2, new PtsCarte("#"));


		//carte.deplacement();	
	    System.out.println(carte.Afficher());
	    Arc artemis = null;
	    EpeeLourde claymore = null;
	    Gungnir gungnir = null;
	    try {
			 artemis = new Arc("Hankyu", new Degree(4), new Degree(6), 3, "");
			 claymore = new EpeeLourde("Claymore", new Degree(14), new Degree(4), "" );
			 gungnir = new Gungnir();
		} catch (ExceptionArme e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    	personnageJoueur.equiper(gungnir);
	   	personnageJoueur.equiper(claymore);
	    	personnageJoueur.equiper(artemis);
		  personnageJoueur.choix(carte);
		
	}
	public static void sauvegardeJeu(Jeu jeu){
		FileOutputStream outputFile = null;
		try {
			outputFile = new FileOutputStream("sauvegarde0.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//int i = 0;
		
		ObjectOutputStream outputWriter;
		
		try{
		/*	for(i =0; outputFile.equals("sauvegarde"+i+".txt");  i++){
				outputFile = new FileOutputStream("sauvegarde"+i+".txt");
			}*/
//			outputFile = new FileOutputStream("sauvegarde"+i+".txt");

			outputWriter = new ObjectOutputStream(outputFile);
			
			outputWriter.writeObject(jeu);
			
			outputWriter.close(); outputFile.close();
		}catch(Exception e ){
			e.printStackTrace();
		}
	}
	
	public static Jeu chargementJeu(){
		FileInputStream inputfile = null;
		try {
			inputfile = new FileInputStream("sauvegarde0.txt");
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		ObjectInputStream inputReader = null;
		Jeu j =null;
		try{
			for (int i = 0; i< 99; i++){
				inputReader = new ObjectInputStream(inputfile);

				
				//if(((Object) inputfile).exists)){			
					//System.out.println(inputfile);	
				
					j=(Jeu) inputReader.readObject(); // on lit le caractère et on note son code dans i
					
					//System.out.print(j.toString()+"\n");
				
				
					}
					
		//			inputfile = new FileInputStream("sauvegarde"+i+".txt");
			//	}
				
			inputReader.close();
		}catch(FileNotFoundException e){
			try {
				inputReader.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}catch(EOFException e){
		}catch(Exception e){
			e.printStackTrace();
		}
		return j;
	}
	public static void main(String args[]){
		Jeu x= new Jeu();
		Jeu.sauvegardeJeu(x);
		//Jeu y = Jeu.chargementJeu();
	  
	}
}
