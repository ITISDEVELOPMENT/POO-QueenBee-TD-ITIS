package queenbee.td2.exercice;

import queenbee.td2.o.apres.EvaluateurRisques;
import queenbee.td2.o.apres.MesureRuche;
import queenbee.td2.o.apres.RegleEssaimage;
import queenbee.td2.o.apres.RegleStressThermique;

import java.util.List;

public class DemoExercice {

    public static void main(String[] args) {
        EvaluateurRisques evaluateur = new EvaluateurRisques(List.of(
                new RegleEssaimage(2.5),
                new RegleStressThermique(38)));
                // completer la ligne Humidité Excessive

       // System.out.println("R-07 -> " + evaluateur.evaluer(new MesureRuche("R-07", 0.1, 33.0, 88, 60)));
    }
}
