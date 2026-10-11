package queenbee.td2.d.avant;

/**
 * UC-A01 « Inspection hors ligne » — AVANT.
 * Le service CRÉE lui-même ses outils techniques avec new : il en dépend directement.
 */
public class ServiceInspection {

    private final StockageTelephone stockage = new StockageTelephone();
    private final ServeurCentral serveur = new ServeurCentral();

    public void enregistrer(Inspection inspection) {
        stockage.sauvegarder(inspection);
        if (serveur.estJoignable()) {
            for (Inspection aEnvoyer : stockage.enAttente()) {
                serveur.envoyer(aEnvoyer);
            }
            stockage.enAttente().clear();
        }
    }
}
