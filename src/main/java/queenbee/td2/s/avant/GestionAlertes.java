package queenbee.td2.s.avant;

import java.util.ArrayList;
import java.util.List;

/**
 * UC-A02 « Réception d'une alerte » — AVANT.
 * Cette classe fait TROIS choses : détecter, prévenir, tracer.
 */
public class GestionAlertes {

    private final List<String> journal = new ArrayList<>();

    public void traiterPesee(String idRuche, double poidsHierKg, double poidsAujourdhuiKg) {
        // 1. Détecter : une chute de plus de 2,5 kg en un jour = essaimage
        double chuteKg = poidsHierKg - poidsAujourdhuiKg;
        if (chuteKg > 2.5) {
            String message = "Risque d'essaimage sur " + idRuche;

            // 2. Prévenir l'apicultrice
            System.out.println("SMS : " + message);

            // 3. Tracer (exigence de traçabilité du CDC)
            journal.add(idRuche + ";ESSAIMAGE");
        }
    }

    public List<String> journal() {
        return journal;
    }
}
