package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;


import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;

import jeu.Jeu;



public class FenetredeJeu extends JFrame {
	private Jeu jeu;


	private Font Andalus = new Font("Andalus", Font.PLAIN, 16);
 
	
	public FenetredeJeu(String titre , int x , int y , int w , int h , Jeu j){
		super(titre);
		this.jeu = j;
		this.initialise();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(x, y, w , h);
		this.setVisible(true);
	}
	
	public FenetredeJeu(String titre , int x , int y , int w , int h ){
		super(titre);
		this.initialise();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(x, y, w , h);
		this.setVisible(true);
	}
		
	public void initialise(){
		Container fenetredejeu = this.getContentPane();
		fenetredejeu.add(this.carteCentre(), BorderLayout.CENTER);
		fenetredejeu.add(this.panelEst(), BorderLayout.SOUTH);

	}	
	

	public JPanel panelCentre(){
		JPanel centre = new JPanel();
		JPanel centreBas = new JPanel();
		JPanel centreReste = new JPanel();
		JTextArea affichageCarte = new JTextArea(jeu.carte.Afficher());
		affichageCarte.setRows(jeu.carte.getnbLig());
		affichageCarte.setColumns(jeu.carte.getnbCol());

		centreReste.add(affichageCarte);
		affichageCarte.setSize(400, 200);
		centre.add(centreBas, BorderLayout.SOUTH);
		centre.add(centreReste, BorderLayout.CENTER);
		centreBas.add(new JTextArea());
		return centre;
	}
	
	public JPanel carteCentre(){
		JPanel map = new JPanel(new GridLayout(10,10));
		JButton[] zone = new JButton[jeu.carte.getnbLig()*jeu.carte.getnbCol()];
		for(int i = 0; i <jeu.carte.getnbLig(); i++){
			for(int j = 0; j< jeu.carte.getnbCol(); j++){

				switch (jeu.carte.getGrille()[i][j].toString()){
				case "M":
					zone[i] = new JButton("M");
					map.add(zone[i]);
					break;
				case "H":
					zone[i]= new JButton("H");
					map.add(zone[i]);
					break;
				case "#":
					zone[i] = new JButton();
					zone[i].setBackground(Color.BLACK);
					zone[i].setEnabled(false);
					map.add(zone[i]);
				default:
					zone[i] = new JButton();
					map.add(zone[i]);
					break;	
				}
				zone[i].setEnabled(false);

			}
			
		}	
		
		return map;

	}
	
	public JPanel panelEst(){
		JPanel panelEst = new JPanel();
		JPanel panelSudEst = new JPanel();
		JTextArea xl = new JTextArea();
		panelSudEst.add(xl);
		panelEst.add(panelSudEst, BorderLayout.SOUTH);
		return panelEst;
	}
	public static void main(String[] args) {
		Jeu y = new Jeu();
		FenetredeJeu encours = new FenetredeJeu("Abysse", 200, 500,1000,1000, y);
		
	}

}
