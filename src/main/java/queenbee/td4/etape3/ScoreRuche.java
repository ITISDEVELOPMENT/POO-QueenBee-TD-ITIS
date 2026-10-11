package queenbee.td4.etape3;

/** Une ruche et son score : remplace les deux listes parallèles idsRuches / scores. */
public record ScoreRuche(String idRuche, int score) {

    @Override
    public String toString() {
        return idRuche + " (score " + score + ")";
    }
}
