package jobs;

import java.awt.*;

import javax.swing.*;

public class FichePerso extends JFrame{

	private Heros myHeros;
	
	public FichePerso (String titre, Heros myHeros){
		super(titre);
		Toolkit atk = Toolkit.getDefaultToolkit();
		Dimension dim = atk.getScreenSize();
		this.setSize(dim.width/2, dim.height-100);
		this.myHeros = myHeros;
		this.initialise();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		}
	
	public void initialise(){
		Container fichePerso = this.getContentPane();
		fichePerso.add(this.panelHautGauche(),BorderLayout.WEST);
		fichePerso.add(this.panelCentre(), BorderLayout.NORTH);
		//fichePerso.add(this.panelBas(), BorderLayout.NORTH);
		/*this.initialiseMenu();
		this.jouer.addKeyListener(new BoutonGaucheClavierListener());*/
	}	
	
	public JPanel panelHautGauche(){
		JPanel panelHautGauche = new JPanel();
		panelHautGauche.setLocation(100, 200);

		JTextArea identitePerso = new JTextArea();
		identitePerso.setEditable(false);
		identitePerso.setText("Nom: "+ this.myHeros.getNom()+ "\nClasse: " + this.myHeros.getJob());
		panelHautGauche.add(identitePerso);
		panelHautGauche.add(this.panelGauche(), BorderLayout.WEST);
		return panelHautGauche;
	}
	public JPanel panelHautDroit(){
		JPanel panelHautDroit = new JPanel();
		//panelHautDroit.setPreferredSize(new Dimension(100,200));
		
		panelHautDroit.add(caracteristiquePerso);
		return panelHautDroit;
	}
	
	public JPanel panelGauche(){
		JPanel panelGauche = new JPanel();
		JTextArea vide= new JTextArea();
		vide.setText("                                    ");
		
		return panelGauche;
	}
	public JPanel panelBas(){
		JPanel panelBas = new JPanel();
		return panelBas;
		
	}
	
	public JPanel panelCentre(){
		JPanel panelCentre = new JPanel(new GridLayout(6,3,2,0));
		JTextArea caracteristiquePerso = new JTextArea(0,0);
		caracteristiquePerso.setEditable(false);
		caracteristiquePerso.setText(this.myHeros.toStringCaracteristique());
		JLabel car[] = new JLabel[5];
		car[0] = new JLabel("For : " + this.myHeros.getMaxForce());
		car[1] = new JLabel("Int : " + this.myHeros.getMaxIntelligence());
		car[2] = new JLabel("Con : " + this.myHeros.getMaxConstitution());
		car[3] = new JLabel("Agi : " + this.myHeros.getMaxAgilite());
		car[4] = new JLabel("Res : " + this.myHeros.getMaxResistance());
		Font Modern_No = new Font("Modern No. 20", Font.BOLD, 20);
		caracteristiquePerso.setFont(Modern_No);
		caracteristiquePerso.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
		JButton plus[] = new JButton[5];
		JButton moins[] = new JButton[5];
		for(int i = 0; i<5; i++){
			plus[i] = new JButton();
			moins[i] = new JButton();
			plus[i].setText("+");
			plus[i].setFont(Modern_No);
			plus[i].setSize(20, 20);
			panelCentre.add(plus[i]);
			car[i].setFont(Modern_No);
			panelCentre.add(car[i]);
			moins[i].setText("-");
			moins[i].setFont(Modern_No);
			moins[i].setPreferredSize(new Dimension(20, 10));
			panelCentre.add(moins[i]);
		}	
		return panelCentre;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Heros heros = new Heros("Ashe", 200, 100, 20, 10, 10, 80, 12, 10, null, 10, 3, 4, 3, null );
        FichePerso base = new FichePerso(heros.getNom(), heros);
	}

}
