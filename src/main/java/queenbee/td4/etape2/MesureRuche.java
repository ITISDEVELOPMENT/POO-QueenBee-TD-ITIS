package queenbee.td4.etape2;

/** ÉTAPE 2 : Introduce Parameter Object. Un objet nommé remplace le tableau String[]. */
public record MesureRuche(String idRuche, double chutePoidsKg, double temperatureC, double niveauSonoreDb) {

    /** Convertit la trame envoyée par la passerelle. C'est le SEUL endroit qui lit les indices. */
    public static MesureRuche depuisTrame(String[] trame) {
        return new MesureRuche(trame[0], Double.parseDouble(trame[1]),
                Double.parseDouble(trame[2]), Double.parseDouble(trame[3]));
    }
}
