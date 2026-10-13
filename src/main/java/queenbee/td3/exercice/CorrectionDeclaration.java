package queenbee.td3.exercice;

/** CORRECTION de l'exercice : même résultat, code lisible. */
public class CorrectionDeclaration {

    public static final double VOLUME_MAXIMUM_PAR_RUCHE_KG = 60;
     public static final double VOLUME_MINIMUM_PAR_RUCHE_KG = 0;

    public boolean declarationAcceptable(double volumeKg, String dateRecolte) {
        return volumeRealiste(volumeKg) && dateRenseignee(dateRecolte);
    }

    private boolean volumeRealiste(double volumeKg) {
        return volumeKg > VOLUME_MINIMUM_PAR_RUCHE_KG && volumeKg <= VOLUME_MAXIMUM_PAR_RUCHE_KG;
    }

    private boolean dateRenseignee(String dateRecolte) {
        return dateRecolte != null && !dateRecolte.isEmpty();
    }
}

