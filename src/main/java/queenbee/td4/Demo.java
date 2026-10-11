package queenbee.td4;

import queenbee.td4.donnees.JeuDeDonnees;

import java.util.List;
import java.util.stream.Collectors;

/** Lance toutes les versions : elles doivent afficher EXACTEMENT la même chose. */
public class Demo {

    public static void main(String[] args) {
        System.out.println("Depart  : " + new queenbee.td4.avant.Prio().top(JeuDeDonnees.MESURES, 3));
        System.out.println("Etape 1 : " + new queenbee.td4.etape1.PriorisationVisites().prioriser(JeuDeDonnees.MESURES, 3));

        List<queenbee.td4.etape2.MesureRuche> mesures2 = JeuDeDonnees.MESURES.stream()
                .map(queenbee.td4.etape2.MesureRuche::depuisTrame).collect(Collectors.toList());
        System.out.println("Etape 2 : " + new queenbee.td4.etape2.PriorisationVisites().prioriser(mesures2, 3));

        List<queenbee.td4.etape3.MesureRuche> mesures3 = JeuDeDonnees.MESURES.stream()
                .map(queenbee.td4.etape3.MesureRuche::depuisTrame).collect(Collectors.toList());
        System.out.println("Etape 3 : " + new queenbee.td4.etape3.PriorisationVisites().prioriser(mesures3, 3));

        List<queenbee.td4.apres.MesureRuche> mesures4 = JeuDeDonnees.MESURES.stream()
                .map(queenbee.td4.apres.MesureRuche::depuisTrame).collect(Collectors.toList());
        System.out.println("Apres   : " + new queenbee.td4.apres.PriorisationVisites().prioriser(mesures4, 3));
    }
}
