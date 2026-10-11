package queenbee.td1.avant;

import queenbee.td1.donnees.Alerte;

import java.util.Comparator;

/** Trie les alertes de la plus sûre à la moins sûre. */
public class ComparateurConfiance implements Comparator<Alerte> {

    @Override
    public int compare(Alerte a, Alerte b) {
        return Double.compare(b.confiance(), a.confiance());
    }
}
