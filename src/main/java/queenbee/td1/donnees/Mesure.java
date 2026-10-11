package queenbee.td1.donnees;

/**
 * Une mesure envoyée par le capteur d'une ruche (UC-T02).
 * Un record est une classe immuable : Java écrit pour nous le constructeur,
 * les accesseurs (poidsKg()...), equals, hashCode et toString.
 */
public record Mesure(String idRuche, String site, double poidsKg, double temperatureC) {
}
