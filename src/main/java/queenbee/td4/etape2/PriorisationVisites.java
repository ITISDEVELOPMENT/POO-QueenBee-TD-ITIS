package queenbee.td4.etape2;

import java.util.ArrayList;
import java.util.List;

/** ÉTAPE 2 : on travaille avec des MesureRuche au lieu de String[]. */
public class PriorisationVisites {

    public static final double SEUIL_CHUTE_POIDS_KG = 2.5;
    public static final double TEMPERATURE_MAX_C = 38;
    public static final double NIVEAU_SONORE_MAX_DB = 90;
    public static final int SCORE_ESSAIMAGE = 3;
    public static final int SCORE_CHALEUR = 2;
    public static final int SCORE_BRUIT = 1;

    public List<String> prioriser(List<MesureRuche> mesures, int nombreDeVisites) {
        List<String> idsRuches = new ArrayList<>();
        List<Integer> scores = new ArrayList<>();
        for (MesureRuche mesure : mesures) {
            int score = 0;
            if (mesure.chutePoidsKg() > SEUIL_CHUTE_POIDS_KG) score = score + SCORE_ESSAIMAGE;
            if (mesure.temperatureC() > TEMPERATURE_MAX_C) score = score + SCORE_CHALEUR;
            if (mesure.niveauSonoreDb() > NIVEAU_SONORE_MAX_DB) score = score + SCORE_BRUIT;
            if (score > 0) {
                idsRuches.add(mesure.idRuche());
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
