package queenbee.td1.avant;

import queenbee.td1.donnees.Mesure;

import java.util.ArrayList;
import java.util.List;

public class SelecteurMesures {

    /** Garde les mesures qui déclenchent la règle reçue en paramètre. */
    public List<Mesure> selectionner(List<Mesure> mesures, RegleAlerte regle) {
        List<Mesure> resultat = new ArrayList<>();
        for (Mesure mesure : mesures) {
            if (regle.estDeclenchee(mesure)) {
                resultat.add(mesure);
            }
        }
        return resultat;
    }
}
