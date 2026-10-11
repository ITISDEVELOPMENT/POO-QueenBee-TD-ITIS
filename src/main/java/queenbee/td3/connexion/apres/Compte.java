package queenbee.td3.connexion.apres;

/** Un compte utilisateur : toutes ses informations au même endroit. */
public class Compte {

    private final String motDePasse;
    private final Role role;
    private int tentativesEchouees;

    public Compte(String motDePasse, Role role) {
        this.motDePasse = motDePasse;
        this.role = role;
    }

    public boolean motDePasseCorrect(String motDePasseSaisi) {
        return motDePasse.equals(motDePasseSaisi);
    }

    public Role role() {
        return role;
    }

    public int tentativesEchouees() {
        return tentativesEchouees;
    }

    public void ajouterEchec() {
        tentativesEchouees++;
    }

    public void remettreEchecsAZero() {
        tentativesEchouees = 0;
    }
}
