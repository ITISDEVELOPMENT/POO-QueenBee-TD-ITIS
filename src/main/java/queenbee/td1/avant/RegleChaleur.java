package queenbee.td1.avant;

import queenbee.td1.donnees.Mesure;

/** Une classe complète... pour une seule comparaison. */
public class RegleChaleur implements RegleAlerte {

    private final double temperatureMaxC;

    public RegleChaleur(double temperatureMaxC) {
        this.temperatureMaxC = temperatureMaxC;
    }

    @Override
    public boolean estDeclenchee(Mesure mesure) {
        return mesure.temperatureC() > temperatureMaxC;
    }
}
