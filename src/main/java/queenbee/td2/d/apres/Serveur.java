package queenbee.td2.d.apres;

/** ABSTRACTION : ce dont le métier a besoin, sans dire comment c'est fait. */
public interface Serveur {

    boolean estJoignable();

    void envoyer(Inspection inspection);
}
