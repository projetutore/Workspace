package jobs;

public class Jobs {

	private String nomJob;
	private Arcane[] ArcaneDeJob;
	
	public Jobs(){
		this.nomJob ="Classe";
		this.ArcaneDeJob = null;
	}
	
	public Jobs(String nomJob, Arcane[] ArcaneDeJob) {
		this.nomJob = nomJob;
		this.ArcaneDeJob = ArcaneDeJob;
	}

	public Jobs(Jobs jobs){
		this.nomJob = new String(jobs.getNomJob());
		this.ArcaneDeJob = jobs.getArcaneDeJob();
	}

	public String getNomJob() {
		return nomJob;
	}

	public void setNomJob(String nomJob) {
		this.nomJob = nomJob;
	}

	public Arcane[] getArcaneDeJob() {
		return ArcaneDeJob;
	}

	public void setArcaneDeJob(Arcane[] ArcaneDeJob) {
		this.ArcaneDeJob = ArcaneDeJob;
	}

	public Arcane getArcaneDeJob(int i){
		return new Arcane(this.ArcaneDeJob[i]);
	}
	public String toString(){
		return nomJob;
	}
	public Jobs paladin(Heros x){
		Jobs paladin = new Jobs();
		
		x.setMaxVie(120);
		x.setVie(x.getMaxVie());
		x.setMaxMana(20);
		x.setMana(x.getMaxMana());
		x.setMaxForce(10);
		x.setForce(x.getMaxForce());
		x.setMaxIntelligence(6);
		x.setIntelligence(x.getMaxIntelligence());
		x.setMaxAgilite(4);
		x.setAgilite(x.getMaxAgilite());
		x.setMaxConstitution(15);
		x.setConstitution(x.getMaxConstitution());
		x.setMaxResistance(13);
		x.setMaxPa(3);
		x.setPa(x.getMaxPa());
		Arcane[] ArcaneDePaladin = new Arcane[5];
		paladin.setNomJob("Paladin");
		paladin.setArcaneDeJob(ArcaneDePaladin);
		return paladin;
	}
	
	public Jobs maraudeur(Heros x){
		Jobs maraudeur = new Jobs();
		
		x.setMaxVie(150);
		x.setVie(x.getMaxVie());
		x.setMaxForce(18);
		x.setForce(x.getMaxForce());
		x.setMaxAgilite(12);
		x.setAgilite(x.getMaxAgilite());
		x.setMaxConstitution(12);
		x.setConstitution(x.getMaxConstitution());
		x.setMaxResistance(4);
		x.setMaxPa(2);
		x.setPa(x.getMaxPa());
		
		Arcane[] ArcaneDeMaraudeur = new Arcane[5];
		maraudeur.setNomJob("Maraudeur");
		maraudeur.setArcaneDeJob(ArcaneDeMaraudeur);
		return maraudeur;
	}
	
	public Jobs arcaniste(Heros x){
		Jobs arcaniste = new Jobs();
		
		x.setMaxVie(65);
		x.setVie(x.getMaxVie());
		x.setMaxMana(70);
		x.setMana(x.getMaxMana());
		x.setMaxForce(6);
		x.setForce(x.getMaxForce());
		x.setMaxIntelligence(15);
		x.setIntelligence(x.getMaxIntelligence());
		x.setMaxAgilite(6);
		x.setAgilite(x.getMaxAgilite());
		x.setMaxConstitution(10);
		x.setConstitution(x.getMaxConstitution());
		x.setMaxResistance(14);
		x.setMaxPa(3);
		x.setPa(x.getMaxPa());
		
		Arcane[] ArcaneDArcaniste = new Arcane[5];
		arcaniste.setNomJob("Arcaniste");
		arcaniste.setArcaneDeJob(ArcaneDArcaniste);
		return arcaniste;
	}
	
	public Jobs lanceRouge(Heros x){
		Jobs lanceRouge = new Jobs();
		
		x.setMaxVie(100);
		x.setVie(x.getMaxVie());
		x.setMaxMana(30);
		x.setMana(x.getMaxMana());
		x.setMaxForce(15);
		x.setForce(x.getMaxForce());
		x.setMaxIntelligence(8);
		x.setIntelligence(x.getMaxIntelligence());
		x.setMaxAgilite(8);
		x.setAgilite(x.getMaxAgilite());
		x.setMaxConstitution(10);
		x.setConstitution(x.getMaxConstitution());
		x.setMaxResistance(10);
		x.setMaxPa(3);
		x.setPa(x.getMaxPa());
		
		Effet feu = new Effet("Feu", 12);
		Arcane[] arcaneDeLanceRouge = new Arcane[5];
		lanceRouge.setNomJob("LanceRouge");
		arcaneDeLanceRouge[0]= new Arcane("Estocade", 10*((int)(int)0.25d*x.getForce()), feu, 10, 2, 1, "Blabla"); //nomSort, surnomSort, classSort, degatsSort, cout_Pa, effet
		arcaneDeLanceRouge[1] = new Arcane();
		arcaneDeLanceRouge[2] = new Arcane();
		arcaneDeLanceRouge[3] = new Arcane();
		arcaneDeLanceRouge[4] = new Arcane(); 
		lanceRouge.setArcaneDeJob(arcaneDeLanceRouge);
		return lanceRouge;
	}
	
	public Jobs bretteur(Heros x){
		Jobs bretteur = new Jobs();
		
		x.setMaxVie(110);
		x.setVie(x.getMaxVie());
		x.setMaxMana(15);
		x.setMana(x.getMaxMana());
		x.setMaxForce(14);
		x.setForce(x.getMaxForce());
		x.setMaxIntelligence(4);
		x.setIntelligence(x.getMaxIntelligence());
		x.setMaxAgilite(16);
		x.setAgilite(x.getMaxAgilite());
		x.setMaxConstitution(9);
		x.setConstitution(x.getMaxConstitution());
		x.setMaxResistance(10);
		x.setMaxPa(3);
		x.setPa(x.getMaxPa());
		
		Arcane[] arcaneDeBretteur = new Arcane[5];
		bretteur.setNomJob("Bretteur");
		bretteur.setArcaneDeJob(arcaneDeBretteur);
		return bretteur;
	}
}
