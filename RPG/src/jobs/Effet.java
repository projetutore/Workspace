package jobs;

import java.io.Serializable;


public class Effet implements Serializable {
    private String nomEffet;

    private int degatsEffet;

    public Effet(Effet effet) {
        // TODO Auto-generated constructor stub
    }

    public Effet(String nomEffet, int degatsEffet) {
        super();
        this.nomEffet = nomEffet;
        this.degatsEffet = degatsEffet;
    }

    public String getNomEffet() {
        return nomEffet;
    }

    public void setNomEffet(String nomEffet) {
        this.nomEffet = nomEffet;
    }

    public int getDegatsEffet() {
        return degatsEffet;
    }

    public void setDegatsEffet(int degatsEffet) {
        this.degatsEffet = degatsEffet;
    }

    @Override
    public String toString() {
        return nomEffet;
    }

}
