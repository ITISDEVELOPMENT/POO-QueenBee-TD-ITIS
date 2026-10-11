package queenbee.td1.donnees;

import java.util.List;

/** Petit jeu de données : 2 sites, 5 ruches. */
public final class JeuDeDonnees {

    private JeuDeDonnees() {
    }

    public static final List<Mesure> MESURES = List.of(
            new Mesure("R-01", "Thies", 42.0, 34.5),
            new Mesure("R-02", "Thies", 45.4, 39.2),
            new Mesure("R-03", "Thies", 14.2, 35.4),
            new Mesure("R-03", "Thies", 14.2, 35.4),      // rejeu : trame identique
            new Mesure("R-04", "Bouake", 37.3, 39.5),
            new Mesure("R-05", "Bouake", 999.0, 35.6),    // poids impossible
            new Mesure("R-05", "Bouake", 39.9, 35.7));

    public static final List<Alerte> ALERTES = List.of(
            new Alerte("R-01", "Thies", "ESSAIMAGE", 0.92, false),
            new Alerte("R-02", "Thies", "STRESS_THERMIQUE", 0.66, false),
            new Alerte("R-03", "Thies", "COLONIE_AFFAIBLIE", 0.84, false),
            new Alerte("R-01", "Thies", "ACTIVITE_ACOUSTIQUE", 0.71, true),
            new Alerte("R-04", "Bouake", "STRESS_THERMIQUE", 0.58, false));
}
