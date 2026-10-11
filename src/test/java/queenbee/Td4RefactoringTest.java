package queenbee;

import org.junit.jupiter.api.Test;
import queenbee.td4.donnees.JeuDeDonnees;
import queenbee.td4.exercice.CorrectionTrame;
import queenbee.td4.exercice.ExerciceTrame;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * TD4 : test de caractérisation. On l'écrit AVANT de modifier le code :
 * il fige le résultat actuel, puis il doit rester vert après chaque étape.
 */
class Td4RefactoringTest {

    private static final List<String> RESULTAT_DE_REFERENCE =
            List.of("R-04 (score 5)", "R-01 (score 4)", "R-02 (score 2)");

    @Test
    void code_de_depart() {
        assertEquals(RESULTAT_DE_REFERENCE, new queenbee.td4.avant.Prio().top(JeuDeDonnees.MESURES, 3));
    }

    @Test
    void etape_1_rename_et_constantes() {
        assertEquals(RESULTAT_DE_REFERENCE,
                new queenbee.td4.etape1.PriorisationVisites().prioriser(JeuDeDonnees.MESURES, 3));
    }

    @Test
    void etape_2_objet_mesure() {
        var mesures = JeuDeDonnees.MESURES.stream()
                .map(queenbee.td4.etape2.MesureRuche::depuisTrame).collect(Collectors.toList());
        assertEquals(RESULTAT_DE_REFERENCE, new queenbee.td4.etape2.PriorisationVisites().prioriser(mesures, 3));
    }

    @Test
    void etape_3_extraction_de_methodes() {
        var mesures = JeuDeDonnees.MESURES.stream()
                .map(queenbee.td4.etape3.MesureRuche::depuisTrame).collect(Collectors.toList());
        assertEquals(RESULTAT_DE_REFERENCE, new queenbee.td4.etape3.PriorisationVisites().prioriser(mesures, 3));
    }

    @Test
    void etape_4_stream() {
        var mesures = JeuDeDonnees.MESURES.stream()
                .map(queenbee.td4.apres.MesureRuche::depuisTrame).collect(Collectors.toList());
        assertEquals(RESULTAT_DE_REFERENCE, new queenbee.td4.apres.PriorisationVisites().prioriser(mesures, 3));
    }

    @Test
    void le_score_se_teste_seul_apres_extraction() {
        var priorisation = new queenbee.td4.apres.PriorisationVisites();
        assertEquals(5, priorisation.calculerScore(new queenbee.td4.apres.MesureRuche("R-04", 2.8, 38.6, 70)));
        assertEquals(0, priorisation.calculerScore(new queenbee.td4.apres.MesureRuche("R-03", 2.5, 38, 90)));
    }

    @Test
    void exercice_trame_meme_resultat() {
        ExerciceTrame avant = new ExerciceTrame();
        CorrectionTrame apres = new CorrectionTrame();
        String[][] trames = {
                {"R-01", "42.0", "34.5"}, {"R-02", "999", "35"}, {"R-03", "-1", "35"},
                {"R-04", "40", "61"}, {"R-05", "40", "-10"}, {"R-06", "150", "60"}};
        for (String[] trame : trames) {
            assertEquals(avant.v(trame), apres.estPlausible(trame));
        }
    }
}
