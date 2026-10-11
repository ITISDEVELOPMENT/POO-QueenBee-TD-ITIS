package queenbee.td2.o.avant;

import java.util.ArrayList;
import java.util.List;

/**
 * Évaluer les risques d'une ruche (UC-A02) — AVANT.
 * Un « if » par risque : pour ajouter un risque, il faut MODIFIER cette méthode.
 */
public class EvaluateurRisques {

    public List<String> evaluer(double chutePoidsKg, double temperatureC, double niveauSonoreDb) {
        List<String> risques = new ArrayList<>();
        if (chutePoidsKg > 2.5) {
            risques.add("ESSAIMAGE");
        }
        if (temperatureC > 38) {
            risques.add("STRESS_THERMIQUE");
        }
        if (niveauSonoreDb > 90) {
            risques.add("ACTIVITE_ACOUSTIQUE");
        }
        return risques;
    }
}
