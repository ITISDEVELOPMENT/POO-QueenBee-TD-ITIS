package queenbee.td1.apres;

import queenbee.td1.donnees.Alerte;
import queenbee.td1.donnees.Mesure;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Indicateurs {

    /** UC-CY02 : garder les mesures plausibles, sans les rejeux. */
    public List<Mesure> mesuresValides(List<Mesure> mesures) {
        return null;
    }

    /** UC-CY02 : nombre de trames écartées. */
    public int nombreTramesEcartees(List<Mesure> mesures) {
        long nombreValides = mesuresValides(mesures).stream().count();
        return mesures.size() - (int) nombreValides;
    }

    /** UC-C01 : les n alertes non traitées les plus sûres d'un site. */
    public List<String> visitesPrioritaires(List<Alerte> alertes, String site, int n) {
       return null;
    }
}
