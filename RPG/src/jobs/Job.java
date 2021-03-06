package jobs;

import java.io.Serializable;

import Arcane.Arcane;

public class Job implements Serializable{
    private String nomJob;

    private Arcane[] ArcaneDeJob;

    public Job() {
        this.nomJob ="Classe";
        this.ArcaneDeJob = null;
    }

    public Job(String nomJob, Arcane[] ArcaneDeJob) {
        this.nomJob = nomJob;
        this.ArcaneDeJob = ArcaneDeJob;
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

    /*public Arcane getArcaneDeJob(int i) {
        return new Arcane(this.ArcaneDeJob[i]);
    }*/

    public String toString() {
        return nomJob;
    }

    public Job choixJob(int i, Heros h){
    	Job job = new Job();
    	switch (i){
    	case 1:
            h.setMaxVie(120);
            h.setMaxMana(20);
            h.setForce(8);
            h.setIntelligence(4);
            h.setAgilite(2);
            h.setConstitution(13);
            h.setResistance(11);
            h.setMaxPa(10);   
            h.setPa(10);

            Arcane[] ArcaneDePaladin = new Arcane[5];
            job.setNomJob("Paladin");
            job.setArcaneDeJob(ArcaneDePaladin);
    		break;
    	case 2:
    		h.setMaxVie(150);
            h.setForce(16);
            h.setAgilite(14);
            h.setConstitution(10);
            h.setResistance(2);
            h.setMaxPa(10);   
            h.setPa(1000);

            Arcane[] ArcaneDeMaraudeur = new Arcane[5];
            job.setNomJob("Maraudeur");
            job.setArcaneDeJob(ArcaneDeMaraudeur);
    		break;
    	case 3:
    		h.setMaxVie(65);
            h.setMaxMana(70);
            h.setForce(4);
            h.setIntelligence(13);
            h.setAgilite(4);
            h.setConstitution(8);
            h.setResistance(12);
            h.setMaxPa(10);
            h.setPa(10);
            
            Arcane[] ArcaneDArcaniste = new Arcane[5];
            job.setNomJob("Arcaniste");
            job.setArcaneDeJob(ArcaneDArcaniste);
    		break;
    	case 4:
    		h.setMaxVie(100);
            h.setMaxMana(30);
            h.setForce(13);
            h.setIntelligence(6);
            h.setAgilite(6);
            h.setConstitution(8);
            h.setResistance(8);
            h.setMaxPa(10);   
            h.setPa(10);

            Arcane[] arcaneDeLanceRouge = new Arcane[5];
            arcaneDeLanceRouge[1].getNomArcane();
            job.setNomJob("LanceRouge");
         //   arcaneDeLanceRouge[0] = new Arcane("Empaler",20, 8+(h.getNiveau()*2),2 , 1, "Un coup de lance dévastateur qui empale littéralement l'ennemi", 0, null, null);
          //  arcaneDeLanceRouge[1] = new Arcane("Lance Runique", 20+(int)(h.getIntelligence()*0.5), 8+(h.getNiveau()*2), 3, 4, "La magie est concentrée au bout de la lance", 0, null, null);
            job.setArcaneDeJob(arcaneDeLanceRouge);
    		break;
    	case 5:
			h.setMaxVie(110);
			h.setMaxMana(15);
			h.setForce(13);
			h.setIntelligence(2);
			h.setAgilite(14);
			h.setConstitution(7);
			h.setResistance(8);
			h.setMaxPa(3);
    	    Arcane[] arcaneDeBretteur = new Arcane[5];
    	    job.setNomJob("Bretteur");
    	    job.setArcaneDeJob(arcaneDeBretteur);
    		break;
    	}
    	
    	return job;
    }
    
    public boolean equals(Object job){
    	if(this.nomJob.equals(((Job) job).nomJob))
    		if(this.ArcaneDeJob.equals(((Job) job).ArcaneDeJob))
    			return true;
    		return false;
    	//return ((this.nomJob.equals(((Jobs) job).nomJob))&&(this.ArcaneDeJob.equals(((Jobs) job).ArcaneDeJob)));
     }

    public static void main(String args[]){
    	Heros x = new Heros();
       	Job y = new Job("Arche", null);
    	Job z = new Job("Lance", null);
    	System.out.println(x.equals(x));
    }
}
