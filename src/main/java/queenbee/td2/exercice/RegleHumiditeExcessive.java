package queenbee.td2.exercice;

import queenbee.td2.o.apres.MesureRuche;
import queenbee.td2.o.apres.RegleRisque;

/**
 * EXERCICE (CORRECTION) : l'équipe Data ajoute le risque « humidité excessive » (> 80 %),
 * favorable aux maladies de la colonie. On l'ajoute SANS modifier EvaluateurRisques.
 */
public class RegleHumiditeExcessive implements RegleRisque {

    //private final double humiditeMaxPct;

    /** Ecrire un constructeur pour initialiser la valeur **/

    /** Retourner le type HUMIDITE EXCESSIVE un constructeur pour initialiser la valeur **/
    @Override
    public String nom() {
        return null;
    }

    /** Comparaison entre mesure humidité mesuré et humiditeMaxPct **/
    @Override
    public boolean estDeclenchee(MesureRuche mesure) {
        return false;
    }
}
