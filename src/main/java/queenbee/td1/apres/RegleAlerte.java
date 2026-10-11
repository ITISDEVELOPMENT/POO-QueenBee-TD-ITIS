package queenbee.td1.apres;

import queenbee.td1.donnees.Mesure;

/**
 * Interface FONCTIONNELLE : une seule méthode abstraite.
 * On peut donc écrire chaque règle avec une expression Lambda.
 */
@FunctionalInterface
public interface RegleAlerte {

    boolean estDeclenchee(Mesure mesure);
}
