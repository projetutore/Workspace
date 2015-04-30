package jobs;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("99e302d9-6fc6-4471-aaea-7c746d8c3077")
public class Effet {
    @objid ("764cee19-9ec5-4354-b1d2-a2fe372a9bd1")
    private String nomEffet;

    @objid ("b79e7807-8926-48c7-b958-4a0dc0439bea")
    private int degatsEffet;

    @objid ("1a0c202b-d9df-4eff-b41e-0678c1f0dcee")
    public Effet(Effet effet) {
        // TODO Auto-generated constructor stub
    }

    @objid ("cefc4c4a-9ab3-4958-a5b5-5a95c9aa8f2c")
    public Effet(String nomEffet, int degatsEffet) {
        super();
        this.nomEffet = nomEffet;
        this.degatsEffet = degatsEffet;
    }

    @objid ("18732d7d-3668-4b7d-9dac-ab713adde0b3")
    public String getNomEffet() {
        return nomEffet;
    }

    @objid ("2b087c08-6406-4ac4-90e1-3ebe76333744")
    public void setNomEffet(String nomEffet) {
        this.nomEffet = nomEffet;
    }

    @objid ("11773f7d-b777-4537-bee4-8f9d867534ec")
    public int getDegatsEffet() {
        return degatsEffet;
    }

    @objid ("6c4470f3-ec9a-4f42-a7d6-ee0175db117e")
    public void setDegatsEffet(int degatsEffet) {
        this.degatsEffet = degatsEffet;
    }

    @objid ("025f4d25-626f-43c1-9258-b02f0b5239e5")
    @Override
    public String toString() {
        return nomEffet;
    }

}
