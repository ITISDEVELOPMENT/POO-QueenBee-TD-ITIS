package queenbee.td4.exercice;

/**
 * EXERCICE (UC-CY02 « rejeter les trames hors plage physique ») : refactorer cette méthode
 * en suivant la même démarche (test d'abord, puis Rename, Extract Constant, Extract Method).
 * Trame : { idRuche, poidsKg, temperatureC }
 */
public class ExerciceTrame {

    public boolean v(String[] t) {
        if (Double.parseDouble(t[1]) < 0 || Double.parseDouble(t[1]) > 150) {
            return false;
        }
        if (Double.parseDouble(t[2]) < -10 || Double.parseDouble(t[2]) > 60) {
            return false;
        }
        return true;
    }
}
