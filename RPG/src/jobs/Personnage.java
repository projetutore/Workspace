package jobs;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("b6fc6c34-1a11-4461-b346-31fcb882d568")
public class Personnage {
    @objid ("6c00ef27-8224-4ecb-ac46-2355657db44d")
    private String nom;

    @objid ("a3a8bf21-a609-40dd-b759-0127f2e2ac5a")
    private int vie;

    @objid ("2224e0b9-685e-413a-8148-1a0bb54d5e6f")
    private int maxVie;

    @objid ("34596877-5dd4-4b35-895a-e75e5ee2167e")
    private int mana;

    @objid ("e5de7dac-ae76-4825-8d15-0fa84a5c0575")
    private int maxMana;

    @objid ("7eda2857-e14a-4f20-ae93-5b014843ff44")
    private int force;

    @objid ("d66370b0-120b-44a1-957b-2f3618f17411")
    private int maxForce;

    @objid ("a2afd619-db85-4cb4-a64d-e416eb25b075")
    private int intelligence;

    @objid ("8afafe30-fc82-4f45-9508-71d5dbff2ed8")
    private int maxIntelligence;

    @objid ("69e4271b-cfda-4f9a-bd7d-2b06b2a884ce")
    private int agilite;

    @objid ("e00273ca-eea8-47c3-9dbb-422ed1d4addf")
    private int maxAgilite;

    @objid ("47869522-7dbe-40f0-a1df-cfa6f2562dd8")
    private int constitution;

    @objid ("1f80d204-2e50-4c8a-999c-06f50ced115a")
    private int maxConstitution;

    @objid ("20365c12-b88a-4b54-b10b-43c17c8f621a")
    private int resistance;

    @objid ("6fbacdd9-be06-4cfe-9884-17911d9ae315")
    private int maxResistance;

    @objid ("bda9765f-c216-4acd-a916-d14551efe0b9")
    private int pa;

    @objid ("32f3ca4d-2efa-4db7-9c98-1da767d4b7b2")
    private int maxPa;

    @objid ("02f11649-f107-4270-8e95-849bfff94851")
    public Personnage() {
        this.nom = "Inconnu";
    }

    @objid ("bc131cbe-794a-4c88-ad25-f7be28890274")
    public Personnage(String nom, int maxVie, int maxMana, int maxForce, int maxIntelligence, int maxAgilite, int maxConstitution, int maxResistance, int maxPa) {
        this.nom = nom;
        this.vie = this.maxVie = maxVie;
        this.mana = this.maxMana = maxMana;
        this.force = this.maxForce = maxForce;
        this.intelligence = this.maxIntelligence = maxIntelligence;
        this.agilite = this.maxAgilite = maxAgilite;
        this.constitution = this.maxConstitution = maxConstitution;
        this.resistance = this.maxResistance = maxResistance;
        this.pa = this.maxPa = maxPa;
    }

    @objid ("b3b24727-6951-4d03-be97-7bd14d006ca8")
    public Personnage(String nom, int vie, int maxVie, int mana, int maxMana, int force, int maxForce, int intelligence, int maxIntelligence, int agilite, int maxAgilite, int constitution, int maxConstitution, int resistance, int maxResistance, int pa, int maxPa) {
        this.nom = nom;
        this.vie = vie;
        this.maxVie = maxVie;
        this.mana = mana;
        this.maxMana = maxMana;
        this.force = force;
        this.maxForce = maxForce;
        this.intelligence = intelligence;
        this.maxIntelligence = maxIntelligence;
        this.agilite = agilite;
        this.maxAgilite = maxAgilite;
        this.constitution = constitution;
        this.maxConstitution = maxConstitution;
        this.resistance = resistance;
        this.maxResistance = maxResistance;
        this.pa = pa;
        this.maxPa = maxPa;
    }

    @objid ("d29b74b9-1c92-417e-b20f-bff8291b5f02")
    public Personnage(Personnage choisi) {
        this.nom = new String(choisi.getNom());
        this.vie = choisi.getVie();
        this.mana = choisi.getMana();
        this.force= choisi.getForce();
        this.intelligence = choisi.getIntelligence();
        this.agilite = choisi.getAgilite();
        this.constitution = choisi.getConstitution();
        this.pa = choisi.getPa();
    }

    @objid ("513bd03f-5d1f-4142-8600-aa6be01131e3")
    public String getNom() {
        return nom;
    }

    @objid ("a94f8c53-73bd-4885-997d-099b26ccc11a")
    public void setNom(String nom) {
        this.nom = nom;
    }

    @objid ("1404fa2d-f49b-4e35-8995-f11143737a24")
    public int getVie() {
        return vie;
    }

    @objid ("12910d04-e335-4831-916d-ca2d9710055b")
    public void setVie(int vie) {
        this.vie = vie;
    }

    @objid ("a013a2bd-82b0-42ef-aa4c-9d35311d49fa")
    public int getMaxVie() {
        return maxVie;
    }

    @objid ("174f5b7f-6ff2-4161-9e4a-9b7dba54e148")
    public void setMaxVie(int maxVie) {
        this.maxVie = maxVie;
    }

    @objid ("3ef86234-4260-4f44-bdd1-93fbfce3d6f3")
    public int getMana() {
        return mana;
    }

    @objid ("b5f2acce-0c84-4ec2-be29-96298261a20a")
    public void setMana(int mana) {
        this.mana = mana;
    }

    @objid ("002c2649-4ea9-4dd3-9ba5-c00b3236224e")
    public int getMaxMana() {
        return maxMana;
    }

    @objid ("6c4e3084-a3c5-4099-a6b9-070ec12b8ae0")
    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    @objid ("80263e24-6123-43aa-865a-cca72b802b11")
    public int getForce() {
        return force;
    }

    @objid ("51ba2781-c7f2-4d0c-9cc2-1153ee9443c0")
    public void setForce(int force) {
        this.force = force;
    }

    @objid ("26816bab-d0f9-47c9-86f4-57295fb6ce7c")
    public int getMaxForce() {
        return maxForce;
    }

    @objid ("2691dea8-7a96-4ec8-9ba5-cfc0b91aece8")
    public void setMaxForce(int maxForce) {
        this.maxForce = maxForce;
    }

    @objid ("b02ca757-6aa4-4951-a445-b732f55c5ce8")
    public int getIntelligence() {
        return intelligence;
    }

    @objid ("4791c61c-e628-4a97-a1df-8437f54aa334")
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @objid ("d47e332b-7be4-460d-8a39-5d0b698b0032")
    public int getMaxIntelligence() {
        return maxIntelligence;
    }

    @objid ("0655ad07-e7a3-4e2e-8d26-854fdc160509")
    public void setMaxIntelligence(int maxIntelligence) {
        this.maxIntelligence = maxIntelligence;
    }

    @objid ("bb2bb1e8-85d1-48f6-8efe-5a19932b93c3")
    public int getAgilite() {
        return agilite;
    }

    @objid ("7d0476c0-8db4-4da4-96c4-a89e0d6f0322")
    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    @objid ("d8a3dfda-8d0f-4426-b908-406844ec73b9")
    public int getMaxAgilite() {
        return maxAgilite;
    }

    @objid ("807aad7b-8365-4866-bbd1-516d63527157")
    public void setMaxAgilite(int maxAgilite) {
        this.maxAgilite = maxAgilite;
    }

    @objid ("6b1df476-0984-472f-aecf-2f5653c70dda")
    public int getConstitution() {
        return constitution;
    }

    @objid ("28c7dd21-1c47-449b-b849-26f31c8f9258")
    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    @objid ("1a12b0eb-102b-4b45-b8a7-7550d1c8e652")
    public int getMaxConstitution() {
        return maxConstitution;
    }

    @objid ("0dfd9701-37c1-4885-a58d-350930289028")
    public void setMaxConstitution(int maxConstitution) {
        this.maxConstitution = maxConstitution;
    }

    @objid ("c9009c49-ec44-4273-9a07-278d1758ab1f")
    public int getResistance() {
        return resistance;
    }

    @objid ("29c82ee7-0891-4a1a-847c-927fa2a759f5")
    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    @objid ("fea95ce1-8df3-41f8-a650-361f92761252")
    public int getMaxResistance() {
        return maxResistance;
    }

    @objid ("0ab954c4-0a0f-4c4f-b4ec-a57f538ed222")
    public void setMaxResistance(int maxResistance) {
        this.maxResistance = maxResistance;
    }

    @objid ("4119acab-801f-4571-ade7-4e66e0e14d83")
    public int getPa() {
        return pa;
    }

    @objid ("4c726561-d1df-4287-911c-ed45d27c7e45")
    public void setPa(int pa) {
        this.pa = pa;
    }

    @objid ("4f558842-08ed-400e-8aaa-9ccfd6af8208")
    public int getMaxPa() {
        return maxPa;
    }

    @objid ("f53eb0cc-31e6-4718-bfde-1ffe17955258")
    public void setMaxPa(int maxPa) {
        this.maxPa = maxPa;
    }

    @objid ("097b97ab-ac60-45af-b58f-68d10567d095")
    public void setStatistiques() {
        //    this.vie = this.maxVie;
        //    this.mana = this.maxMana;
            this.force = this.maxForce;
            this.intelligence = this.maxIntelligence;
            this.constitution = this.maxConstitution;
            this.agilite = this.maxAgilite;
            this.pa = this.maxPa;
    }

    @objid ("94bbe711-cb29-4c96-bab2-897eaf433b5c")
    @Override
    public String toString() {
        return  nom + ", Vie=" + maxVie + ", mana=" + maxMana
                        + ", force=" + maxForce + ", intelligence=" + maxIntelligence
                        + ", agilite=" + maxAgilite + ", constitution=" + maxConstitution
                        + ", pa=" + maxPa;
    }
    
    public String toStringCaracteristique(){
    	return "FOR : " + maxForce + "   INT : " + maxIntelligence
        + "\nAGI : " + maxAgilite +  "    CON : " + maxConstitution
        + "\nRES : " + maxResistance;
    }

}
