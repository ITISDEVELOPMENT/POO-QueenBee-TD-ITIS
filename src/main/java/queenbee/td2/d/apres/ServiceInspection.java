package queenbee.td2.d.apres;

/**
 * UC-A01 — APRÈS : le service REÇOIT le serveur par son constructeur
 * et ne connaît que l'interface Serveur.
 */
public class ServiceInspection {

    private final StockageTelephone stockage;
    private final Serveur serveur;

    public ServiceInspection(StockageTelephone stockage, Serveur serveur) {
        this.stockage = stockage;
        this.serveur = serveur;
    }

    public void enregistrer(Inspection inspection) {
        stockage.sauvegarder(inspection);
        synchroniser();
    }

    public void synchroniser() {
        if (serveur.estJoignable()) {
            for (Inspection aEnvoyer : stockage.enAttente()) {
                serveur.envoyer(aEnvoyer);
            }
            stockage.enAttente().clear();
        }
    }
}
