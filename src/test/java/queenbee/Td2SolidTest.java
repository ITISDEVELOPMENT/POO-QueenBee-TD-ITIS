package queenbee;

import org.junit.jupiter.api.Test;
import queenbee.td2.d.apres.Inspection;
import queenbee.td2.d.apres.Serveur;
import queenbee.td2.d.apres.ServiceInspection;
import queenbee.td2.d.apres.StockageTelephone;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Td2SolidTest {

    @Test
    void S_le_detecteur_se_teste_seul() {
        var detecteur = new queenbee.td2.s.apres.DetecteurEssaimage(2.5);
        assertTrue(detecteur.estEnEssaimage(42.0, 39.0));
        assertFalse(detecteur.estEnEssaimage(40.0, 37.5));
    }

    @Test
    void S_meme_journal_avant_et_apres() {
        var avant = new queenbee.td2.s.avant.GestionAlertes();
        var journal = new queenbee.td2.s.apres.JournalAlertes();
        var apres = new queenbee.td2.s.apres.ServiceAlertes(new queenbee.td2.s.apres.DetecteurEssaimage(2.5),
                new queenbee.td2.s.apres.NotificateurSms(), journal);
        ConsoleCapturee.capturer(() -> {
            avant.traiterPesee("R-01", 42.0, 39.0);
            apres.traiterPesee("R-01", 42.0, 39.0);
        });
        assertEquals(avant.journal(), journal.lignes());
    }

    @Test
    void O_memes_risques_avant_et_apres_puis_extension_sans_modification() {
        var avant = new queenbee.td2.o.avant.EvaluateurRisques();
        var apres = new queenbee.td2.o.apres.EvaluateurRisques(List.of(
                new queenbee.td2.o.apres.RegleEssaimage(2.5),
                new queenbee.td2.o.apres.RegleStressThermique(38),
                new queenbee.td2.o.apres.RegleActiviteAcoustique(90)));
        assertEquals(avant.evaluer(3.1, 35.0, 95),
                apres.evaluer(new queenbee.td2.o.apres.MesureRuche("R-01", 3.1, 35.0, 60, 95)));

        var etendu = new queenbee.td2.o.apres.EvaluateurRisques(
                List.of(new queenbee.td2.exercice.RegleHumiditeExcessive(80)));
        assertEquals(List.of("HUMIDITE_EXCESSIVE"),
                etendu.evaluer(new queenbee.td2.o.apres.MesureRuche("R-07", 0.1, 33.0, 88, 60)));
    }

    /** Faux serveur : possible seulement parce que le service dépend de l'interface Serveur. */
    private static final class FauxServeur implements Serveur {
        boolean joignable;
        final List<String> recus = new ArrayList<>();

        public boolean estJoignable() {
            return joignable;
        }

        public void envoyer(Inspection inspection) {
            recus.add(inspection.idRuche());
        }
    }

    @Test
    void D_hors_ligne_puis_synchronisation_au_retour_du_reseau() {
        FauxServeur serveur = new FauxServeur();
        StockageTelephone stockage = new StockageTelephone();
        ServiceInspection service = new ServiceInspection(stockage, serveur);

        service.enregistrer(new Inspection("R-01", "ok"));
        service.enregistrer(new Inspection("R-02", "reine absente"));
        assertEquals(List.of(), serveur.recus);

        serveur.joignable = true;
        service.synchroniser();
        assertEquals(List.of("R-01", "R-02"), serveur.recus);
        assertEquals(0, stockage.enAttente().size());
    }
}
