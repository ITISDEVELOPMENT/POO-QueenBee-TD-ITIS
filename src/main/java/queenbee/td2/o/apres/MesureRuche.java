package queenbee.td2.o.apres;

/** Les mesures d'une ruche sur 24 h, regroupées dans un seul objet. */
public record MesureRuche(String idRuche, double chutePoidsKg, double temperatureC,
                          double humiditePct, double niveauSonoreDb) {
}
