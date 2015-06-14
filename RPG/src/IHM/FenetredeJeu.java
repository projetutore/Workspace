package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import jeu.Jeu;



public class FenetredeJeu extends JFrame {
	private Jeu jeu;
	private JPanel map;
	private Container fenetredejeu;
	private JProgressBar bar;
	private JProgressBar barxp;
	private Thread t;
	public static final Font Andalus = new Font("Andalus", Font.PLAIN, 16);
	public static final int FLECHE_HAUT = 38;
	
	public FenetredeJeu(String titre , int x , int y , int w , int h , Jeu j){
		super(titre);
		this.jeu = j;
		this.initialise();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(x, y, w , h);
		this.setVisible(true);
		t = new Thread(new Traitement());
	}
	
		
	public void initialise(){
		 fenetredejeu = this.getContentPane();
		fenetredejeu.add(this.carteCentre(), BorderLayout.CENTER);
	//	fenetredejeu.add(this.panelEst(), BorderLayout.SOUTH);
		fenetredejeu.add(this.panelOuest(), BorderLayout.WEST);

	}	
	

	public JPanel panelCentre(){
		JPanel centre = new JPanel();
		JPanel centreBas = new JPanel();
		JPanel centreReste = new JPanel();
		JTextArea affichageCarte = new JTextArea(jeu.getCarte().Afficher());
		affichageCarte.setRows(jeu.getCarte().getnbLig());
		affichageCarte.setColumns(jeu.getCarte().getnbCol());

		centreReste.add(affichageCarte);
		affichageCarte.setSize(400, 200);
		centre.add(centreBas, BorderLayout.SOUTH);
		centre.add(centreReste, BorderLayout.CENTER);
		centreBas.add(new JTextArea());
		return centre;
	}
	
	public JPanel carteCentre(){
		 map = new JPanel(new GridLayout(jeu.getCarte().getnbLig(),jeu.getCarte().getnbCol()));
		JButton[][] zone = new JButton[jeu.getCarte().getnbLig()][jeu.getCarte().getnbCol()];
		JeuListener jl = new JeuListener();
		for(int i = 0; i <jeu.getCarte().getnbLig(); i++){
			for(int j = 0; j< jeu.getCarte().getnbCol(); j++){

				switch (jeu.getCarte().getGrille()[i][j].toString()){
				case "M":
					zone[i][j] = new JButton("M");
					zone[i][j].setBackground(Color.RED);
					zone[i][j].setForeground(Color.BLACK);			
					map.add(zone[i][j]);
	
					break;
				case "H":
					zone[i][j]= new JButton("H");
					zone[i][j].setBackground(Color.GREEN);

					map.add(zone[i][j]);
					break;
				case "#":
					zone[i][j] = new JButton();
					map.add(zone[i][j]);
					zone[i][j].setBackground(Color.BLACK);
					break;
				case "O":
					zone[i][j] = new JButton("O");
					map.add(zone[i][j]);
					zone[i][j].setBackground(Color.YELLOW);
					break;
				default:
					zone[i][j]= new JButton();
					map.add(zone[i][j]);
					break;	
				}
				zone[i][j].setEnabled(false);
				zone[i][j].addKeyListener(jl);
			}
			
		}	

		return map;

	}
	
	public JPanel panelOuest(){
		jeuActionListener jl = new jeuActionListener();

		JPanel panelOuest = new JPanel(new BorderLayout());
		JTabbedPane onglet = new JTabbedPane();
		JPanel panelInventaire = new JPanel();
		JPanel panelHeros = new JPanel();
		onglet.add("Personnage", panelHeros);
		onglet.add("Inventaire", panelInventaire);
		JPanel panelAttaque = new JPanel();
		JPanel panelBouton = new JPanel(new GridLayout(3,3,0,0));
		JPanel commande = new JPanel(new BorderLayout());
		JButton attaque = new JButton("Attaque");
		JLabel titre = new JLabel("EXP");
		commande.add(attaque, BorderLayout.CENTER);
		commande.add(titre, BorderLayout.NORTH);
		bar = new JProgressBar();
		barxp= new JProgressBar();
		commande.add(bar, BorderLayout.EAST);
		bar.setMaximum(jeu.getPersonnageJoueur().getMaxPa());
		bar.setMinimum(0);
		bar.setStringPainted(true);
		commande.add(barxp, BorderLayout.WEST);

		JButton action[] = new JButton[9];
		for(int i = 0; i<9; i++){	
			switch(i){
			case 1:action[i] = new JButton("Haut");
			break;
			case 3:action[i] = new JButton("Gauche");
			break;
			case 5: action[i]= new JButton("Droite");
			break;
			case 7: action[i]= new JButton("Bas");
			break;
			default:action[i]=new JButton();
			action[i].setEnabled(false);
			}
			action[i].addActionListener(jl);
			panelBouton.add(action[i]);
		}
		JTextArea alpha = new JTextArea(jeu.getPersonnageJoueur().affichageCaracteristique());
		panelHeros.add(alpha);
		panelOuest.add(onglet);
		commande.add(panelBouton, BorderLayout.SOUTH);

		panelOuest.add(commande, BorderLayout.SOUTH);

		return panelOuest;
	}
	
	class JeuListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent evt) {
			if(evt.getKeyCode() == KeyEvent.VK_UP){
				jeu.getCarte().deplacerHaut(jeu.getPersonnageJoueur());
				map.repaint();
				map.revalidate();
				fenetredejeu.add(carteCentre(), BorderLayout.CENTER);
			}
			else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
				jeu.getCarte().deplacerBas(jeu.getPersonnageJoueur());
				map.repaint();
				map.revalidate();
				System.out.println("cela marche");

				fenetredejeu.add(carteCentre(), BorderLayout.CENTER);
			}	
			else if(evt.getKeyCode() == KeyEvent.VK_LEFT){
				jeu.getCarte().deplacerGauche(jeu.getPersonnageJoueur());
				map.repaint();
				map.revalidate();
				System.out.println("cela marche");

				fenetredejeu.add(carteCentre(), BorderLayout.CENTER);
			}	
			else if(evt.getKeyCode() == KeyEvent.VK_RIGHT){
				jeu.getCarte().deplacerDroite(jeu.getPersonnageJoueur());
				map.repaint();
				map.repaint();
				map.revalidate();
				System.out.println("cela marche");

				fenetredejeu.add(carteCentre(), BorderLayout.CENTER);
			}
			
		}
	
	}
	
	class jeuActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evt) {
			if(evt.getActionCommand().equals("Haut")){
				jeu.getCarte().deplacerHaut(jeu.getPersonnageJoueur());
				fenetredejeu.add(carteCentre(), BorderLayout.CENTER);	
				map.revalidate();	
				map.repaint();


			}
			else if(evt.getActionCommand().equals("Bas")){
				jeu.getCarte().deplacerBas(jeu.getPersonnageJoueur());
				fenetredejeu.add(carteCentre(), BorderLayout.CENTER);	
				map.revalidate();	
				map.repaint();
			}
			else if(evt.getActionCommand().equals("Gauche")){
				jeu.getCarte().deplacerGauche(jeu.getPersonnageJoueur());
				fenetredejeu.add(carteCentre(), BorderLayout.CENTER);	
				map.revalidate();	
				map.repaint();
			}
			else if(evt.getActionCommand().equals("Droite")){
				jeu.getCarte().deplacerDroite(jeu.getPersonnageJoueur());
				}
			fenetredejeu.add(carteCentre(), BorderLayout.CENTER);	
			map.revalidate();	
			map.repaint();
			t.start();

		}	
	}
	
	class Traitement implements Runnable{

		@Override
		public void run() {
			for(int val = 0; val <= jeu.getPersonnageJoueur().getPa(); val++){
				bar.setValue(val);
			}
			try{
				t.sleep(1000000000);
			}catch(InterruptedException e ){
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		Jeu y = new Jeu();
		FenetredeJeu encours = new FenetredeJeu("Abysse", 200, 500,1000,1000, y);
		
	}

}
