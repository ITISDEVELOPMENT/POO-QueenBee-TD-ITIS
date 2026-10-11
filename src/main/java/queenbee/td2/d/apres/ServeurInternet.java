package queenbee.td2.d.apres;

/** Détail technique : le vrai serveur. Il IMPLÉMENTE l'abstraction Serveur. */
public class ServeurInternet implements Serveur {

    private boolean reseauDisponible;

    public ServeurInternet(boolean reseauDisponible) {
        this.reseauDisponible = reseauDisponible;
    }

    public void changerReseau(boolean reseauDisponible) {
        this.reseauDisponible = reseauDisponible;
    }

    @Override
    public boolean estJoignable() {
        return reseauDisponible;
    }

    @Override
    public void envoyer(Inspection inspection) {
        System.out.println("Envoi au serveur : " + inspection.idRuche());
    }
}
