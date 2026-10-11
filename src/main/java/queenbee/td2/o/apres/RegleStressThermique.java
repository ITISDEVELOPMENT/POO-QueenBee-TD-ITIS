package queenbee.td2.o.apres;

public class RegleStressThermique implements RegleRisque {

    private final double temperatureMaxC;

    public RegleStressThermique(double temperatureMaxC) {
        this.temperatureMaxC = temperatureMaxC;
    }

    @Override
    public String nom() {
        return "STRESS_THERMIQUE";
    }

    @Override
    public boolean estDeclenchee(MesureRuche mesure) {
        return mesure.temperatureC() > temperatureMaxC;
    }
}
