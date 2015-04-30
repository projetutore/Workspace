package jobs;

import java.util.Random;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("121f8a07-60f8-440c-8968-75b909c561b4")
public class Monstre extends Personnage {
    @objid ("1f69379e-1175-42b4-a466-350d768f253f")
    private int experienceDonnee;

    @objid ("b766717f-a251-4229-9e67-d898f5a7d697")
    public Type type;

    @objid ("6be3747a-c596-4c15-aa8c-c876cf782f3a")
    public Monstre(Monstre choisi) {
        super(choisi);
        this.type = choisi.getType();
        this.experienceDonnee = this.getExperienceDonnee();
        // TODO Auto-generated constructor stub
    }

    @objid ("7e43e87f-0569-43ef-85f1-286ffbc71c8d")
    public Monstre(String nom, int vie, int maxVie, int mana, int maxMana, int force, int maxForce, int intelligence, int maxIntelligence, int agilite, int maxAgilite, int constitution, int maxConstitution, int resistance, int maxResistance, int pa, int maxPa, Type type, int experienceDonnee) {
        super(nom, vie, maxVie, mana, maxMana, force, maxForce, intelligence,
                maxIntelligence, agilite, maxAgilite, constitution, maxConstitution,
                resistance, maxResistance, pa, maxPa);
        this.type = type;
        this.experienceDonnee = experienceDonnee;
        // TODO Auto-generated constructor stub
    }

    @objid ("f841b9d6-8508-4503-9c5b-54cf98c9be82")
    public Monstre(String nom, int maxVie, int maxMana, int maxForce, int maxIntelligence, int maxAgilite, int maxConstitution, int maxResistance, int maxPa, Type type, int experienceDonnee) {
        super(nom, maxVie,  maxMana, maxForce, 
                maxIntelligence, maxAgilite,  maxConstitution,
                 maxResistance,  maxPa);
        this.type = type;
        this.experienceDonnee = experienceDonnee;
    }

    @objid ("dab96950-9945-4936-a195-bae95a0a5712")
    public Type getType() {
        return type;
    }

    @objid ("0b137cbb-5a80-48e7-8c4a-7b577cc5c81e")
    public void setType(Type type) {
        this.type = type;
    }

    @objid ("20f74fbb-faa2-40fb-9cf4-05ecf1e2b4bf")
    public int getExperienceDonnee() {
        return experienceDonnee;
    }

    @objid ("7b093d22-b8ac-4a6d-80be-258106726eba")
    public void setExperienceDonnee(int experienceDonnee) {
        this.experienceDonnee = experienceDonnee;
    }

    @objid ("1fc15f83-906e-4c97-af00-52b52937e0b6")
    public int attaqueSelonHeros(Heros h) {
        if(h.getVie()>80*(h.getMaxVie()/100) && this.getVie()>80*(this.getMaxVie()/100))
            return 1;
        else if(h.getVie()>40*(h.getMaxVie()/100) && this.getVie()>60*(this.getMaxVie()/100))
            return 2;
        else if(this.getVie()< 40*(this.getMaxVie()/100)){
            
            return 3;
  
        }
        return 0;
    }

    @objid ("07f18b4c-2b90-4713-8d02-e5f378ab6ebd")
    @Override
    public String toString() {
        return "Monstre [type=" + type + "]";
    }

}
