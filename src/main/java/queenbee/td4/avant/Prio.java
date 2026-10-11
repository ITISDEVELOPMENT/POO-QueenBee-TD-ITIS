package queenbee.td4.avant;

import java.util.ArrayList;
import java.util.List;

/**
 * UC-C01 « Priorisation des visites terrain » — CODE DE DÉPART.
 * Fonctionnalité 1 : calculer le score de risque d'une ruche.
 * Fonctionnalité 2 : classer les ruches et garder les n plus urgentes.
 */
public class Prio {

    // l : liste de mesures [id, chute de poids, temperature, son]
    public List<String> top(List<String[]> l, int n) {
        List<String> ids = new ArrayList<>();
        List<Integer> scs = new ArrayList<>();
        for (String[] m : l) {
            int s = 0;
            if (Double.parseDouble(m[1]) > 2.5) s = s + 3;
            if (Double.parseDouble(m[2]) > 38) s = s + 2;
            if (Double.parseDouble(m[3]) > 90) s = s + 1;
            if (s > 0) {
                ids.add(m[0]);
                scs.add(s);
            }
        }
        // tri
        for (int i = 0; i < scs.size(); i++) {
            for (int j = 0; j < scs.size() - 1 - i; j++) {
                if (scs.get(j) < scs.get(j + 1)) {
                    int t = scs.get(j);
                    scs.set(j, scs.get(j + 1));
                    scs.set(j + 1, t);
                    String u = ids.get(j);
                    ids.set(j, ids.get(j + 1));
                    ids.set(j + 1, u);
                }
            }
        }
        List<String> r = new ArrayList<>();
        for (int i = 0; i < ids.size() && i < n; i++) {
            r.add(ids.get(i) + " (score " + scs.get(i) + ")");
        }
        return r;
    }
}
