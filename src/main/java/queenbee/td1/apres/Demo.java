package queenbee.td1.apres;

import queenbee.td1.donnees.JeuDeDonnees;
import queenbee.td1.donnees.Mesure;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        SelecteurMesures selecteur = new SelecteurMesures();

        // Chaque règle est maintenant une Lambda : plus besoin de RegleChaleur ni de RegleColonieAffaiblie
        RegleAlerte chaleur = mesure -> mesure.temperatureC() > 38;
        RegleAlerte colonieAffaiblie = mesure -> mesure.poidsKg() < 15;

        System.out.println("Chaleur (> 38 C)      : " + ids(selecteur.selectionner(JeuDeDonnees.MESURES, chaleur)));
        System.out.println("Colonie affaiblie     : " + ids(selecteur.selectionner(JeuDeDonnees.MESURES, colonieAffaiblie)));

        Indicateurs indicateurs = new Indicateurs();
        System.out.println("Trames ecartees       : " + indicateurs.nombreTramesEcartees(JeuDeDonnees.MESURES));
        System.out.println("Visites prioritaires  : " + indicateurs.visitesPrioritaires(JeuDeDonnees.ALERTES, "Thies", 2));
    }

    /** Affiche seulement les identifiants des ruches. */
    private static List<String> ids(List<Mesure> mesures) {
        List<String> ids = new ArrayList<>();
        for (Mesure mesure : mesures) {
            ids.add(mesure.idRuche());
        }
        return ids;
    }
}
