package queenbee.td1.exercice;

import queenbee.td1.donnees.Mesure;

import java.util.List;

/**
 * EXERCICE (UC-G01 « comparer les sites ») : le gestionnaire veut le poids moyen des ruches d'un site.
 * La version avec boucle est donnée. Écrire la version avec un Stream.
 */
public class ExercicePoidsMoyen {

    /** Version donnée : avec une boucle. */
    public double poidsMoyenAvecBoucle(List<Mesure> mesures, String site) {
        double somme = 0;
        int nombre = 0;
        for (Mesure mesure : mesures) {
            if (mesure.site().equals(site)) {
                somme += mesure.poidsKg();
                nombre++;
            }
        }
        return nombre == 0 ? 0 : somme / nombre;
    }

    /** CORRECTION : avec un Stream. */
    public double poidsMoyenAvecStream(List<Mesure> mesures, String site) {
        return 0.0;
    }
}
