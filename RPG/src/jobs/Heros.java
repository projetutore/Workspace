package jobs;

import java.util.Scanner;

public class Heros extends Personnage {
	
	private Jobs job;
	private int horsLimite;
	private int experience;
	private int niveau;
	private int creation;
	private Arcane[] tabArcaneHeros;
		
	public Heros() {
		super();
		this.job = new Jobs();
		this.horsLimite = 0;
		this.experience = 0;
		this.niveau = 1;
		this.creation = 0;
		this.tabArcaneHeros = new Arcane[5];
	}

	public Heros(String nom, int vie, int maxVie, int mana, int maxMana,
			int force, int maxForce, int intelligence, int maxIntelligence,
			int agilite, int maxAgilite, int constitution, int maxConstitution,
			int resistance, int maxResistance, int pa, int maxPa,
			Jobs job, int horsLimite, int experience, int niveau,
			int creation, Arcane[] tabArcaneHeros) {
		super(nom, vie, maxVie, mana, maxMana, force, maxForce, intelligence,
				maxIntelligence, agilite, maxAgilite, constitution,
				maxConstitution, resistance, maxResistance, pa, maxPa);
		this.job = job;
		this.horsLimite = horsLimite;
		this.experience = experience;
		this.niveau = niveau;
		this.creation = creation;
		this.tabArcaneHeros = tabArcaneHeros;
	}

	public Heros(Heros nomme){
		super(nomme);
		this.job = new Jobs(nomme.getJob());
		this.horsLimite = nomme.getHorsLimite();
		this.experience = nomme.getExperience();
		this.niveau = nomme.getNiveau();
		this.creation = nomme.getCreation();
		this.tabArcaneHeros =  nomme.getTabArcaneHeros();
	}
	
	public Jobs getJob() {
		return job;
	}

	public void setJob(Jobs job) {
		this.job = job;
	}

	public int getHorsLimite() {
		return horsLimite;
	}

	public void setHorsLimite(int horsLimite) {
		this.horsLimite = horsLimite;
	}
	
	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public int getCreation() {
		return creation;
	}

	public void setCreation(int creation) {
		this.creation = creation;
	}

	public Arcane[] getTabArcaneHeros() {
		return tabArcaneHeros;
	}

	public void setTabArcaneHeros(Arcane[] tabArcaneHeros) {
		this.tabArcaneHeros = tabArcaneHeros;
	}

	public int gainExperience(int xp){
		return this.experience = this.experience+xp;
	}
	
/* 
 * Les fonctions suivantes définissent les growths de chaque job et la montée de niveau du personnages
 * v = vie ; m= mana; f = force; i = intelligence; a = agilité; c = constitution; r = résistance
 */

	public void monteeJob(){
		int v = 0; int m = 0; int f =0; int i = 0; int a = 0; int c = 0; int r = 0;
		switch(this.getJob().getNomJob()){
			case "Paladin":
				v = 12;	m = 8; f = 2; i = 2; a = 2; c = 3; r = 2;
				break;
			case "Maraudeur":
				v = 14; f = 4; a = 3; c = 2; r = 1;
				break;
			case "Arcaniste":
				v = 8; m = 12; f = 1; i = 4; a = 1; c = 2; r = 4;
				break;
			case "LanceRouge":
				v = 8;	m = 7; f = 3; i = 2; a = 2; c = 2; r = 3;
				break;
			case "Bretteur":
				v = 10;	m = 5; f = 3; i = 1; a = 4; c = 2; r = 2;
				break;
		}
		this.setMaxVie(this.getMaxVie()+v);
		System.out.println("Votre vie augmente de " + v + ", à présent elle est de " + this.getMaxVie());
		this.setMaxMana(this.getMaxMana()+m);
		System.out.println("Votre Mana augmente de " + m + ", à présent elle est de " + this.getMaxMana());
		this.setMaxForce(this.getMaxForce()+f);
		System.out.println("Votre Force augmente de " + f +", à présent elle est de " + this.getMaxForce());
		this.setMaxIntelligence(this.getMaxIntelligence()+i);
		System.out.println("Votre Intelligence augmente de" + i +", à présent elle est de " + this.getMaxIntelligence());
		this.setMaxAgilite(this.getMaxAgilite()+a);
		System.out.println("Votre Agilite augmente de " +a+ ", à présent elle est de " + this.getMaxAgilite());
		this.setMaxConstitution(this.getMaxConstitution()+c);
		System.out.println("Votre Constitution augmente de " +c+ ", à présent elle est de " + this.getMaxConstitution());
		this.setMaxResistance(this.getMaxResistance()+r);
		System.out.println("Votre Resistance augmente de "  + r + ", à présent elle est de " + this.getMaxResistance());
		if(this.getJob().getNomJob().equals("LanceRouge"))
		switch(this.getNiveau()){
		case 4:
			this.tabArcaneHeros[0]=this.getJob().getArcaneDeJob(0);
			break;		
		}
		this.setStatistiques();
	}
	

	public void niveauSuperieur() {
		if (this.experience >= 100){
			if (this.niveau <30)
				for(@SuppressWarnings("unused")
				int i = 0; this.experience >= 100 && (this.niveau < 30) ; i++) {	
						this.experience -=100;
						this.niveau++;
						System.out.println(this.getNom() +" a pris en puissance, le niveau " + this.niveau + " a été atteint.");
						this.monteeJob();
						}
					}
					this.experience = 0;
		}

		
	/*
	 * Cette fonction sert à créer son héros, l'utilisateur choisit la classe du héro auto-référé, donne son nom et sa classe 
	 * Le tableau de la classe est donc attribué au héros et le premier Arcane de la classe est débloqué.
	 */
	public Heros creationPersonnage(){
		System.out.println("Vous voici à l'heure de la création de votre personnage\n "+
				"Tout d'abord, comment vous appelerez vous?");
		@SuppressWarnings("resource")
		Scanner creationPersonnage = new Scanner(System.in);
		Heros x = new Heros();
		x.setNom(creationPersonnage.nextLine());
		while(x.getJob().getNomJob()=="Classe"){
		System.out.println("Je vois, c'est donc comme cela que vous avez décidé de vous appelez.\n" +
							"A présent, il est temps de décider de votre classe : \n"
							+ "1 - Paladin \n"
							+ "2 - Maraudeur \n"
							+ "3 - Arcaniste \n"
							+ "4 - Lance Rouge \n"
							+ "5 - Bretteur \n"
							+ "6 - Plus d'info sur le personnage"
							);
		int choix = creationPersonnage.nextInt();
		switch (choix){
		case 1: 
			x.setJob(x.getJob().paladin(x));		
			System.out.println("Votre personnage est donc un Paladin");
			System.out.println(x.getJob());
			break;
		case 2:
			x.setJob(x.getJob().maraudeur(x));	
			break;
		case 3:
			x.setJob(x.getJob().arcaniste(x));		
			break;
		case 4:
			x.setJob(x.getJob().lanceRouge(x));		
			break;
		case 5:
			x.setJob(x.getJob().bretteur(x));		
			break;
		case 6:
			System.out.println("Le Paladin :  c'est un protecteur, de ce fait, "
								+ "il est beaucoup plus résistant que tout autre classe, cependant, "
								+ "ses coups sont de qualités moyennes et il est assez lent, cependant"
								+ "il croît de manière naturelle dans toute les stats sans exceller dans une seule.\n"
								+ "Le Maraudeur : un être habitué à vivre dans les zones difficiles et ayant pour habitude de se débrouiller sans aucun problème"
								+ "de ce fait, il est agile et excelle dans les coups puissants."
								+ "Cependant, la fusion des deux lui empêche d'agir rapidement,\n"
								+ "sa puissance lui permet donc de finir ses adversaires rapidement,"
								+ "de ne plus pouvoir agir et se faire attaquer. \n"
								+ "L'Arcaniste : il s'agit d'un être qui s'est exclusivement concentré sur les arcanes. \n"
								+ "De nature intelligente et sage, ils combattent très peu au corps et disposent donc d'une force en dessous de la moyenne.\n"
								+ "Cependant, ils sont entrainés à résister au coup et de plus, ils usent d'arcanes protecteur pour se protéger durant le temps"
								+ "d'invocations de ses Arcanes.\n"
								+ "La Lance Rouge : des lanciers dont les coups et les arcanes sont dévastateurs, cependant, du fait d'utilisation de lance, "
								+ "ils sont assez fragiles, sans doute les plus fragiles d'entre tous. \n"
								+ "Le Bretteur : Des épeistes hors-pair, d'une agilité deconcertante et d'une précision phénomenale, ses coups sont précis et "
								+ "féroces."
								);
			break;
		}
	}
		return x;
	}

	public int[] CalculEXP(Heros h){
		int[] table_xp = new int[99];
		int j =0;
		for(int i = 0; i<98; i++){
			for(int k = 0; k<98; k++)
				table_xp[i] = table_xp[i] + (i+1*(j*j)*10);
		}
		return table_xp;
	}
	
/*	public void experience(){
	
			}
		}
		System.out.println(table_xp);
		}
		*/
	@Override
	public String toString() {
		return   job +" "+ super.toString()+"\nhorsLimite=" + horsLimite + ", experience=" + experience
				+ ", niveau=" + niveau + ", creation=" + creation + ", Arcane =" + tabArcaneHeros + "]";
	}

	public static void main(String[] args) {
		Heros[] herosOccupe = new Heros[500];
		Heros heros = new Heros();

		herosOccupe[1] = heros.creationPersonnage();
	/*	herosOccupe[1].setExperience(2900);
		herosOccupe[1].niveauSuperieur();		
		herosOccupe[1].experience();*/
		System.out.println(herosOccupe[1].toString());
		System.out.println(herosOccupe[1].tabArcaneHeros[0]);
		System.out.println(herosOccupe[1].getJob());
		Monstre monstre = new Monstre("Gluant", 150, 50, 14, 10,10, 4, 4, 3, "Baleine", 80);
	/*	int[] tables = new int[99];
		tables = CalculEXP(herosOccupe[1]);
		int xp = 0;
		int gain = herosOccupe[1].getNiveau()+1;
		for (int i : tables){
			System.out.println(tables[i] + " " + i);
		}*/
		
		Combat xy = new Combat(herosOccupe[1], monstre);
	/*	 herosOccupe.toStringTableau();
		int[] table_xp = new int[31];
		for(int i = 1 ; i <= 30; i++){
			table_xp[i] = i *(i-1)*100;
				System.out.println(table_xp[i] +" " + i);
			}*/
		
		
}

}
