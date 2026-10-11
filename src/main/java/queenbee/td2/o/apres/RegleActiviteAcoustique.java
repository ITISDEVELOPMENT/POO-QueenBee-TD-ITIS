package queenbee.td2.o.apres;

public class RegleActiviteAcoustique implements RegleRisque {

    private final double niveauMaxDb;

    public RegleActiviteAcoustique(double niveauMaxDb) {
        this.niveauMaxDb = niveauMaxDb;
    }

    @Override
    public String nom() {
        return "ACTIVITE_ACOUSTIQUE";
    }

    @Override
    public boolean estDeclenchee(MesureRuche mesure) {
        return mesure.niveauSonoreDb() > niveauMaxDb;
    }
}
