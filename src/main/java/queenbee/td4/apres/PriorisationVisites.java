package queenbee.td4.apres;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UC-C01 « Priorisation des visites terrain » — APRÈS refactoring.
 * ÉTAPE 4 : Replace Loop with Pipeline (Alt+Entrée). Les boucles deviennent un Stream.
 */
public class PriorisationVisites {

    public static final double SEUIL_CHUTE_POIDS_KG = 2.5;
    public static final double TEMPERATURE_MAX_C = 38;
    public static final double NIVEAU_SONORE_MAX_DB = 90;
    public static final int SCORE_ESSAIMAGE = 3;
    public static final int SCORE_CHALEUR = 2;
    public static final int SCORE_BRUIT = 1;

    /** Fonctionnalité 1 : le score de risque d'une ruche. */
    public int calculerScore(MesureRuche mesure) {
        int score = 0;
        if (mesure.chutePoidsKg() > SEUIL_CHUTE_POIDS_KG) {
            score += SCORE_ESSAIMAGE;
        }
        if (mesure.temperatureC() > TEMPERATURE_MAX_C) {
            score += SCORE_CHALEUR;
        }
        if (mesure.niveauSonoreDb() > NIVEAU_SONORE_MAX_DB) {
            score += SCORE_BRUIT;
        }
        return score;
    }

    /** Fonctionnalité 2 : les ruches à visiter en priorité. */
    public List<String> prioriser(List<MesureRuche> mesures, int nombreDeVisites) {
        return mesures.stream()
                .map(mesure -> new ScoreRuche(mesure.idRuche(), calculerScore(mesure)))
                .filter(ruche -> ruche.score() > 0)
                .sorted(Comparator.comparingInt(ScoreRuche::score).reversed())
                .limit(nombreDeVisites)
                .map(ScoreRuche::toString)
                .collect(Collectors.toList());
    }
}
