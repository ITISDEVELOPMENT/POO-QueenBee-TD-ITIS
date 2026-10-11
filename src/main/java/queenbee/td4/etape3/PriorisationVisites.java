package queenbee.td4.etape3;

import java.util.ArrayList;
import java.util.List;

/** ÉTAPE 3 : Extract Method (Ctrl+Alt+M). Le calcul du score devient une méthode à part. */
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
        List<ScoreRuche> aVisiter = new ArrayList<>();
        for (MesureRuche mesure : mesures) {
            int score = calculerScore(mesure);
            if (score > 0) {
                aVisiter.add(new ScoreRuche(mesure.idRuche(), score));
            }
        }
        trierParScoreDecroissant(aVisiter);
        List<String> visites = new ArrayList<>();
        for (int i = 0; i < aVisiter.size() && i < nombreDeVisites; i++) {
            visites.add(aVisiter.get(i).toString());
        }
        return visites;
    }

    private void trierParScoreDecroissant(List<ScoreRuche> ruches) {
        for (int i = 0; i < ruches.size(); i++) {
            for (int j = 0; j < ruches.size() - 1 - i; j++) {
                if (ruches.get(j).score() < ruches.get(j + 1).score()) {
                    ScoreRuche temporaire = ruches.get(j);
                    ruches.set(j, ruches.get(j + 1));
                    ruches.set(j + 1, temporaire);
                }
            }
        }
    }
}
