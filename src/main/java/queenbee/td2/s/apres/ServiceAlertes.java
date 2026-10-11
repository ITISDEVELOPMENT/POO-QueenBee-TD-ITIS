package queenbee.td2.s.apres;

/** Le service ne fait qu'ENCHAÎNER les trois responsabilités. */
public class ServiceAlertes {

    private final DetecteurEssaimage detecteur;
    private final NotificateurSms notificateur;
    private final JournalAlertes journal;

    public ServiceAlertes(DetecteurEssaimage detecteur, NotificateurSms notificateur, JournalAlertes journal) {
        this.detecteur = detecteur;
        this.notificateur = notificateur;
        this.journal = journal;
    }

    public void traiterPesee(String idRuche, double poidsHierKg, double poidsAujourdhuiKg) {
        if (detecteur.estEnEssaimage(poidsHierKg, poidsAujourdhuiKg)) {
            notificateur.prevenir("Risque d'essaimage sur " + idRuche);
            journal.tracer(idRuche, "ESSAIMAGE");
        }
    }
}
