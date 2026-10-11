package queenbee.td2.o.avant;

public class Demo {

    public static void main(String[] args) {
        EvaluateurRisques evaluateur = new EvaluateurRisques();
        System.out.println("R-01 -> " + evaluateur.evaluer(3.1, 35.0, 95));
        System.out.println("R-02 -> " + evaluateur.evaluer(0.2, 39.5, 60));
    }
}
