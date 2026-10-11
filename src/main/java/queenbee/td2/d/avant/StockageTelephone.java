package queenbee.td2.d.avant;

import java.util.ArrayList;
import java.util.List;

/** Détail technique : la mémoire du téléphone (simulée). */
public class StockageTelephone {

    private final List<Inspection> enAttente = new ArrayList<>();

    public void sauvegarder(Inspection inspection) {
        enAttente.add(inspection);
    }

    public List<Inspection> enAttente() {
        return enAttente;
    }
}
