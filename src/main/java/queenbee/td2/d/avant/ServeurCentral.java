package queenbee.td2.d.avant;

/** Détail technique : le vrai serveur, sur Internet (simulé). */
public class ServeurCentral {

    public boolean estJoignable() {
        return false;   // sur un rucher isolé : souvent faux, et impossible à changer dans un test
    }

    public void envoyer(Inspection inspection) {
        System.out.println("Envoi au serveur : " + inspection.idRuche());
    }
}
