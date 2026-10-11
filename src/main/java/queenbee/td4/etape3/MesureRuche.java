package queenbee.td4.etape3;

public record MesureRuche(String idRuche, double chutePoidsKg, double temperatureC, double niveauSonoreDb) {

    public static MesureRuche depuisTrame(String[] trame) {
        return new MesureRuche(trame[0], Double.parseDouble(trame[1]),
                Double.parseDouble(trame[2]), Double.parseDouble(trame[3]));
    }
}
