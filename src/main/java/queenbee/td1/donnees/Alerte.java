package queenbee.td1.donnees;

/** Une alerte de risque sur une ruche (CDC § 7.1 : type de risque, niveau de confiance, statut). */
public record Alerte(String idRuche, String site, String typeRisque, double confiance, boolean traitee) {
}
