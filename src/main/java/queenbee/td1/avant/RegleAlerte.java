package queenbee.td1.avant;

import queenbee.td1.donnees.Mesure;

/** Une règle d'alerte configurée par l'administrateur (CDC § 3.2). */
public interface RegleAlerte {

    boolean estDeclenchee(Mesure mesure);
}
