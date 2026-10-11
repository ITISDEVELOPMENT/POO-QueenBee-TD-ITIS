package queenbee.td3.recolte.avant;

// classe recolte
public class Rec {

    // calcule
    public String calc(String id, double v, double p) {
        double e = (v - p) / p * 100;
        if (e > 15 || e < -15) {
            return id + " : a verifier";
        } else {
            return id + " : ok";
        }
    }
}
