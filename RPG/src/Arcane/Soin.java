package Arcane;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import carte.Carte;
import carte.Elements;
import jobs.Heros;
import jobs.Monstre;
import jobs.Personnage;

public class Soin implements Arcane {

	  private String nomArcane;

	    private int degatsArcane;

	    private int coutMana;

	    private int coutPa;

	    private int porteeArcane;
	    private int nivAcquisition;

	    private String description;

	    private String ratio = "Mag";
	

		public Soin(String nomArcane, int degatsArcane, int coutMana,
				int coutPA, int nivAcquisition, String description) {
			super();
			this.nomArcane = nomArcane;
			this.degatsArcane = degatsArcane;
			this.coutMana = coutMana;
			this.coutPa = coutPA;
			this.nivAcquisition = nivAcquisition;
			this.description = description;
		}

		@Override
		public String getNomArcane() {
			// TODO Auto-generated method stub
			return nomArcane;
		}

		@Override
		public int getCoutMana(Personnage p) {
			// TODO Auto-generated method stub
			return coutMana;
		}

		@Override
		public int getCoutPa() {
			// TODO Auto-generated method stub
			return coutPa;
		}

		@Override
		public int niveauAcquision() {
			// TODO Auto-generated method stub
			return nivAcquisition;
		}

		@Override
		public int getDegatsArcane() {
			// TODO Auto-generated method stub
			return degatsArcane;
		}

		@Override
		public String getRatio() {
			// TODO Auto-generated method stub
			return ratio;
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return description;
		}

		@Override
		public void utilisationArcane(Carte carte, Personnage p) {
			ArrayList <Heros> personnage_a_soigner = new ArrayList<Heros>();
			Elements[][] grille = carte.getGrille();
		
			
			for(int i = 0; i < carte.getnbLig(); i++){
				for(int j = 0; j<carte.getnbCol(); j++){
					if(grille[i][j].equals(p)){
						for(int k = 0; k <=  porteeArcane; k++){
								try{
									if (grille[i+k][j] instanceof Heros && personnage_a_soigner.contains(grille[i+k][j]) ==false){
										personnage_a_soigner.add((Heros) grille[i+k][j] );
									}
									else if(grille[i-k][j] instanceof Heros && personnage_a_soigner.contains(grille[i-k][j]) ==false){
										personnage_a_soigner.add((Heros) grille[i-k][j]);
									}
								
								}catch(ArrayIndexOutOfBoundsException e){}
								
							for(int l = 0; l<= porteeArcane; l++){
								try{
									if (grille[i][j+l] instanceof Heros && personnage_a_soigner.contains(grille[i][j+l]) == false){
										personnage_a_soigner.add((Heros) grille[i][j+l]);
									}
									else if(grille[i][j-l] instanceof Heros && personnage_a_soigner.contains(grille[i][j-l]) == false){
										personnage_a_soigner.add((Heros) grille[i][j-l]);
									}
								}catch(ArrayIndexOutOfBoundsException e){}
							}
						}	

					}
				}
			}
			if(personnage_a_soigner.isEmpty()==false){
				System.out.println("Qui souhaitez vous soigner?" );
				Heros.afficheCollectionHeros(personnage_a_soigner);
				Scanner scanner = new Scanner(System.in);
				int choix = 0;
				int f = -1;
				
				while(f == -1 ){
					try{
						choix = scanner.nextInt();
		
						if(choix == 0){
							return;
						}
						
						personnage_a_soigner.get(choix-1).regainDeVie(degatsArcane);	
					f++;
					}catch(IndexOutOfBoundsException e){
					System.out.println("Veuillez saisir un chiffre entre 0(annuler le lancer d'Arcane) et "+ personnage_a_soigner.size());
					Heros.afficheCollectionHeros(personnage_a_soigner);
					}
				}
				
				
			}
		}

	/*
		public void utilisationArcane(Carte carte, Personnage p) {
			ArrayList <Heros> personnage_a_soigner = new ArrayList<Heros>();
			Elements[][] grille = carte.getGrille();
		
			
			for(int i = 0; i < carte.getnbLig(); i++){
				for(int j = 0; j<carte.getnbCol(); j++){
					if(grille[i][j].equals(p)){
						for(int k = 0; k <=  porteeArcane; k++){
								try{
									if (grille[i+k][j] instanceof Heros && personnage_a_soigner.contains(grille[i+k][j]) ==false){
										personnage_a_soigner.add((Heros) grille[i+k][j] );
									}
									else if(grille[i-k][j] instanceof Heros && personnage_a_soigner.contains(grille[i-k][j]) ==false){
										personnage_a_soigner.add((Heros) grille[i-k][j]);
									}
								
								}catch(ArrayIndexOutOfBoundsException e){}
								
							for(int l = 0; l<= porteeArcane; l++){
								try{
									if (grille[i][j+l] instanceof Heros && personnage_a_soigner.contains(grille[i][j+l]) == false){
										personnage_a_soigner.add((Heros) grille[i][j+l]);
									}
									else if(grille[i][j-l] instanceof Heros && personnage_a_soigner.contains(grille[i][j-l]) == false){
										personnage_a_soigner.add((Heros) grille[i][j-l]);
									}
								}catch(ArrayIndexOutOfBoundsException e){}
							}
						}	

					}
				}
			}
			if(personnage_a_soigner.isEmpty()==false){
				System.out.println("Qui souhaitez vous soigner?" );
				Heros.afficheCollectionHeros(personnage_a_soigner);
				Scanner scanner = new Scanner(System.in);
				int choix = 0;
				int f = -1;
				
				while(f == -1 ){
					try{
						choix = scanner.nextInt();
		
						if(choix == 0){
							return;
						}
						
						personnage_a_soigner.get(choix-1).regainDeVie(degatsArcane);	
					f++;
					}catch(IndexOutOfBoundsException e){
					System.out.println("Veuillez saisir un chiffre entre 0(annuler le lancer d'Arcane) et "+ personnage_a_soigner.size());
					Heros.afficheCollectionHeros(personnage_a_soigner);
					}
				}
				
				
			}
		}
		*/
		@Override
		public int getPorteeArcane() {
			// TODO Auto-generated method stub
			return porteeArcane;
		}

}
