package queenbee.td2.o.apres;

import java.util.ArrayList;
import java.util.List;

/** APRÈS : cette classe ne connaît aucun risque en particulier. On n'y touchera plus. */
public class EvaluateurRisques {

    private final List<RegleRisque> regles;

    public EvaluateurRisques(List<RegleRisque> regles) {
        this.regles = regles;
    }

    public List<String> evaluer(MesureRuche mesure) {
        List<String> risques = new ArrayList<>();
        for (RegleRisque regle : regles) {
            if (regle.estDeclenchee(mesure)) {
                risques.add(regle.nom());
            }
        }
        return risques;
    }
}
