package queenbee.td4.etape1;

import java.util.ArrayList;
import java.util.List;

/** ÉTAPE 1 : Rename (Maj+F6) et Extract Constant (Ctrl+Alt+C). La logique ne change pas. */
public class PriorisationVisites {

    public static final double SEUIL_CHUTE_POIDS_KG = 2.5;
    public static final double TEMPERATURE_MAX_C = 38;
    public static final double NIVEAU_SONORE_MAX_DB = 90;
    public static final int SCORE_ESSAIMAGE = 3;
    public static final int SCORE_CHALEUR = 2;
    public static final int SCORE_BRUIT = 1;

    public List<String> prioriser(List<String[]> mesures, int nombreDeVisites) {
        List<String> idsRuches = new ArrayList<>();
        List<Integer> scores = new ArrayList<>();
        for (String[] mesure : mesures) {
            int score = 0;
            if (Double.parseDouble(mesure[1]) > SEUIL_CHUTE_POIDS_KG) score = score + SCORE_ESSAIMAGE;
            if (Double.parseDouble(mesure[2]) > TEMPERATURE_MAX_C) score = score + SCORE_CHALEUR;
            if (Double.parseDouble(mesure[3]) > NIVEAU_SONORE_MAX_DB) score = score + SCORE_BRUIT;
            if (score > 0) {
                idsRuches.add(mesure[0]);
                scores.add(score);
            }
        }
        for (int i = 0; i < scores.size(); i++) {
            for (int j = 0; j < scores.size() - 1 - i; j++) {
                if (scores.get(j) < scores.get(j + 1)) {
                    int scoreTemporaire = scores.get(j);
                    scores.set(j, scores.get(j + 1));
                    scores.set(j + 1, scoreTemporaire);
                    String idTemporaire = idsRuches.get(j);
                    idsRuches.set(j, idsRuches.get(j + 1));
                    idsRuches.set(j + 1, idTemporaire);
                }
            }
        }
        List<String> visites = new ArrayList<>();
        for (int i = 0; i < idsRuches.size() && i < nombreDeVisites; i++) {
            visites.add(idsRuches.get(i) + " (score " + scores.get(i) + ")");
        }
        return visites;
    }
}
