package queenbee.td1.avant;

import queenbee.td1.donnees.Mesure;

/** Encore une classe complète pour une seule comparaison. */
public class RegleColonieAffaiblie implements RegleAlerte {

    private final double poidsMinKg;

    public RegleColonieAffaiblie(double poidsMinKg) {
        this.poidsMinKg = poidsMinKg;
    }

    @Override
    public boolean estDeclenchee(Mesure mesure) {
        return mesure.poidsKg() < poidsMinKg;
    }
}
