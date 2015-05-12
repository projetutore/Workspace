package jobs;

public class Monstre extends Personnage {
    private int experienceDonnee;

    public Type type;

    public Monstre(Monstre choisi) {
        super(choisi);
        this.type = choisi.getType();
        this.experienceDonnee = this.getExperienceDonnee();
    }

    public Monstre(String nom, int vie, int mana, int force, int intelligence, int agilite,
    		int constitution,int resistance, int maxPa, Type type, int experienceDonnee) {
        super(nom, vie, mana, force, intelligence,
                agilite, constitution,
                resistance, maxPa);
        this.type = type;
        this.experienceDonnee = experienceDonnee;
        // TODO Auto-generated constructor stub
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getExperienceDonnee() {
        return experienceDonnee;
    }

    public void setExperienceDonnee(int experienceDonnee) {
        this.experienceDonnee = experienceDonnee;
    }
    
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

    public String toString() {
        return "Monstre [type=" + type + "]";
    }

	public void remiseAttaque() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remiseDegats() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remiseDegree() {
		// TODO Auto-generated method stub
		
	}

}
