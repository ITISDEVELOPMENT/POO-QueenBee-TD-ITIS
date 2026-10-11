package queenbee.td2.s.apres;

import java.util.ArrayList;
import java.util.List;

/** Responsabilité 3 : TRACER. Change seulement si le format du journal change. */
public class JournalAlertes {

    private final List<String> lignes = new ArrayList<>();

    public void tracer(String idRuche, String typeRisque) {
        lignes.add(idRuche + ";" + typeRisque);
    }

    public List<String> lignes() {
        return lignes;
    }
}
