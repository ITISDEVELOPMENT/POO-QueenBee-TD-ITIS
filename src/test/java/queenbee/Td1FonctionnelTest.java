package queenbee;

import org.junit.jupiter.api.Test;
import queenbee.td1.donnees.JeuDeDonnees;
import queenbee.td1.exercice.ExercicePoidsMoyen;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** TD1 : la version Lambda / Streams donne les mêmes résultats que la version classique. */
class Td1FonctionnelTest {

    @Test
    void une_lambda_selectionne_les_memes_mesures_qu_une_classe() {
        var avant = new queenbee.td1.avant.SelecteurMesures()
                .selectionner(JeuDeDonnees.MESURES, new queenbee.td1.avant.RegleChaleur(38));
        var apres = new queenbee.td1.apres.SelecteurMesures()
                .selectionner(JeuDeDonnees.MESURES, mesure -> mesure.temperatureC() > 38);
        assertEquals(avant, apres);
    }

    @Test
    void trames_valides_identiques_avant_et_apres() {
        var avant = new queenbee.td1.avant.Indicateurs();
        var apres = new queenbee.td1.apres.Indicateurs();
        assertEquals(avant.mesuresValides(JeuDeDonnees.MESURES), apres.mesuresValides(JeuDeDonnees.MESURES));
        assertEquals(2, apres.nombreTramesEcartees(JeuDeDonnees.MESURES));
    }

    @Test
    void visites_prioritaires_identiques_avant_et_apres() {
        var apres = new queenbee.td1.apres.Indicateurs().visitesPrioritaires(JeuDeDonnees.ALERTES, "Thies", 2);
        assertEquals(List.of("R-01", "R-03"), apres);
        assertEquals(new queenbee.td1.avant.Indicateurs().visitesPrioritaires(JeuDeDonnees.ALERTES, "Thies", 2), apres);
    }

    @Test
    void exercice_poids_moyen() {
        ExercicePoidsMoyen exercice = new ExercicePoidsMoyen();
        for (String site : List.of("Thies", "Bouake", "Inconnu")) {
            assertEquals(exercice.poidsMoyenAvecBoucle(JeuDeDonnees.MESURES, site),
                    exercice.poidsMoyenAvecStream(JeuDeDonnees.MESURES, site), 1e-9);
        }
    }
}
