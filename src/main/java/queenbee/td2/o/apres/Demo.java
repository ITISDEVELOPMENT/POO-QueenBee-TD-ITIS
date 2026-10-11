package queenbee.td2.o.apres;

import java.util.List;

public class Demo {

    public static void main(String[] args) {
        EvaluateurRisques evaluateur = new EvaluateurRisques(List.of(
                new RegleEssaimage(2.5),
                new RegleStressThermique(38),
                new RegleActiviteAcoustique(90)));

        System.out.println("R-01 -> " + evaluateur.evaluer(new MesureRuche("R-01", 3.1, 35.0, 60, 95)));
        System.out.println("R-02 -> " + evaluateur.evaluer(new MesureRuche("R-02", 0.2, 39.5, 60, 60)));
    }
}
