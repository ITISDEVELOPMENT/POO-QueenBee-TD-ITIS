package queenbee.td3.connexion.apres;

/** Les profils du CDC (§ 3.2). Chacun sait s'il doit fournir un code de double authentification. */
public enum Role {

    APICULTRICE(false),
    COORDINATEUR(true),
    GESTIONNAIRE(true),
    ADMINISTRATEUR(true);

    private final boolean exigeCodeDeVerification;

    Role(boolean exigeCodeDeVerification) {
        this.exigeCodeDeVerification = exigeCodeDeVerification;
    }

    public boolean exigeCodeDeVerification() {
        return exigeCodeDeVerification;
    }
}
