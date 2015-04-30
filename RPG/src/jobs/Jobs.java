package jobs;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("087d285a-60e4-4d7f-adf4-434e9a9065bf")
public class Jobs {
    @objid ("213049f3-0ede-4d69-a35e-ea89fb1f3dbe")
    private String nomJob;

    @objid ("e76dfbe1-b09e-4de2-bdab-2f6955ca844c")
    private Arcane[] ArcaneDeJob;

    @objid ("00640249-2812-4ba8-bd26-d4d8d2831d50")
    public Jobs() {
        this.nomJob ="Classe";
        this.ArcaneDeJob = null;
    }

    @objid ("e54d6e76-2297-4edb-8366-36798c6290c5")
    public Jobs(String nomJob, Arcane[] ArcaneDeJob) {
        this.nomJob = nomJob;
        this.ArcaneDeJob = ArcaneDeJob;
    }

    @objid ("4a566218-30d2-4c3c-8e1c-40297ed9fbdd")
    public Jobs(Jobs jobs) {
        this.nomJob = new String(jobs.getNomJob());
        this.ArcaneDeJob = jobs.getArcaneDeJob();
    }

    @objid ("57dca9dd-1050-4ed7-93ef-a48a9128baa8")
    public String getNomJob() {
        return nomJob;
    }

    @objid ("0f0e53de-8dee-4568-9abe-a43d471c2d7d")
    public void setNomJob(String nomJob) {
        this.nomJob = nomJob;
    }

    @objid ("aeed62ab-10a7-4e19-b0b9-8772bd88c767")
    public Arcane[] getArcaneDeJob() {
        return ArcaneDeJob;
    }

    @objid ("53cd0c9f-b176-407c-8bca-8c1d39722fcb")
    public void setArcaneDeJob(Arcane[] ArcaneDeJob) {
        this.ArcaneDeJob = ArcaneDeJob;
    }

    @objid ("14e04b54-9bd3-459d-888b-2c4c94af7e61")
    public Arcane getArcaneDeJob(int i) {
        return new Arcane(this.ArcaneDeJob[i]);
    }

    @objid ("1f47df67-93bd-4d87-9df9-efef9c371454")
    public String toString() {
        return nomJob;
    }

    @objid ("86003ec7-7a5e-47fb-8998-698c3ab9f55a")
    public Jobs paladin(Heros x) {
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

    @objid ("9ccd6493-a110-4beb-a46b-d832dfb5acce")
    public Jobs maraudeur(Heros x) {
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

    @objid ("2bfa9d8d-ef74-470a-8506-4a34eb68d7ff")
    public Jobs arcaniste(Heros x) {
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

    @objid ("63296976-7310-4159-9282-276dc932e8f0")
    public Jobs lanceRouge(Heros x) {
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
        Effet aucun;
        Effet feu = new Effet("Feu", 12);
        Arcane[] arcaneDeLanceRouge = new Arcane[5];
        lanceRouge.setNomJob("LanceRouge");
        arcaneDeLanceRouge[0] = new Arcane("Empaler",20, 8+(x.getNiveau()*2),2 , 1, "Un coup de lance dévastateur qui empale littéralement l'ennemi", 0, null, null);
        arcaneDeLanceRouge[1] = new Arcane("Lance Runique", 20+(int)(x.getIntelligence()*0.5), 8+(x.getNiveau()*2), 3, 4, "La magie est concentrée au bout de la lance", 0, null, null);
        arcaneDeLanceRouge[2] = new Arcane();
        arcaneDeLanceRouge[3] = new Arcane();
        arcaneDeLanceRouge[4] = new Arcane(); 
        lanceRouge.setArcaneDeJob(arcaneDeLanceRouge);
        return lanceRouge;
    }

    @objid ("26ad4c2d-b518-4703-89bd-f46451fa8025")
    public Jobs bretteur(Heros x) {
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
