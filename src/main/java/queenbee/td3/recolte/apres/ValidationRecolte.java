package queenbee.td3.recolte.apres;

/**
 * UC-C02 « Validation d'une récolte » : le coordinateur compare la récolte déclarée
 * à la prédiction du modèle et signale les écarts à investiguer.
 */
public class ValidationRecolte {

    /** Au-delà de cet écart, la récolte doit être vérifiée (objectif du CDC : erreur < 15 %). */
    public static final double ECART_TOLERE_POURCENT = 15;

    public String verifier(String idRuche, double volumeDeclareKg, double volumePreditKg) {
        if (estConforme(volumeDeclareKg, volumePreditKg)) {
            return idRuche + " : ok";
        }
        return idRuche + " : a verifier";
    }

    public boolean estConforme(double volumeDeclareKg, double volumePreditKg) {
        double ecart = ecartEnPourcent(volumeDeclareKg, volumePreditKg);
        return Math.abs(ecart) <= ECART_TOLERE_POURCENT;
    }

    public double ecartEnPourcent(double volumeDeclareKg, double volumePreditKg) {
        return (volumeDeclareKg - volumePreditKg) / volumePreditKg * 100;
    }
}
