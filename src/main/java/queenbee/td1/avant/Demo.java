package queenbee.td1.avant;

import queenbee.td1.donnees.JeuDeDonnees;
import queenbee.td1.donnees.Mesure;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        SelecteurMesures selecteur = new SelecteurMesures();

        System.out.println("Chaleur (> 38 C)      : "
                + ids(selecteur.selectionner(JeuDeDonnees.MESURES, new RegleChaleur(38))));
        System.out.println("Colonie affaiblie     : "
                + ids(selecteur.selectionner(JeuDeDonnees.MESURES, new RegleColonieAffaiblie(15))));

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
