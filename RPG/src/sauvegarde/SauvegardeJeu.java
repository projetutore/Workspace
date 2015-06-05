package sauvegarde;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import jeu.Jeu;

public class SauvegardeJeu {

	public SauvegardeJeu(Jeu abysse){
		ObjectInputStream ois; 
		ObjectOutputStream oos;
		try{
			oos = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream(new File("sauvegarde.txt"))));
		oos.writeObject(abysse);
		
		oos.close();
		
		
		ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("sauvegarde.txt"))));		
		try{
			System.out.println("Affichage du jeu :");
			System.out.println("********************\n");
			System.out.println(((Jeu) ois.readObject()).toString());
		}catch( ClassNotFoundException e){
			e.printStackTrace();
		}
		
		ois.close();
		
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}catch(IOException e){
		e.printStackTrace();
	}
	}
	
	public static void main(String args[]){
		Jeu x= new Jeu();
		SauvegardeJeu Jeu = new SauvegardeJeu(x);
		
	}
}
