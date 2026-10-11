package queenbee.td3.exercice;

/**
 * EXERCICE (UC-A03 « Déclaration d'une récolte ») : rendre ce code lisible SANS changer son résultat.
 * Règles métier : une déclaration est acceptée si le volume est positif et ne dépasse pas
 * 60 kg (maximum réaliste pour une ruche), et si la date est renseignée.
 */
public class ExerciceDeclaration {

    // verifie
    public boolean ok(double v, String d) {
        if (v > 0) {
            if (v <= 60) {
                if (d != null && !d.isEmpty()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
