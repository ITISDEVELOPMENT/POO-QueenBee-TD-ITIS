package queenbee.td4.exercice;

/** CORRECTION : même résultat que ExerciceTrame.v(), pour toutes les trames. */
public class CorrectionTrame {

    public static final double POIDS_MIN_KG = 0;
    public static final double POIDS_MAX_KG = 150;
    public static final double TEMPERATURE_MIN_C = -10;
    public static final double TEMPERATURE_MAX_C = 60;

    public boolean estPlausible(String[] trame) {
        double poidsKg = Double.parseDouble(trame[1]);
        double temperatureC = Double.parseDouble(trame[2]);
        return estEntre(poidsKg, POIDS_MIN_KG, POIDS_MAX_KG)
                && estEntre(temperatureC, TEMPERATURE_MIN_C, TEMPERATURE_MAX_C);
    }

    private boolean estEntre(double valeur, double minimum, double maximum) {
        return valeur >= minimum && valeur <= maximum;
    }
}
