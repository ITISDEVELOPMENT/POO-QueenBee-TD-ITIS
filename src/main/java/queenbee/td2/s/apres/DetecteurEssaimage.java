package queenbee.td2.s.apres;

/** Responsabilité 1 : DÉTECTER. Change seulement si la règle de l'équipe Data change. */
public class DetecteurEssaimage {

    private final double seuilChuteKg;

    public DetecteurEssaimage(double seuilChuteKg) {
        this.seuilChuteKg = seuilChuteKg;
    }

    public boolean estEnEssaimage(double poidsHierKg, double poidsAujourdhuiKg) {
        double chuteKg = poidsHierKg - poidsAujourdhuiKg;
        return chuteKg > seuilChuteKg;
    }
}
