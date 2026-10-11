package queenbee.td2.d.apres;

public class Demo {

    public static void main(String[] args) {
        StockageTelephone stockage = new StockageTelephone();
        ServeurInternet serveur = new ServeurInternet(false);           // on est hors ligne
        ServiceInspection service = new ServiceInspection(stockage, serveur);

        service.enregistrer(new Inspection("R-01", "Reine presente, colonie calme"));
        service.enregistrer(new Inspection("R-02", "Reine absente"));
        System.out.println("En attente : " + stockage.enAttente().size());

        serveur.changerReseau(true);                                     // le réseau revient
        service.synchroniser();
        System.out.println("En attente : " + stockage.enAttente().size());
    }
}
