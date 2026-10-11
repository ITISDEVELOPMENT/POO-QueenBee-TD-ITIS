package queenbee.td1.avant;

import queenbee.td1.donnees.Alerte;
import queenbee.td1.donnees.Mesure;

import java.util.ArrayList;
import java.util.List;

public class Indicateurs {

    /** UC-CY02 : garder les mesures plausibles, sans les rejeux. */
    public List<Mesure> mesuresValides(List<Mesure> mesures) {
        List<Mesure> valides = new ArrayList<>();
        for (Mesure mesure : mesures) {
            boolean plausible = mesure.poidsKg() >= 0 && mesure.poidsKg() <= 150
                    && mesure.temperatureC() >= -10 && mesure.temperatureC() <= 60;
            if (plausible && !valides.contains(mesure)) {
                valides.add(mesure);
            }
        }
        return valides;
    }

    /** UC-CY02 : nombre de trames écartées. */
    public int nombreTramesEcartees(List<Mesure> mesures) {
        return mesures.size() - mesuresValides(mesures).size();
    }

    /** UC-C01 : les n alertes non traitées les plus sûres d'un site. */
    public List<String> visitesPrioritaires(List<Alerte> alertes, String site, int n) {
        List<Alerte> candidates = new ArrayList<>();
        for (Alerte alerte : alertes) {
            if (!alerte.traitee() && alerte.site().equals(site)) {
                candidates.add(alerte);
            }
        }
        candidates.sort(new ComparateurConfiance());
        List<String> visites = new ArrayList<>();
        for (int i = 0; i < candidates.size() && i < n; i++) {
            visites.add(candidates.get(i).idRuche());
        }
        return visites;
    }
}
