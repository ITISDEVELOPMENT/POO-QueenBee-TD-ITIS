package queenbee.td2.o.apres;

/** Ce que tous les risques ont en commun : un nom, et une condition de déclenchement. */
public interface RegleRisque {

    String nom();

    boolean estDeclenchee(MesureRuche mesure);
}
