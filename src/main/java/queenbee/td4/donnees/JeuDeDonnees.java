package queenbee.td4.donnees;

import java.util.List;

/**
 * Mesures des dernières 24 h, telles que la passerelle les envoie :
 * { idRuche, chutePoidsKg, temperatureC, niveauSonoreDb }
 */
public final class JeuDeDonnees {

    private JeuDeDonnees() {
    }

    public static final List<String[]> MESURES = List.of(
            new String[]{"R-01", "3.1", "35.0", "95"},     // essaimage + bruit      -> 3 + 1 = 4
            new String[]{"R-02", "0.2", "39.5", "60"},     // chaleur                -> 2
            new String[]{"R-03", "0.0", "34.0", "55"},     // rien                   -> 0
            new String[]{"R-04", "2.8", "38.6", "70"},     // essaimage + chaleur    -> 3 + 2 = 5
            new String[]{"R-05", "0.4", "36.0", "92"});    // bruit                  -> 1
}
